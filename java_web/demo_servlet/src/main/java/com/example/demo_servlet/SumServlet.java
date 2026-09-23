package com.example.demo_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SumServlet", value = {"/tinh-tong","/sum"})
public class SumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      int n1 = Integer.parseInt(req.getParameter("num1"));
      int n2 = Integer.parseInt(req.getParameter("num2"));
      int sum = n1+ n2;
      req.setAttribute("tong",sum);
      req.getRequestDispatcher("result.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
