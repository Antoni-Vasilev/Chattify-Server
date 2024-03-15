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
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    private String lastName;
    private String phone;
    private Date lastOpen;
    private Date createDate;

    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String password;

    private String pic_small;
    private String pic_normal;
    private String pic_square;
    private String pic;

    private String cover_small;
    private String cover_phone;
    private String cover;

    @OneToMany
    private List<Device> devices;

    @ManyToMany
    private List<User> friends;

    @OneToMany
    private List<Notification> notifications;

    @OneToMany
    private List<Chat> chats;
}
