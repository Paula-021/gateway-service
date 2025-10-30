package com.gateway.service.gatewayservice.endpoints.dtos;

public class GpsDataRequestDTO {
    private DeviceRequestDTO device;
    private PositionRequestDTO position;

    public DeviceRequestDTO getDevice() {
        return device;
    }

    public void setDevice(DeviceRequestDTO device) {
        this.device = device;
    }

    public PositionRequestDTO getPosition() {
        return position;
    }

    public void setPosition(PositionRequestDTO position) {
        this.position = position;
    }
}
