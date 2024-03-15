package eu.nexanet.chattify_server.model;

import eu.nexanet.chattify_server.model.enums.PostVisible;
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
@Table(name = "posts")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Column(nullable = false)
    private String data;

    @NotNull
    @Column(nullable = false)
    private Date postDate;

    @NotNull
    @Column(nullable = false)
    private PostVisible visible;

    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    private List<User> likes;

    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    private List<PostComment> comments;
}
