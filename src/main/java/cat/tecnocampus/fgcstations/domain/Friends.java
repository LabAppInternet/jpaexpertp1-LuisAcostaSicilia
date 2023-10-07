package cat.tecnocampus.fgcstations.domain;

import java.util.List;
import jakarta.persistence.*;
@Entity
@Table(name = "friend")
public class Friends {
    @Id
    @Column(name = "username")
    private String username;

    @ElementCollection
    @CollectionTable(name = "friend", joinColumns = @JoinColumn(name = "username"))
    @Column(name = "friend")
    private List<String> friends;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}
