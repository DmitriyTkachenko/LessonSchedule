package scheduleApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AcademicGroup")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Basic
    private Integer numberOfStudents;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "groups")
    private List<Lesson> lessons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        String s = name;
        if (numberOfStudents != null) {
            s += " (" + numberOfStudents + ")";
        }
        return s;
    }
}
