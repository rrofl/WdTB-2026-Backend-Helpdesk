package pl.wsb.helpdesk.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.helpdesk.ticket.entity.Ticket;
import pl.wsb.helpdesk.ticket.entity.TicketStatus;

import java.util.List;

/**
 * Repozytorium zgłoszeń: interfejs bez implementacji, Spring Data buduje zapytania z nazw metod.
 * Nazwa {@code findByCategory_Name} przechodzi przez relację {@code Ticket.category}
 * do kolumny {@code categories.name}.
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByCategory_Name(String name);

    List<Ticket> findByCategory_SlaHoursLessThanEqual(Integer slaHours);

    long countByStatus(TicketStatus status);
}
