/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.servletdemo;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chunhong.pch on 18/1/17.
 */
@WebServlet("/redirectServletDemo")
public class RedirectServletDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doResponse(request, response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doResponse(request, response);
    }

    private void doResponse(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("result", "true");
        writer.println(JSON.toJSONString(result));
        writer.close();
    }
}