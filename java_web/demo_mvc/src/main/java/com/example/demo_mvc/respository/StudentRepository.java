package com.example.demo_mvc.respository;

import com.example.demo_mvc.dto.StudentDto;
import com.example.demo_mvc.entity.Student;
import com.example.demo_mvc.util.ConnectDB;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    private final String SELECT_ALL = "select s.*,c.name as class_name from students s join classes c on s.class_id=c.id";
    private final String SEARCH_BY_NAME = "call search_by_name(?);";
    private final String INSERT_INTO = "insert into students(name,gender,score,class_id) values (?,?,?,?);";
    private final String DELETE_BY_ID = "delete from students where id =?;";
    @Override
    public List<StudentDto> findAll() {
        Connection connection = ConnectDB.getConnectDB();
        List<StudentDto> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float score = resultSet.getFloat("score");
                String className = resultSet.getString("class_name");
                students.add(new StudentDto(id,name,gender,score,className));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public List<StudentDto> searchByName(String searchName) {
        Connection connection = ConnectDB.getConnectDB();
        List<StudentDto> students = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH_BY_NAME);
            callableStatement.setString(1,searchName);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float score = resultSet.getFloat("score");
                String className = resultSet.getString("class_name");
                students.add(new StudentDto(id,name,gender,score,className));
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
            preparedStatement.setFloat(4,student.getClassId());
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
