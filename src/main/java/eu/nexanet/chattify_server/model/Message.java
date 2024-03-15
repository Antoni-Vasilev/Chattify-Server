package eu.nexanet.chattify_server.model;

import eu.nexanet.chattify_server.model.enums.MessageType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "messages")
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Column(nullable = false)
    private MessageType type;

    @NotNull
    @Column(nullable = false)
    private Date sendDate;

    @ManyToOne
    @JoinColumn(nullable = false, referencedColumnName = "id")
    private User sender;

    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    private List<React> reacts;

    private String message;

    private String data;
}
