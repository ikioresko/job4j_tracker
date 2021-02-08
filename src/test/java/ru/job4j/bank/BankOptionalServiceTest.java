package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankOptionalServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankServiceOptional bank = new BankServiceOptional();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434").get(), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankServiceOptional bank = new BankServiceOptional();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("22", "5546"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankServiceOptional bank = new BankServiceOptional();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank
                .findByRequisite("3434", "5546")
                .get()
                .getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankServiceOptional bank = new BankServiceOptional();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank
                .findByRequisite(user.getPassport(), "113")
                .get()
                .getBalance(), is(200D));
    }

    @Test
    public void transferMoneyFalse() {
        User user = new User("3434", "Petr Arsentev");
        BankServiceOptional bank = new BankServiceOptional();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        boolean expected = bank
                .transferMoney(user
                        .getPassport(), "5546", user
                        .getPassport(), "1123", 150D);
        assertThat(expected, is(false));
    }
}