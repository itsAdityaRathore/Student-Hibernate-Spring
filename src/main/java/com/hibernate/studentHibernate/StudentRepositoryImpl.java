package com.hibernate.studentHibernate;

import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class StudentRepositoryImpl implements StudentRepositoryCustom {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");

    @Override
    public Student getUserById(int id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student student = em.find(Student.class, id);
        em.detach(student);
        System.out.println(student.toString());

        em.close();
        return student;
    }


    @Override
    public String insert() {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student s1 = new Student("Aditya", "Rathore", "A@gmail.com");
        Student s2 = new Student("Rahul", "Jain", "R@gmail.com");

        em.persist(s1);
        em.persist(s2);
        em.getTransaction().commit();

        em.close();
        return "Insertion Successful";
    }
}
