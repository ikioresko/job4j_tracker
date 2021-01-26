package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FuncTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Func.diapason(5, 8, x -> (2 * x) + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadFunctionThenQuadResults() {
        List<Double> result = Func.diapason(5, 8, x -> ((2 * x) * (2 * x)) + (1 * x) + 0);
        List<Double> expected = Arrays.asList(105D, 150D, 203D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenIndicativeFunctionThenIndicativeResults() {
        List<Double> result = Func.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result, is(expected));
    }
}