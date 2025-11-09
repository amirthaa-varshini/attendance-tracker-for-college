package com.attendance;

public class Student {
    private String rollNo;
    private String name;
    private int totalClasses;
    private int attendedClasses;
    private double percentage;

    public Student(String rollNo, String name, int totalClasses, int attendedClasses) {
        this.rollNo = rollNo;
        this.name = name;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
        calculatePercentage();
    }

    private void calculatePercentage() {
        if (totalClasses > 0)
            this.percentage = (attendedClasses * 100.0) / totalClasses;
        else
            this.percentage = 0.0;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public double getPercentage() {
        return percentage;
    }

    public void incrementAttendance() {
        attendedClasses++;
        totalClasses++;
        calculatePercentage();
    }

    public void incrementTotalClassOnly() {
        totalClasses++;
        calculatePercentage();
    }
}
