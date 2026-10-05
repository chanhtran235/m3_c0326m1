package com.example.demo_mvc.controller;

import com.example.demo_mvc.entity.ClassCG;
import com.example.demo_mvc.entity.Student;
import com.example.demo_mvc.service.ClassService;
import com.example.demo_mvc.service.IClassService;
import com.example.demo_mvc.service.IStudentService;
import com.example.demo_mvc.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "studentController", value = "/student")
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentService();
    private IClassService classService = new ClassService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // trả về form thêm mơ
                showFormAdd(req,resp);

                // thêm mới
                break;
            case "edit":
                // thêm mới
                break;
            case "search":
                // thêm mới
                searchByName(req,resp);
                break;
            default:
                showList(req, resp);

        }


    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // trả về danh lớp học
            List<ClassCG> classCGList = classService.findAll();
            req.setAttribute("classList", classCGList );
            req.getRequestDispatcher("/views/student/add.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void searchByName(HttpServletRequest req, HttpServletResponse resp) {
        String searchName = req.getParameter("searchName");
        req.setAttribute("studentList", studentService.searchByName(searchName));
        req.setAttribute("searchName", searchName);
        try {
            req.getRequestDispatcher("views/student/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("studentList", studentService.findAll());
        try {
            req.getRequestDispatcher("views/student/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("----------post -----------------");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // gọi service lưu
                System.out.println("--------add-------------");
                save(req, resp);
                // thêm mới
                break;
            case "delete":
                deleteById(req, resp);
                break;
            default:
                ;
        }
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        studentService.deleteById(deleteId);
        try {
            resp.sendRedirect("/student?mess=Delete Success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String g = req.getParameter("gender");
        boolean gender = Boolean.parseBoolean(g);
        float score = Float.parseFloat(req.getParameter("score"));
        int classId = Integer.parseInt(req.getParameter("classId"));
        Student student = new Student(name, gender, score,classId);
        boolean isSuccess = studentService.add(student);
        String mess = "Add Not Success";

        if (isSuccess) {
            mess = "Add Success";
        }
        try {
            resp.sendRedirect("/student?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
