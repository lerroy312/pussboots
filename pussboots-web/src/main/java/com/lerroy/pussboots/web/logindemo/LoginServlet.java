/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.logindemo;

import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * Created by chunhong.pch on 17/6/17.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String sourceUrl;
        String queryString = request.getQueryString();
        if (StringUtils.isBlank(queryString) || !queryString.contains("goto=")) {
            //如果查询字符串中没有带goto参数,则默认跳转到首页
            sourceUrl = "/home";
        } else {
            //如果带了goto参数,则跳会原地址
            int begin = queryString.indexOf("goto=") + "goto=".length();
            int nextAndToken = queryString.indexOf("&", begin);
            if (nextAndToken == -1) {
                sourceUrl = queryString.substring(begin, queryString.length());
            } else {
                sourceUrl = queryString.substring(begin, nextAndToken);
            }
            sourceUrl = URLDecoder.decode(sourceUrl, "UTF-8");
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String html = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
                      + "<title>Servletdemo</title>\n" + "</head>\n" + "<body>\n"
                      + "   <form name = \"ServletDemo\" action=\"/login\" method=\"post\">\n"
                      + "   \t\t<input type=\"hidden\" name=\"goto\" value=\"%s\">\n"
                      + "   \t\t用户名:<input type = \"text\" name=\"user\"><br>\n"
                      + "   \t\t密码:<input type=\"password\" name=\"password\">\n"
                      + "   \t\t<input type=\"submit\" value=\"submit\">\n" + "   </form>\n"
                      + "</body>\n" + "</html>";
        out.println(String.format(html, sourceUrl));
        out.close();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        //验证密码正确性省略

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        String sourceUrl = request.getParameter("goto");
        response.sendRedirect(sourceUrl);

    }

}