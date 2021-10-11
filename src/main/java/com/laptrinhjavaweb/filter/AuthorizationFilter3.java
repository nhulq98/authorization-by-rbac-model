package com.laptrinhjavaweb.filter;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class AuthorizationFilter3 implements Filter {

    private ServletContext context;
    //private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //this.filterConfig = filterConfig;
        this.context = filterConfig.getServletContext();
        this.context.log("AuthorizationFilter init");

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
        String url = httpRequest.getRequestURI()+ "|" + httpRequest.getQueryString();
        System.out.println("URL: " + url);

        //get action value
        String actionRole =url.split("|")[1].split("=")[1];


        if(url.startsWith("/admin") ){ // URL hope
            this.context.log("Requested Resource: " + url);
            // if had login , it will return UserModel
            UserModel model = (UserModel) SessionUtil.getInstance().getValue(httpRequest, "USERMODEL"); // get data from session
            if(model == null){// no login
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login?action=login&message=not_login&alert=warning"); // require login
            }else{// had login
                // check ACTION value(this is ROLE)
                if(actionRole.equals(SystemConstant.ROLE_ADD_POST) || actionRole.equals(SystemConstant.ROLE_EDIT_POST) || actionRole.equals(SystemConstant.ROLE_DELETE_POST)
                || actionRole.equals(SystemConstant.ROLE_ADD_USER) || actionRole.equals(SystemConstant.ROLE_EDIT_USER) || actionRole.equals(SystemConstant.ROLE_DELETE_USER)
                || actionRole.equals(SystemConstant.ROLE_SET_ROLE)){
                    // process check role . have account role exists ?
                    //B1: get list roleCode
                    String listRoleCode = model.getRoleCode();
                    boolean isPresent = listRoleCode.indexOf(actionRole) != -1 ? true : false;
                    if(isPresent){ // true ==> have Roles: allow request
                        // allow go over, no hope
                        filterChain.doFilter(httpRequest, httpResponse);
                    }else{// false ==> no Role : Deny, block request
                        // deny and return alert()
                        httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin-home");
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
