package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.interf.IMailService;
import com.laptrinhjavaweb.service.interf.IUserService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-user"})
public class UserController extends HttpServlet {

    @Inject
    IUserService userService;

    @Inject
    IMailService mailService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String view = "";
        if (action != null && action.equals("edit-user")) {

            // get ID from url parameter
            long id = Long.parseLong(request.getParameter("id"));

            // load data user from database by ID
            UserModel userModel = userService.findUserByID(id);

            // set data for send to View model
            request.setAttribute(SystemConstant.MODEL, userModel);

            // web Page will return for user
            view = "/views/admin/user/edit.jsp";

        }else if(action != null && action.equals("update-user")){

            // get information user is logging
            UserModel userCurrent = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL"); // get data from session

            // get data from SUBMIT FORM(parameter)
            UserModel userUpdate = FormUtil.mappingModel(UserModel.class, request);

            // get list Old Role Code
            String listOldRoleCode = request.getParameter("oldrolecode");

            // send mail
            mailService.sendMailForRoleUpdateMethod(listOldRoleCode, userUpdate.getRoleCode(), userCurrent.getUserName(), userUpdate.getUserName());

            // get userName current(User is loging)
            userUpdate.setModifiedBy(userCurrent.getUserName());

            // B3: update into database
            UserModel userModel1 = userService.updateById(userUpdate);

            //B4: update session. surpose: refresh session of this user if user is loging
//            request.getSession().invalidate(); // do expired session .
            //remove old session cookie
//            SessionUtil.getInstance().removeSession(request, "USERMODEL");

            // add new session cookie
//            SessionUtil.getInstance().putSession(request, userModel1, "USERMODEL");

            // web Page will return for user
            response.sendRedirect(request.getContextPath() + "/admin-user?action=see-users");
        }else if (action != null && action.equals("delete-user")) {
            // delete HERE

            // web Page will return for user
            view = "/views/admin/user/delete.jsp";
//            //get ALL data to show
//            List<UserModel> userModels = userService.findAll();
//            request.setAttribute(SystemConstant.MODEL, userModels);
        }

        // response request for user
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        // get data from FORM
//        UserModel model2 = FormUtil.mappingModel(UserModel.class, request);
//
//        // check action
//        if(model2.getType().equals(SystemConstant.LIST)){// show list user
//
//        }else if(model2.getType().equals(SystemConstant.EDIT)){
//
//        }
        String action = request.getParameter("action");
        String view = "";
        if (action != null && action.equals("see-users")) {
            //mapping data(count records) from httpRequest to bean model
            UserModel model = FormUtil.mappingModel(UserModel.class, request);

            // collection all object relationship to Paging to add into Pageble. ()
            Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
                    new Sorter(model.getSortName(), model.getSortBy()));

            // get data follow by count
            List<UserModel> usersModels = userService.findAll(pageble);
            model.setTotalItems(usersModels.size());
            model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / (double) model.getMaxPageItem()));

            //get ALL data
//        List<NewsModel> newsModels = newsService.findAll();

            request.setAttribute(SystemConstant.MODEL, usersModels);
            //newsModels.get(0).getTitle();
            view = "/views/admin/user/list.jsp";
        }else if (action != null && action.equals("add-user")) {
            view = "/views/admin/user/add.jsp";
        }

        // response request for user
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);

    }
}
