package com.statestreet.test.dto;

import javax.persistence.*;

@Entity
public class CourseRecord {

    @EmbeddedId
    private StudentCourse id;

    @ManyToOne
    @MapsId("STUDENT_ID")
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @ManyToOne
    @MapsId("COURSE_ID")
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    double courseRecord;

}
