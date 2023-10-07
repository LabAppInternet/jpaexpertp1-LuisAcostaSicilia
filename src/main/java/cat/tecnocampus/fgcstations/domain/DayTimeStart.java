package cat.tecnocampus.fgcstations.domain;

import jakarta.persistence.*;
@Entity
@Table(name = "day_time_start")
public class DayTimeStart {

    @Id
    @Column(name = "daytime_id")
    private String id;
    @Column(name = "timeStart")
    private String timeStart;
    @Column(name = "day_of_week")
    private String dayOfWeek;
    @ManyToOne
    @JoinColumn(name = "favorite_journey_id", nullable = false)
    private FavoriteJourney favoriteJourney;

    public DayTimeStart() {}

    public DayTimeStart(String day, String time, String id) {
        dayOfWeek = day;
        timeStart = time;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayTimeStart that = (DayTimeStart) o;

        if (timeStart != null ? !timeStart.equals(that.timeStart) : that.timeStart != null) return false;
        return dayOfWeek != null ? dayOfWeek.equals(that.dayOfWeek) : that.dayOfWeek == null;
    }

    @Override
    public int hashCode() {
        int result = timeStart != null ? timeStart.hashCode() : 0;
        result = 31 * result + (dayOfWeek != null ? dayOfWeek.hashCode() : 0);
        return result;
    }
}
