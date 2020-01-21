package com.hibernate.studentHibernate;


public interface StudentRepositoryCustom {

    Student getUserById(int id);

    String insert();
}
