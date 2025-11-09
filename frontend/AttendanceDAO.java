package com.attendance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM attendance_records";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getString("roll_no"),
                        rs.getString("name"),
                        rs.getInt("total_classes"),
                        rs.getInt("attended_classes")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void updateStudent(Student s) {
        String query = "UPDATE attendance_records SET total_classes = ?, attended_classes = ? WHERE roll_no = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, s.getTotalClasses());
            pstmt.setInt(2, s.getAttendedClasses());
            pstmt.setString(3, s.getRollNo());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
