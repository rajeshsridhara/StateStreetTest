package com.statestreet.test.dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "courses") //- will mark this entity as inverse side of the relationship
    /*@ManyToMany
            (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })*/
    /*@JoinTable(name = "STUDENT_COURSE",
               joinColumns = @JoinColumn(name = "COURSE_ID"),
               inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))*/
    private Set<Student> students = new HashSet<Student>();

    // Changes required to record Course Record for each Student
    /*@OneToMany(mappedBy = "student")
    private Set<CourseRecord> courseRecords;*/

    public Course() {}

    public Course(String name) {
        this.name = name;
    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
