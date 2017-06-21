/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.servletdemo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by chunhong.pch on 17/6/18.
 */
@WebServlet("/helloWorldServletDemo")
public class HelloWorldServletDemo extends HttpServlet {
    public void init() throws ServletException {
        //可以通过在web.xml中配置Servlet参数
        super.init();
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println(servletConfig.getServletName() + "init success");
    }

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        String user = servletConfig.getInitParameter("user");
        String passwd = servletConfig.getInitParameter("passwd");
        System.out.println("user=" + user + ",passwd=" + passwd);
    }

    /**
     * 处理get请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String html = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
                      + "<title>helloworld</title>\n" + "</head>\n" + "<body>\n"
                      + "   <form name = \"helloworld\" action=\"/login\" method=\"post\">\n"
                      + "   \t\t%s\n" + "   </form>\n" + "</body>\n" + "</html>";

        StringBuilder body = new StringBuilder();
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getParameter(name);
            body.append(String.format("<div><h1>name:%s  value:%s</h1></div>", name, value));
        }

        out.println(String.format(html, body));
        out.close();
    }

    /**
     * 处理post请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }
}