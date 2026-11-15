package pl.wsb.helpdesk.ticket.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, length = 50)
    private String serialNumber;

    @Column(name = "model", nullable = false, length = 80)
    private String model;

    @Column(name = "device_type", nullable = false, length = 40)
    private String deviceType;

    @Column(name = "warranty_until")
    private LocalDate warrantyUntil;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    protected Device() {
    }

    public Device(String serialNumber, String model, String deviceType, LocalDate warrantyUntil, Ticket ticket) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.deviceType = deviceType;
        this.warrantyUntil = warrantyUntil;
        this.ticket = ticket;
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public LocalDate getWarrantyUntil() {
        return warrantyUntil;
    }

    public Ticket getTicket() {
        return ticket;
    }
}