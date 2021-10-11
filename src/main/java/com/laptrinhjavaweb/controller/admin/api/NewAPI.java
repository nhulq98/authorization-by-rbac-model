package com.laptrinhjavaweb.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.interf.INewsService;
import com.laptrinhjavaweb.utils.HttpUtil;
import com.laptrinhjavaweb.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {

    @Inject
    INewsService newsService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        //B2: convert and mapping Object NewsModel
        NewsModel newsModel = jsonConvertToNews(request, response);

        //get user is loging
        newsModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
        // B3: insert database
        NewsModel newsModel2 = newsService.save(newsModel);
        // B4: send object JSON to client
        mapper.writeValue(response.getOutputStream(), newsModel2);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        //B2: convert JSON to JSON string and mapping Object NewsModel
        NewsModel newsModel = jsonConvertToNews(request, response);

        //get user is loging
        newsModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());

        // B3: update into database
        newsService.updateById(newsModel);
        // B4: send object JSON to client
        mapper.writeValue(response.getOutputStream(), newsModel);
    }

    private static NewsModel jsonConvertToNews(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        // B1: convert JSON(format BufferedReader) to JSON(format String)
        String jSON = HttpUtil.convertToString(request.getReader());
        // B1.2: import JSON String to HttpUtil
        HttpUtil httpUtil = new HttpUtil(jSON);
        // B2: mapping json string to model
        return httpUtil.mappingModel(NewsModel.class);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();

        //B2: convert and mapping Object NewsModel
        NewsModel deleteNew = jsonConvertToNews(request, response);

        // B3: delete into database
        newsService.deleteById(deleteNew);

        // B4: send object JSON to client
        mapper.writeValue(response.getOutputStream(), "{}");
    }
}
