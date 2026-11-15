# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 7 · kolumny: 42 · relacje: 4 × @ManyToOne, 3 × @OneToMany, 2 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| categories | Category | 5 | — |
| device | Device | 6 | ticket_id |
| technicians | Technician | 6 | user_account_id |
| ticket_assignments | TicketAssignment | 6 | technician_id, ticket_id |
| ticket_comments | TicketComment | 6 | ticket_id |
| tickets | Ticket | 8 | category_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    categories {
        Long id PK
        String description
        Boolean is_active
        String name
        Integer sla_hours
    }
    device {
        Long id PK
        String device_type
        String model
        String serial_number
        Long ticket_id FK
        LocalDate warranty_until
    }
    technicians {
        Long id PK
        String full_name
        LocalDate hired_on
        String phone
        String specialization
        Long user_account_id FK
    }
    ticket_assignments {
        Long id PK
        LocalDateTime assigned_at
        AssignmentRole assignment_role
        BigDecimal hours_spent
        Long technician_id FK
        Long ticket_id FK
    }
    ticket_comments {
        Long id PK
        String author_name
        String content
        LocalDateTime created_at
        Boolean is_internal
        Long ticket_id FK
    }
    tickets {
        Long id PK
        String asset_tag
        Long category_id FK
        LocalDateTime created_at
        String description
        String operating_system
        TicketStatus status
        String title
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    categories ||--o{ tickets : "category_id"
    technicians ||--o{ ticket_assignments : "technician_id"
    tickets |o--o| device : "ticket_id"
    tickets ||--o{ ticket_assignments : "ticket_id"
    tickets ||--o{ ticket_comments : "ticket_id"
    user_account |o--o| technicians : "user_account_id"
```
