package servlets.dao;

import servlets.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();
}