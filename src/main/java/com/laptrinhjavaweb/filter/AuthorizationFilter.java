package com.laptrinhjavaweb.filter;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.interf.IUserService;
import com.laptrinhjavaweb.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;


public class AuthorizationFilter implements Filter {

    @Inject
    IUserService userService;

    private ServletContext context;
    //private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //this.filterConfig = filterConfig;
        this.context = filterConfig.getServletContext();
        this.context.log("AuthorizationFilter init");
        // if had login , it will return UserModel

    }

    public String processTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss a");
        long millis=System.currentTimeMillis();
        java.util.Date date=new java.util.Date(millis);
        return formatter.format(date);
    }

    public void showLog(ServletRequest servletRequest) throws IOException {
        // get data form request
        String remoteAddress =  servletRequest.getRemoteAddr();
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        String protocol = servletRequest.getProtocol();
        String time = processTime();
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        String cookiesInfo = "";
        if(cookies != null){
            for(Cookie cookie : cookies){
                cookiesInfo = "::Cookie::{"+cookie.getName()+","+cookie.getValue()+"}";
                this.context.log(cookiesInfo);
            }
        }

        String infoUser =  "User Logged! " + "User IP: " + remoteAddress + " Resouce file: " + uri + " Protocol: " + protocol;
        this.context.log(time + " | " + infoUser);
        //Write file
        fileWrite("D:\\Logserver\\logWebServer.txt", time + " | " + infoUser + cookiesInfo + "\n" );
    }

    public void fileWrite(String path, String data) throws IOException {
        File file = new File(path);
        if(file != null){
            FileWriter fw = new FileWriter(file, true);
            fw.write(data);

            fw.close();
        }
    }

    public void filRead(String path) throws IOException {
        FileReader fr = new FileReader(path);
        if(fr == null){

        }else{
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        showLog(servletRequest);

        //========USE URL DO FILTER request==========
        // get URL in request of client
        String actionParameter = httpRequest.getQueryString();
        String url = httpRequest.getRequestURI()+ "|" + actionParameter;
        System.out.println("URL: " + url);

        StringBuilder actionRole = new StringBuilder();

        //get action value
        if(actionParameter != null && actionParameter.indexOf("action") != -1){// check use case: if action = null ==> no bug
            StringBuilder temp = new StringBuilder(actionParameter.split("=")[1]);
            actionRole.append(temp);// // update action
            //actionRole =actionParameter.split("=")[1];
            if(temp.indexOf("&") != -1){// found "&" in url
                actionRole.setLength(0);
                actionRole.append(temp.toString().split("&")[0]);// update action
            }
        }

        if(url.startsWith("/admin") ){ // URL hope
            this.context.log("Requested Resource: " + url);

            // if had login , it will return UserModel
            UserModel model = (UserModel) SessionUtil.getInstance().getValue(httpRequest, "USERMODEL"); // get data from session

            // load data from database: suporse check all role value if it changed
            UserModel model2 = new UserModel();
            if(model != null){// check USE CASE if user not login
                model2  = userService.findUserByID(model.getId());    
            }

            if(model2.getId() == 0){// no login
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login?action=login&message=not_login&alert=warning"); // require login
            }else{// had login
                // check ACTION value(this is ROLE)
                if(actionRole.indexOf(SystemConstant.ROLE_SEE_POSTS) != -1 || actionRole.indexOf(SystemConstant.ROLE_ADD_POST) != -1
                        || actionRole.indexOf(SystemConstant.ROLE_EDIT_POST) != -1 || actionRole.indexOf(SystemConstant.ROLE_DELETE_POST) != -1
                        || actionRole.indexOf(SystemConstant.ROLE_SEE_USERS) != -1 || actionRole.indexOf(SystemConstant.ROLE_ADD_USER) != -1
                        || actionRole.indexOf(SystemConstant.ROLE_EDIT_USER) != -1 || actionRole.indexOf(SystemConstant.ROLE_DELETE_USER) != -1
                        || actionRole.indexOf(SystemConstant.ROLE_SET_ROLE) != -1){

                    // process check role . have account role exists ?
                    //B1: get list roleCode
                    String listRoleCode = model2.getRoleCode();
                    boolean isPresent = listRoleCode.indexOf(actionRole.toString()) != -1 ? true : false;

                    if(isPresent){ // true ==> have Roles: allow request

                        // allow go over, no hope
                        filterChain.doFilter(httpRequest, httpResponse);

                    }else{// false ==> no Role : Deny, block request
                        httpResponse.setContentType("text/html;charset=UTF-8");
                        PrintWriter out = httpResponse.getWriter();
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Permission Denied');");
                        out.println("</script>");
                        // deny and return alert()
                        //httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin-home");
                    }
                }else{ // all case rest

                    // check account
                    if(model.getRoleModel().getCode().equalsIgnoreCase(SystemConstant.USER_ROLE)){// account user ==> block
                        httpResponse.sendRedirect(httpRequest.getContextPath() + "/login?action=login&message=permission_denied&alert=danger");
                    }else if(model.getRoleModel().getCode().equalsIgnoreCase(SystemConstant.ADMIN_ROLE)
                            || model.getRoleModel().getCode().equalsIgnoreCase(SystemConstant.CTV_ROLE)
                            || model.getRoleModel().getCode().equalsIgnoreCase(SystemConstant.OWNER_ROLE)){//account admin ==> allow go over
                        filterChain.doFilter(httpRequest, httpResponse);
                    }
                }

            }
        }else{ // no hope URL
            this.context.log("Requested Resource: " + url);

            // allow go over, no hope
            filterChain.doFilter(httpRequest, httpResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
