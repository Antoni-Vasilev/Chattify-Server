package eu.nexanet.chattify_server.model;

import eu.nexanet.chattify_server.model.enums.ChatTheme;
import eu.nexanet.chattify_server.model.enums.ChatType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "chats")
@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Column(nullable = false)
    private ChatType type;

    @OneToMany
    private List<Message> messages;

    @NotNull
    @Column(nullable = false)
    private ChatTheme theme;
}
