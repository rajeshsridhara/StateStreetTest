package com.statestreet.test.dao;

import com.statestreet.test.dto.Course;
import com.statestreet.test.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    PlatformTransactionManager ptxManager;

    @Autowired
    EntityManager entityManager;

    public void saveStudentAndCourse(Student student) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        TransactionStatus transStatus = ptxManager.getTransaction(definition);
        try {
            for(Course course : student.getCourses()) {
                entityManager.persist(course);
            }
            entityManager.persist(student);
            ptxManager.commit(transStatus);
        } catch (Exception ex) {
            ptxManager.rollback(transStatus);
        }

    }

    public void deleteStudent(Long id) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        TransactionStatus transStatus = ptxManager.getTransaction(definition);

        try{
            Student student = entityManager.find(Student.class, id);
            student = entityManager.contains(student)?student:entityManager.merge(student);
            entityManager.remove(student);
            ptxManager.commit(transStatus);
        } catch (Exception ex) {
            ex.printStackTrace();
            ptxManager.rollback(transStatus);
        }
    }

    public List<Student> getStudentByCourseWithOrder (String courseName, String orderBy) {

         return entityManager.createQuery("SELECT s FROM Student s JOIN FETCH s.courses c WHERE c.name = :courseName ORDER BY LOWER(s.name) " + orderBy)
                             .setParameter("courseName", courseName)
                             .getResultList();
    }

    public List<Student> getStudentWithNoCourse() {

        return entityManager.createQuery("SELECT s FROM Student s LEFT JOIN FETCH s.courses c WHERE c IS NULL")
                            .getResultList();

    }



}
