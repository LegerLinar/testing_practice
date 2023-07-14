package com.example.test_practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UniversityTest {

    private Student student1;
    private Student student2;
    private Student student3;

    private University university;
    @BeforeEach
    public void setUp(){
        student1 = new Student("Евгений", 35, true);
        student2 = new Student("Марина", 34, false);
        student3 = new Student("Алина", 7, false);

        university = new University();

        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);
    }


    @Test
    public void getAllStudents() {


        List<Student> actual = university.getAllStudents();

        List<Student> expected = new ArrayList<Student>();

        expected.add(student1);
        expected.add(student2);
        expected.add(student3);

        assertEquals(expected, actual);
    }

    @Test
    public void getAllStudentsNotNull(){
        University university = new University();
        List<Student> actual = university.getAllStudents();

        assertNotNull(actual);

    }
    @Test
    public void getAllStudentsIsMale(){
        List<Student> actual = university.getAllStudentsByMale(true);

        List<Student> expected = new ArrayList<Student>();
        expected.add(student1);

        assertEquals(expected, actual);

    }
}
