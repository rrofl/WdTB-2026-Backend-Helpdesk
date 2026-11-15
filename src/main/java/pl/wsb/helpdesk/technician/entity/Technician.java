package pl.wsb.helpdesk.technician.entity;

import jakarta.persistence.*;
import pl.wsb.helpdesk.account.domain.UserAccount;
import pl.wsb.helpdesk.assignment.entity.TicketAssignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Serwisant helpdesku: dane biznesowe osoby, która obsługuje zgłoszenia.
 * Konto użytkownika (logowanie) jest osobną tabelą i jest powiązane relacją jeden-do-jednego.
 */
@Entity
@Table(name = "technicians")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    //specjalizacja np. Sieci, Active Directory, Sprzęt
    @Column(name = "specialization", nullable = false, length = 60)
    private String specialization;

    @Column(name = "hired_on", nullable = false)
    private LocalDate hiredOn;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private UserAccount account;

    @OneToMany(mappedBy = "technician")
    private List<TicketAssignment> assignments = new ArrayList<>();

    protected Technician() {
    }

    public Technician(String fullName, String phone, String specialization, LocalDate hiredOn, UserAccount account) {
        this.fullName = fullName;
        this.phone = phone;
        this.specialization = specialization;
        this.hiredOn = hiredOn;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public LocalDate getHiredOn() {
        return hiredOn;
    }

    public UserAccount getAccount() {
        return account;
    }

    public List<TicketAssignment> getAssignments() {
        return assignments;
    }
}
