package pl.wsb.helpdesk.category.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 55)
    private String name;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "sla_hours", nullable = false)
    private Integer slaHours;

    @Column(name = "is_active", nullable = false)
    private Boolean active;

    protected Category(){
    }

    public Category(String name, String description, Integer slaHours, Boolean active) {
        this.name = name;
        this.description = description;
        this.slaHours = slaHours;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getSlaHours() {
        return slaHours;
    }

    public Boolean getActive() {
        return active;
    }
}
