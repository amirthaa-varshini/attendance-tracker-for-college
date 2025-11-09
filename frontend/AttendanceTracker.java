package com.attendance;

import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AttendanceTracker extends Application {

    private TableView<Student> tableView;
    private ObservableList<Student> studentList;

    @Override
    public void start(Stage stage) {
        stage.setTitle("College Attendance Manager");

        tableView = new TableView<>();

        TableColumn<Student, String> rollCol = new TableColumn<>("Roll No");
        rollCol.setCellValueFactory(new PropertyValueFactory<>("rollNo"));

        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, Integer> totalCol = new TableColumn<>("Total Classes");
        totalCol.setCellValueFactory(new PropertyValueFactory<>("totalClasses"));

        TableColumn<Student, Integer> attendedCol = new TableColumn<>("Attended");
        attendedCol.setCellValueFactory(new PropertyValueFactory<>("attendedClasses"));

        TableColumn<Student, Double> percentCol = new TableColumn<>("Percentage");
        percentCol.setCellValueFactory(new PropertyValueFactory<>("percentage"));

        tableView.getColumns().addAll(rollCol, nameCol, totalCol, attendedCol, percentCol);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Red color for < 75%
        tableView.setRowFactory(tv -> new TableRow<Student>() {
            @Override
            protected void updateItem(Student student, boolean empty) {
                super.updateItem(student, empty);
                if (student == null || empty) {
                    setStyle("");
                } else if (student.getPercentage() < 75.0) {
                    setStyle("-fx-background-color: #ffb3b3;"); // light red
                } else {
                    setStyle("");
                }
            }
        });

        // Load data
        studentList = FXCollections.observableArrayList(AttendanceDAO.getAllStudents());
        tableView.setItems(studentList);

        // Buttons
        Button markPresentBtn = new Button("Mark Selected Present");
        markPresentBtn.setOnAction(e -> {
            Student selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.incrementAttendance();
                AttendanceDAO.updateStudent(selected);
                tableView.refresh();
            }
        });

        Button markAbsentBtn = new Button("Mark Selected Absent");
        markAbsentBtn.setOnAction(e -> {
            Student selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.incrementTotalClassOnly();
                AttendanceDAO.updateStudent(selected);
                tableView.refresh();
            }
        });

        Button refreshBtn = new Button("Refresh");
        refreshBtn.setOnAction(e -> studentList.setAll(AttendanceDAO.getAllStudents()));

        HBox buttons = new HBox(10, markPresentBtn, markAbsentBtn, refreshBtn);
        VBox layout = new VBox(15, tableView, buttons);
        layout.setPadding(new Insets(15));

        Scene scene = new Scene(layout, 750, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
