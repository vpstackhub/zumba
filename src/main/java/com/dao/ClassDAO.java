package com.dao;

import com.model.Class;
import com.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {

    public void addClass(Class zumbaClass) {
        String sql = "INSERT INTO classes (student_id, class_time) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, zumbaClass.getStudentId());
            stmt.setTimestamp(2, new Timestamp(zumbaClass.getClassTime().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Class> getAllClasses() {
        List<Class> classes = new ArrayList<>();
        String sql = "SELECT * FROM classes";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                classes.add(new Class(rs.getInt("id"), rs.getInt("student_id"), rs.getTimestamp("class_time")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }

    public void updateClass(Class zumbaClass) {
        String sql = "UPDATE classes SET student_id = ?, class_time = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, zumbaClass.getStudentId());
            stmt.setTimestamp(2, new Timestamp(zumbaClass.getClassTime().getTime()));
            stmt.setInt(3, zumbaClass.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClass(int id) {
        String sql = "DELETE FROM classes WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
