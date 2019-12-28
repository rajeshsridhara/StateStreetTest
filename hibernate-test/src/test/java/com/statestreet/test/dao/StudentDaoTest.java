package com.statestreet.test.dao;

import com.statestreet.test.HibernateTestApplicationTests;
import com.statestreet.test.dto.Course;
import com.statestreet.test.dto.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentDaoTest extends HibernateTestApplicationTests {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testSaveStudentAndCourse() {
        Student s = new Student("stu_10");
        Student s1 = new Student("stu_11");
        Student s2 = new Student(" stu_12");
        Course c1 = new Course("Chemical");
        Course c2 = new Course("Civil");
        //s.getCourses().add(c1);
        //s.getCourses().add(c2);

        //studentDao.saveStudentAndCourse(s);
        studentDao.saveStudentAndCourse(s1);
        studentDao.saveStudentAndCourse(s2);
    }

    @Test
    public void testRemoveStudent() {
        //Student student = studentDao.getStudentById(12L);
        studentDao.deleteStudent(12L);
    }

    @Test
    public void testGetStudentByCourseName() {
       List<Student> studentLst = studentDao.getStudentByCourseWithOrder("Electronics", "");

       studentLst.stream().forEach(s -> {
           System.out.println("Student Name : " + s.getName());
       });
    }

    @Test
    public void testGetStudentWithNoCourse() {
        List<Student> studentList = studentDao.getStudentWithNoCourse();

        studentList.stream().forEach(s -> {
            System.out.println("Student Name : " + s.getName());
        });
    }

    /*@Test
    public void*/
}
