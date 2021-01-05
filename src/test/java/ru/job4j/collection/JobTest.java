package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.Matchers.is;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndProrityReverse() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityReverseP() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, is(1));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority =
                new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, is(3));
    }

    @Test
    public void whenCompatorByNameAndProrityP() {
        Comparator<Job> cmpNamePriority =
                new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, is(-1));
    }

    @Test
    public void whenCompatorByPriority() {
        List<Job> exp = new ArrayList<Job>();
        exp.add(new Job("Impl task", 0));
        exp.add(new Job("Fix bug", 1));
        List<Job> cmpNamePriority = new ArrayList<Job>();
        cmpNamePriority.add(new Job("Impl task", 0));
        cmpNamePriority.add(new Job("Fix bug", 1));
        Collections.sort(cmpNamePriority, new JobAscByPriority());
        assertThat(cmpNamePriority, is(exp));
    }

    @Test
    public void whenCompatorByPriorityReverse() {
        List<Job> exp = new ArrayList<Job>();
        exp.add(new Job("Fix bug", 1));
        exp.add(new Job("Impl task", 0));
        List<Job> cmpNamePriority = new ArrayList<Job>();
        cmpNamePriority.add(new Job("Impl task", 0));
        cmpNamePriority.add(new Job("Fix bug", 1));
        Collections.sort(cmpNamePriority, new JobDescByPriority());
        assertThat(cmpNamePriority, is(exp));
    }

    @Test
    public void whenCompatorByName() {
        List<Job> exp = new ArrayList<Job>();
        exp.add(new Job("Fix bug", 1));
        exp.add(new Job("Impl task", 0));
        List<Job> cmpName = new ArrayList<Job>();
        cmpName.add(new Job("Impl task", 0));
        cmpName.add(new Job("Fix bug", 1));
        Collections.sort(cmpName, new JobAscByName());
        assertThat(cmpName, is(exp));
    }

    @Test
    public void whenCompatorByNameReverse() {
        List<Job> exp = new ArrayList<Job>();
        exp.add(new Job("Impl task", 10));
        exp.add(new Job("Fix bug", 1));
        List<Job> cmpName = new ArrayList<Job>();
        cmpName.add(new Job("Impl task", 10));
        cmpName.add(new Job("Fix bug", 1));
        Collections.sort(cmpName, new JobDescByName());
        assertThat(cmpName, is(exp));
    }
}