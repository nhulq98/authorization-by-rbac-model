package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.interf.INewsService;
import com.laptrinhjavaweb.service.interf.IUserService;
import com.laptrinhjavaweb.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ResourceBundle;

import static com.laptrinhjavaweb.utils.FormUtil.mappingModel;

@WebServlet(urlPatterns = {"/home", "/login", "/logout"})
public class HomeController extends javax.servlet.http.HttpServlet {

    @Inject
    INewsService newsService;
    @Inject
    IUserService userService;

    ResourceBundle messResourceBundle = ResourceBundle.getBundle("message");

//    @Inject INewsService newsService;

    // khi ko có Dependency injection

//    private INewsService newsService;
//    private ICategoryService categoryService;
//
//    public HomeController() {
//        categoryService = new CategoryService();
//        //newsService = new NewsService();
//    }

    // Method process Login
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            String message = request.getParameter("message");
            String alert = request.getParameter("alert");
            if (message != null && alert != null) {
                String mess = "";
                try{
                    mess = messResourceBundle.getString(message);

                }catch (Exception e){
                    mess = "";
                }

                //set data to send to  view model
                request.setAttribute("message", mess);
                request.setAttribute("alert", alert);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
            dispatcher.forward(request, response);
        } else if (action != null && action.equals("logout")) {

            SessionUtil.getInstance().removeSession(request, "USERMODEL");
            response.sendRedirect(request.getContextPath() + "/login?action=login");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/home.jsp");
            dispatcher.forward(request, response);
        }

    }


    // Process login with OAuth2.0 google or Login Normal
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        // Get Action to proccess
        String action = request.getParameter("action");
        String googleAPI = request.getParameter("googleAPI");

        if(googleAPI != null && googleAPI.equals("loginWithGoogle")){
            // check user ? if not exits in db ==> insert and login else only login
//            String emailAPI = request.getParameter("emailAPI");
            //SessionUtil.getInstance().putSession(request, emailAPI, "emailAPI");
            // get gmail and get id API
            // in gmail is user name id is pass

            // get data from SUBMIT FORM(parameter)
            UserModel userModel = mappingModel(UserModel.class, request);

            userModel.setRoleId(6);// set default role = 6 ==> privilege user
            userModel.setStatus(1);// set default status = 1 ==> account actived

            // find user from submit form . this purpose is check ==> is this account exists ?
            UserModel userModel1 = userService.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(), 1);

            if(userModel1 != null){// account exists
                SessionUtil.getInstance().putSession(request, userModel1, "USERMODEL");
                response.sendRedirect(request.getContextPath() + "/home");

            }else{// account not exits
                UserModel userModel2 = userService.add(userModel); //add acount into database

                // add Model into session. this purpose is authentication and processes then
                SessionUtil.getInstance().putSession(request, userModel2, "USERMODEL");

                // default: return Page for user-normal privilege lowest
                response.sendRedirect(request.getContextPath() + "/home");
            }

            // LOGIN WITH USER AND PASSWORD NORMAL
        }else if (action != null && action.equals("login")) {
            RequestDispatcher dispatcher;

            // get data from SUBMIT FORM(parameter)
            UserModel userModel = mappingModel(UserModel.class, request);

            // Find User in database and return Model!!
            UserModel userModel1 = userService.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(), 1);

            // AUTHENTICATION(check Model data )
            if (userModel1 == null) {// user not exists

                // login fail and not allow login
                response.sendRedirect(request.getContextPath() + "/login?action=login&message=userName_password_invalid&alert=warning");
            } else { // found user
                SessionUtil.getInstance().putSession(request, userModel1, "USERMODEL");

                // check AUTHORIZATION
//                response.sendRedirect(request.getContextPath() + "/AuthorizationFilter");
                if (userModel1.getRoleModel().getCode().equals("user-user")) {
                    response.sendRedirect(request.getContextPath() + "/home");
                } else if (userModel1.getRoleModel().getCode().equals("user-admin")
                        || userModel1.getRoleModel().getCode().equals("user-ctv")
                        || userModel1.getRoleModel().getCode().equals("user-owner")) {
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                }
            }
        }
    }
}
