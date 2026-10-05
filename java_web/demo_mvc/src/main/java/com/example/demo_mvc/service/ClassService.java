package com.example.demo_mvc.service;

import com.example.demo_mvc.entity.ClassCG;
import com.example.demo_mvc.respository.ClassRepository;
import com.example.demo_mvc.respository.IClassRepository;
import com.example.demo_mvc.respository.IStudentRepository;

import java.util.List;

public class ClassService implements IClassService{
    private IClassRepository classRepository = new ClassRepository();
    @Override
    public List<ClassCG> findAll() {
        return classRepository.findAll();
    }
}
