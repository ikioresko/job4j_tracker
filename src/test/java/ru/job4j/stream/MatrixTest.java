package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void testSort() {
        Integer[][] array = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        Matrix m = new Matrix();
        List<Integer> actual = m.sort(array);
        assertThat(actual, is(expected));
    }

    @Test
    public void testSortSecond() {
        Integer[][] array = {{1, 2}, {3, 4}, {5, 6}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        Matrix m = new Matrix();
        List<Integer> actual = m.sort(array);
        assertThat(actual, is(expected));
    }
}