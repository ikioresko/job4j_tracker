package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertTest {
    @Test
    public void testConverter() {
        Student st1 = new Student(50, "Fillipov");
        Student st2 = new Student(90, "Smirnov");
        Student st3 = new Student(80, "Semenov");
        Student st4 = new Student(90, "Semenov");
        List<Student> st = new ArrayList<>();
        st.add(st1);
        st.add(st2);
        st.add(st3);
        st.add(st4);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Fillipov", st1);
        expected.put("Smirnov", st2);
        expected.put("Semenov", st3);
        Map<String, Student> actual = new Convert().converter(st);
        assertThat(actual, is(expected));
    }
}