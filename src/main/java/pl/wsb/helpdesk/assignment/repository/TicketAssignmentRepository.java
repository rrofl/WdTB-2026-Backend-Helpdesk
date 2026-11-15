package pl.wsb.helpdesk.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.helpdesk.assignment.entity.TicketAssignment;
import pl.wsb.helpdesk.ticket.entity.TicketStatus;

import java.util.List;

/**
 * Repozytorium przydziałów serwisantów do zgłoszeń.
 * Nazwa {@code findByTechnician_FullName} przechodzi przez relację {@code TicketAssignment.technician}
 * do kolumny {@code technicians.full_name}.
 */
public interface TicketAssignmentRepository extends JpaRepository<TicketAssignment, Long> {

    List<TicketAssignment> findByTechnician_FullName(String fullName);

    List<TicketAssignment> findByTicket_Status(TicketStatus status);
}
