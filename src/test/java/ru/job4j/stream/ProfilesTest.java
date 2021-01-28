package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void testCollect() {
        Address ad1 = new Address("Moscow", "Red Square", 4, 90);
        Address ad2 = new Address("Moscow", "Red Square", 4, 90);
        Address ad3 = new Address("New York", "123street", 111, 1);
        Address ad4 = new Address("New York", "123street", 111, 1);
        List<Address> expected = Arrays.asList(ad1,ad3);
        List<Profile> profileList = Arrays.asList(new Profile(ad1), new Profile(ad2)
                , new Profile(ad3), new Profile(ad4));
        List<Address> actual = new Profiles().collect(profileList);
        assertThat(actual, is(expected));
    }
}