package pl.wsb.helpdesk.comment.entity;

import jakarta.persistence.*;
import pl.wsb.helpdesk.ticket.entity.Ticket;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_comments")
public class TicketComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "author_name", nullable = false, length = 100)
    private String authorName;

    //czy ten komenatarz jest do wgladu przez zwyklych userow czy tylko przez adminow
    @Column(name = "is_internal", nullable = false)
    private Boolean internalNote;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "comments", nullable = false)
    private Ticket ticket;

    protected TicketComment() {
    }

    public TicketComment(String content, String authorName, Boolean internalNote, LocalDateTime createdAt) {
        this.content = content;
        this.authorName = authorName;
        this.internalNote = internalNote;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Boolean getInternalNote() {
        return internalNote;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Ticket getTicket() {
        return ticket;
    }
}