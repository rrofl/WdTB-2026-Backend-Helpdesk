package pl.wsb.helpdesk.ticket.entity;

import jakarta.persistence.*;

@Table
public class Device {

    @Column(name="serial_number", length = 50)
    private String serial_number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_details_id")
    private DeviceDetails deviceDetails;

    protected Device() {
    }

    public Device(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getSerialNumber() {
        return serial_number;
    }

}