package cat.tecnocampus.fgcstations.domain;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "favorite_journey")
public class FavoriteJourney {

    @Id
    @Column(name = "favorite_journey_id")
    private String id;
    @OneToMany(mappedBy = "favoriteJourney", cascade = CascadeType.ALL)
    private List<DayTimeStart> startList;
    @ManyToOne
    @JoinColumn(name = "journey_id", nullable = false)
    private Journey journey;


    public FavoriteJourney() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DayTimeStart> getStartList() {
        return startList;
    }

    public void setDateTimeStarts(List<DayTimeStart> startList) {
        this.startList = startList;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public String toString() {
        return "FavoriteJourney{" +
                "id=" + id +
                //", startList=" + startList +
                ", journey=" + journey +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoriteJourney that = (FavoriteJourney) o;

        if (startList != null ? !startList.equals(that.startList) : that.startList != null) return false;
        return journey != null ? journey.equals(that.journey) : that.journey == null;
    }

    @Override
    public int hashCode() {
        int result = startList != null ? startList.hashCode() : 0;
        result = 31 * result + (journey != null ? journey.hashCode() : 0);
        return result;
    }
}
