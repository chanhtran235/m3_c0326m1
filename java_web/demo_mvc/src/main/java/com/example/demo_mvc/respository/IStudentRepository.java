package com.example.demo_mvc.respository;

import com.example.demo_mvc.dto.StudentDto;
import com.example.demo_mvc.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<StudentDto> findAll();
    List<StudentDto> searchByName(String name);
    boolean add (Student student);
    boolean deleteById(int deleteId);
}
