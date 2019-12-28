package com.statestreet.test.dao;

import com.statestreet.test.HibernateTestApplicationTests;
import com.statestreet.test.dto.Course;
import com.statestreet.test.dto.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CourseRepositoryTest extends HibernateTestApplicationTests {

    @Autowired CourseRepository courseRepository;
    @Autowired StudentRepository studentRepository;

    @Test
    public void addCourse() {
        Course c1 = new Course("Electronics");
        Student s1 = new Student("stu_1");
        studentRepository.save(s1);
        Student s2 = new Student("stu_2");
        studentRepository.save(s2);
        Student s3 = new Student("stu_3");
        studentRepository.save(s3);

        c1.getStudents().add(s1);
        c1.getStudents().add(s2);
        c1.getStudents().add(s3);

        courseRepository.save(c1);
    }

    @Test
    public void removeCourse() {
        getAllCourses();
        Optional<Course> course = courseRepository.findById(7L);
        for(Student student : course.get().getStudents()) {
            student.removeCourse(course.get());

        }
        courseRepository.delete(course.get());
        getAllCourses();
    }

    private void getAllCourses() {
        courseRepository.findAll().stream().forEach(c -> {
            System.out.println("COURSE NAME : " + c.getName());
            c.getStudents().stream().forEach(s -> {
                System.out.println("STUDENT NAME : " + s.getName());
            });
        });
    }

}
