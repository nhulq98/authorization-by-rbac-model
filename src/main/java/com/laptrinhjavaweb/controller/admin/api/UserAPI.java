package com.laptrinhjavaweb.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.interf.IUserService;
import com.laptrinhjavaweb.utils.HttpUtil;
import com.laptrinhjavaweb.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/api-admin-user"})
public class UserAPI extends HttpServlet {

    @Inject
    IUserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        //B2: convert and mapping Object NewsModel
        UserModel userModel = jsonConvertToUser(request, response);

        // get user current(User is loging)
        //UserModel userModel1 = ((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName();
        userModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());

        // B3: insert database
        UserModel userModel2 = userService.save(userModel);

        // B4: send object JSON to client
        mapper.writeValue(response.getOutputStream(), userModel2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        //B2: convert JSON to JSON string and mapping Object NewsModel
        UserModel userModel = jsonConvertToUser(request, response);

        // get user current(User is loging)
        //UserModel userModel1 = ((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName();
        userModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());

        // B3: update into database
        userService.updateById(userModel);
        // B4: send object JSON to client
        mapper.writeValue(response.getOutputStream(), userModel);
    }

    private static UserModel jsonConvertToUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        // B1: convert JSON(format BufferedReader) to JSON(format String)
        String jSON = HttpUtil.convertToString(request.getReader());
        // B1.2: import JSON String to HttpUtil
        HttpUtil httpUtil = new HttpUtil(jSON);
        // B2: mapping json string to model
        return httpUtil.mappingModel(UserModel.class);
    }
}
