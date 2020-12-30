package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User findUserByPass = findByPassport(passport);
        if (findUserByPass != null) {
            List <Account> value = users.get(findUserByPass);
            if (!(value.contains(account))) {
                value.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User findUserByPass = findByPassport(passport);
        if (findUserByPass != null) {
            List <Account> acclist = users.get(findUserByPass);
            for (Object k : acclist) {
                Account account = (Account) k;
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc == null || destAcc == null || amount > srcAcc.getBalance()) {
            return false;
        }
        srcAcc.setBalance(srcAcc.getBalance() - amount);
        destAcc.setBalance(destAcc.getBalance() + amount);
        return rsl;
    }

    public static void main(String[] args) {
        BankService bb = new BankService();
        bb.addUser(new User("3711", "Sam"));
        bb.addAccount("3711", new Account("3fdsbb9", 140));
        bb.addAccount("3711", new Account("3fdsbb911", 10));
        bb.addAccount("3711", new Account("3fdsbb91", 10));
        System.out.println(bb.findByRequisite("3711","3fdsbb91").getRequisite());
    }
}
