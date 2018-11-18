package com.vozisov.sportsschedule.model;

import com.google.gson.annotations.SerializedName;

public class EventItem {

    @SerializedName("color")
    private String color;

    @SerializedName("teacher_v2")
    private TeacherV2 teacherV2;

    @SerializedName("description")
    private String description;

    @SerializedName("appointment_id")
    private String appointmentId;

    @SerializedName("pay")
    private boolean pay;

    @SerializedName("appointment")
    private boolean appointment;

    @SerializedName("availability")
    private int availability;

    @SerializedName("teacher")
    private String teacher;

    @SerializedName("weekDay")
    private int weekDay;

    @SerializedName("service_id")
    private String serviceId;

    @SerializedName("name")
    private String name;

    @SerializedName("startTime")
    private String startTime;

    @SerializedName("place")
    private String place;

    @SerializedName("endTime")
    private String endTime;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setTeacherV2(TeacherV2 teacherV2) {
        this.teacherV2 = teacherV2;
    }

    public TeacherV2 getTeacherV2() {
        return teacherV2;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public boolean isPay() {
        return pay;
    }

    public void setAppointment(boolean appointment) {
        this.appointment = appointment;
    }

    public boolean isAppointment() {
        return appointment;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getAvailability() {
        return availability;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return
                "EventItem{" +
                        "color = '" + color + '\'' +
                        ",teacher_v2 = '" + teacherV2 + '\'' +
                        ",description = '" + description + '\'' +
                        ",appointment_id = '" + appointmentId + '\'' +
                        ",pay = '" + pay + '\'' +
                        ",appointment = '" + appointment + '\'' +
                        ",availability = '" + availability + '\'' +
                        ",teacher = '" + teacher + '\'' +
                        ",weekDay = '" + weekDay + '\'' +
                        ",service_id = '" + serviceId + '\'' +
                        ",name = '" + name + '\'' +
                        ",startTime = '" + startTime + '\'' +
                        ",place = '" + place + '\'' +
                        ",endTime = '" + endTime + '\'' +
                        "}";
    }
}