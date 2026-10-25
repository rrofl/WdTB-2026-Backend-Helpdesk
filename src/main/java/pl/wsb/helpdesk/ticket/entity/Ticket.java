package pl.wsb.helpdesk.ticket.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "title", nullable = false, length = 65)
    private String title;

    @Column(name= "description", nullable = false, length = 650)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column (name= "status", nullable = false, length = 25)
    private TicketStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Embedded
    private DeviceDetails deviceDetails;

    protected Ticket(){
    }

    public Ticket(String title, String description, TicketStatus status, LocalDateTime createdAt, DeviceDetails deviceDetails) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.deviceDetails = deviceDetails;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public DeviceDetails getDeviceDetails() {
        return deviceDetails;
    }
}
