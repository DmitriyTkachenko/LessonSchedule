package scheduleApp;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private List<Group> groups;

    @OneToMany
    private List<Instructor> instructors;

    @OneToMany
    private List<Auditorium> auditoriums;

    @OneToOne
    private Course course;

    private enum DayOfWeek {
        MONDAY("Понеділок"),
        TUESDAY("Вівторок"),
        WEDNESDAY("Середа"),
        THURSDAY("Четвер"),
        FRIDAY("П'ятниця"),
        SATURDAY("Субота");

        private final String displayName;

        private DayOfWeek(String s) {
            displayName = s;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    private enum Number {
        N1("1 (8:30 - 10:05)"),
        N2("2 (10:25 - 12:00)"),
        N3("3 (12:20 - 13:55)"),
        N4("4 (14:15 - 15:50)"),
        N5("5 (16:10 - 17:45)");

        private final String displayName;

        private Number(String s) {
            displayName = s;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    @Column(columnDefinition = "tinyint")
    private DayOfWeek dayOfWeek;

    @Column(columnDefinition = "tinyint")
    private Number number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }
}
