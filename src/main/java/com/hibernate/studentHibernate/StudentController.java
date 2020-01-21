package com.hibernate.studentHibernate;//package com.hibernate.studentHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentRepositoryCustom studentRepositoryCustom;

    @GetMapping(value = "/get/{id}")
    public Student getStudent(@PathVariable(value = "id") int id) {
        return studentRepositoryCustom.getUserById(id);
    }

    @PostMapping(value = "/insert")
    public String saveStudent() {
        return studentRepositoryCustom.insert();
    }
}
