package com.example.demo_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet",value = "/trang-chu")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // chỉnh sửa ở đây
        // khi gửi request với method = get => doGet chạy
        // có nhưng cách nào để tạo request với method get;
        // + gõ trên thanh trình duyệt
        // + click vào thẻ a
        // sử dụng form với method = get
        System.out.printf("------------doGet-----------------");;
        req.getRequestDispatcher("/home.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // chỉnh sửa ở đây
        // khi gửi request với method = post => doPost chạy
        // gưi bằng form với method = post
        System.out.printf("---------------doPost-------------");
    }
}
