package com.statestreet.test.dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany
            /*(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })*/
    @JoinTable(name = "STUDENT_COURSE",
               joinColumns = @JoinColumn(name = "STUDENT_ID"),
               inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private Set<Course> courses = new HashSet<>();

    // Changes required to record Course Record for each Student
    /*@OneToMany(mappedBy = "course")
    private Set<CourseRecord> courseRecords;*/

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public Student(Long id, String name) {
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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    // In case if student is the owner of the relationship then it is responsibility of non inverse side to maintain relationship.

    public void addCourse(Course course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
        course.getStudents().remove(this);
    }
}
