package com.statestreet.test.dao;

import com.statestreet.test.HibernateTestApplicationTests;
import com.statestreet.test.dto.Course;
import com.statestreet.test.dto.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class StudentRepositoryTest extends HibernateTestApplicationTests {

    @Autowired StudentRepository studentRepository;

    @Autowired CourseRepository courseRepository;

    @Test
    public void removeStudent() {
        getStudent();
        studentRepository.deleteById(1l);
        getStudent();
    }

    //@Test
    public void getStudent() {
        List<Student> stuLst = studentRepository.findAll();
        stuLst.stream().forEach(s -> {
            System.out.println("Student Name : " + s.getName());
            s.getCourses().stream().forEach(c -> {
                System.out.println("Course Name : " + c.getName());
            });
        });
    }

    @Test
    public void deleteStudent() {
        getStudent();
        Student s1 = studentRepository.getOne(2l);

        studentRepository.deleteById(2l);
        getStudent();
    }

    @Test
    public void addStudentAndCourses() throws InterruptedException {
       Student student = new Student();
       student.setName("RamaKrishnaRao");

       Course course = new Course();
       course.setName("Physics");
       courseRepository.save(course);

       student.getCourses().add(course);

        /*Course c1 = new Course();
        c1.setName("Chemistry");

        courseRepository.save(c1);*/

       studentRepository.save(student);

        System.out.println("***********************************************************");
        System.out.println("Student Saved.....................");
        System.out.println("***********************************************************");

        System.out.println("************** Getting From DATABASE");

        List<Student> studentLst = studentRepository.findAll();

        studentLst.stream().forEach(e -> {
            System.out.println("***** Student Name : " + student.getId() + "_" + student.getName());
            System.out.println("***** Course Details : " );
            e.getCourses().stream().forEach(m -> System.out.println("***** Course Name : " + m.getId()+"_"+m.getName()));
        });

       // TimeUnit.MINUTES.sleep(2);

    }
}
