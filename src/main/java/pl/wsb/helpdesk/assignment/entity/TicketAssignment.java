package pl.wsb.helpdesk.assignment.entity;

import jakarta.persistence.*;
import pl.wsb.helpdesk.technician.entity.Technician;
import pl.wsb.helpdesk.ticket.entity.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Przydział serwisanta do zgłoszenia: encja łącząca relacji wiele-do-wielu
 * (jedno zgłoszenie obsługuje wielu serwisantów, jeden serwisant obsługuje wiele zgłoszeń)
 * z własnymi danymi: rolą w zespole, datą przydziału i przepracowanymi godzinami.
 */
@Entity
@Table(name = "ticket_assignments")
public class TicketAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "assignment_role", nullable = false, length = 20)
    private AssignmentRole assignmentRole;

    @Column(name = "assigned_at", nullable = false)
    private LocalDateTime assignedAt;

    @Column(name = "hours_spent", precision = 6, scale = 2)
    private BigDecimal hoursSpent;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "technician_id", nullable = false)
    private Technician technician;

    protected TicketAssignment() {
    }

    public TicketAssignment(AssignmentRole assignmentRole, LocalDateTime assignedAt, BigDecimal hoursSpent,
                            Ticket ticket, Technician technician) {
        this.assignmentRole = assignmentRole;
        this.assignedAt = assignedAt;
        this.hoursSpent = hoursSpent;
        this.ticket = ticket;
        this.technician = technician;
    }

    public Long getId() {
        return id;
    }

    public AssignmentRole getAssignmentRole() {
        return assignmentRole;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public BigDecimal getHoursSpent() {
        return hoursSpent;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Technician getTechnician() {
        return technician;
    }
}
