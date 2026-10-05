package com.example.demo_mvc.respository;

import com.example.demo_mvc.entity.ClassCG;

import java.util.List;

public interface IClassRepository {
    List<ClassCG> findAll();
}
