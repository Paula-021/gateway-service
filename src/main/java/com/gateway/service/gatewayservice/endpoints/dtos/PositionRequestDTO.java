package com.gateway.service.gatewayservice.endpoints.dtos;

public class PositionRequestDTO {

    private AttributesRequestDTO attributes;
    private String deviceTime;
    private double latitude;
    private double longitude;
    private double speed;
    private double course;


    public AttributesRequestDTO getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributesRequestDTO attributes) {
        this.attributes = attributes;
    }

    public String getDeviceTime() {
        return deviceTime;
    }

    public void setDeviceTime(String deviceTime) {
        this.deviceTime = deviceTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }
}
