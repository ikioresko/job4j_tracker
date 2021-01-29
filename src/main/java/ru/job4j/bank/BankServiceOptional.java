package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского счета.
 *
 * @author IGOR KIORESKO
 * @version 1.0
 */
public class BankServiceOptional {
    /**
     * Хранение объектов User и Account осуществляется в карте HashMap.
     * У одного User может быть несколько Account.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает объект user, добавляет объект в карту если его там нет.
     *
     * @param user пользователь которого добавляют.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает данные паспорта и account, добавляет account, если user с таким
     * паспортом существует если account не найден в коллекции List.
     *
     * @param passport данные паспорта по которым производится поиск user.
     * @param account  account который создается.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> findUserByPass = findByPassport(passport);
        if (findUserByPass.isPresent()) {
            List<Account> value = users.get(findUserByPass.get());
            if (!(value.contains(account))) {
                value.add(account);
            }
        }
    }

    /**
     * Метод принимает данные паспорта и производит поиск user.
     *
     * @param passport данные паспорта по которым производится поиск пользователя.
     * @return возвращает найденного пользователя или null если
     * пользоваель c таким паспортом не существует.
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод принимает данные паспорта и номера счета и производит
     * поиск пользователя по этим данным.
     *
     * @param passport  данные паспорта по которым производится поиск user.
     * @param requisite реквизиты счета по которым производится поиск.
     * @return возвращает найденный account или null если user с таким паспортом не найден.
     * или если account с такимим реквизитами не существует.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        if (findByPassport(passport).isPresent()) {
            User findUserByPass = findByPassport(passport).get();
            List<Account> acclist = users.get(findUserByPass);
            for (Account acc : acclist) {
                if (acc.getRequisite().equals(requisite)) {
                    rsl = Optional.of(acc);
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод принимает данные паспорта и реквизитов отправителя и получателя, сумму перевода,
     * и производит перевод денежных средств.
     *
     * @param srcPassport   данные паспорта отправителя.
     * @param srcRequisite  данные реквизитов отправителя.
     * @param destPassport  данные паспорта получателя.
     * @param destRequisite данные реквизитов получателя.
     * @param amount        сумма которую нужно перевести.
     * @return возвращает true если перевод выполнен или null, если
     * пользователь или счет не найден, возвращает null если у отправителя недостаточно средств.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent()
                && destAcc.isPresent()
                && amount > srcAcc.get().getBalance()) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        BankService bb = new BankService();
        bb.addUser(new User("3711", "Sam"));
        bb.addAccount("3711", new Account("3fdsbb9", 140));
        bb.addAccount("3711", new Account("3fdsbb911", 10));
        bb.addAccount("3711", new Account("3fdsbb91", 10));
        bb.addUser(new User("3712", "Tom"));
        bb.addAccount("3712", new Account("1125s", 0));
        Optional<Account> acc = Optional.ofNullable(bb.findByRequisite("3711", "3fdsbb9"));
        if (acc.isPresent()) {
            System.out.println(acc.get().getBalance());
        }
    }
}
