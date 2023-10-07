package cat.tecnocampus.fgcstations.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "userlab",
        uniqueConstraints = @UniqueConstraint(name = "UK_email", columnNames = {"email"}))
public class User implements Serializable {
    @Id
    @NotBlank
    @Size(max = 20)
    private String username;
    @Column(name = "name")
    private String name;
    @Column(name = "secondName")
    private String secondName;

    @NotBlank
    @Size(max = 50)
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<FavoriteJourney> favoriteJourneyList;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
       favoriteJourneyList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<FavoriteJourney> getFavoriteJourneyList() {
        return favoriteJourneyList;
    }

    public void setFavoriteJourneyList(List<FavoriteJourney> favoriteJourneyList) {
        this.favoriteJourneyList = favoriteJourneyList;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", favoriteJourneyList=lazy" +
                '}';
    }
}
