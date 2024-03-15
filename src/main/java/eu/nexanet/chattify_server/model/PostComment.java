package eu.nexanet.chattify_server.model;

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
@Table(name = "postComments")
@Entity
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Column(nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(nullable = false, referencedColumnName = "id")
    private User sender;

    @NotNull
    @Column(nullable = false)
    private Date sendDate;

    @OneToMany
    private List<React> reacts;
}
