package com.example.demo_mvc.respository;

import com.example.demo_mvc.dto.StudentDto;
import com.example.demo_mvc.entity.ClassCG;
import com.example.demo_mvc.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository implements IClassRepository{
    private final String SELECT_ALL = "select * from classes";
    @Override
    public List<ClassCG> findAll() {
        Connection connection = ConnectDB.getConnectDB();
        List<ClassCG> classCGList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                classCGList.add(new ClassCG(id,name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classCGList;
    }
}
