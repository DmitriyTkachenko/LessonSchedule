package scheduleApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import scheduleApp.entity.enums.LessonNumber;
import scheduleApp.entity.enums.DayOfWeek;
import scheduleApp.entity.enums.LessonType;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER)
    private @Valid List<Group> groups;

    @ManyToMany(fetch = FetchType.EAGER)
    private @Valid List<Instructor> instructors;

    @ManyToMany(fetch = FetchType.EAGER)
    private @Valid List<Auditorium> auditoriums;

    @ManyToOne(fetch = FetchType.EAGER)
    private @Valid Course course;

    @Column(columnDefinition = "tinyint", nullable = false)
    private DayOfWeek dayOfWeek;

    @Column(columnDefinition = "tinyint", nullable = false)
    private LessonNumber lessonNumber;

    @Column(columnDefinition = "tinyint")
    private LessonType lessonType;

    @JsonIgnore
    public String getInstructorsString() {
        StringBuilder sb = new StringBuilder();
        for (Instructor i : instructors) {
            sb.append(i.toString()).append(", ");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

    @JsonIgnore
    public String getAuditoriumsString() {
        StringBuilder sb = new StringBuilder();
        for (Auditorium a : auditoriums) {
            sb.append(a.toString()).append(", ");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

    @JsonIgnore
    public String getGroupsString() {
        StringBuilder sb = new StringBuilder();
        for (Group g : groups) {
            sb.append(g.toString()).append(", ");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

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

    public LessonNumber getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(LessonNumber lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }
}
