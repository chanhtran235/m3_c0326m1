package com.example.demo_mvc.respository;

import com.example.demo_mvc.entity.Student;
import com.sun.imageio.plugins.gif.GIFImageMetadataFormat;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh", true,2.0f));
        studentList.add(new Student(2,"hải", false,7.0f));
        studentList.add(new Student(3,"tuấn", true,9.0f));
    }
    @Override
    public List<Student> findAll() {

        return studentList;
    }

    @Override
    public boolean add(Student student) {
        return studentList.add(student);
    }

    @Override
    public void deleteById(int deleteId) {
        for (int i = 0; i <studentList.size() ; i++) {
            if(studentList.get(i).getId()==deleteId){
                studentList.remove(i);
                break;
            }
        }
    }
}
