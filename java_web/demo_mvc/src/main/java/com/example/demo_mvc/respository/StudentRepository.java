package com.example.demo_mvc.respository;

import com.example.demo_mvc.entity.Student;
import com.example.demo_mvc.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    private final String SELECT_ALL = "select * from students";
    private final String INSERT_INTO = "insert into students(name,gender,score) values (?,?,?);";
    private final String DELETE_BY_ID = "delete from students where id =?;";
    static {
        studentList.add(new Student(1,"chánh", true,2.0f));
        studentList.add(new Student(2,"hải", false,7.0f));
        studentList.add(new Student(3,"tuấn", true,9.0f));
    }
    @Override
    public List<Student> findAll() {
        Connection connection = ConnectDB.getConnectDB();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float score = resultSet.getFloat("score");
                students.add(new Student(id,name,gender,score));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public boolean add(Student student) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setFloat(3,student.getScore());
            int rowEffect = preparedStatement.executeUpdate();
            return rowEffect==1;
        } catch (SQLException e) {
            System.out.println("lỗi DB");

        }
        return false;
    }

    @Override
    public boolean deleteById(int deleteId) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1,deleteId);
            int rowEffect = preparedStatement.executeUpdate();
            return rowEffect==1;
        } catch (SQLException e) {
            System.out.println("lỗi DB");

        }
        return false;
    }
}
