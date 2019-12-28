package com.statestreet.test.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
public class StudentCourse implements Serializable {

    @Column(name = "STUDENT_ID")
    private Long studentId;

    @Column(name = "COURSE_ID")
    private Long courseId;

}