/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.logindemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by chunhong.pch on 17/6/14.
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String html = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
                      + "<title>Servletdemo</title>\n" + "</head>\n" + "<body>\n"
                      + "   hello world! this is my home\n" + "</body>\n" + "</html>";
        out.println(html);
        out.close();
    }
}