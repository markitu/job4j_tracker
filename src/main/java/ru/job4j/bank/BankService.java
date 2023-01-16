package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу Банковского сервиса
 * Доступен функционал создания пользователя, удаления пользователя,
 * добавление нового аккаунта для пользователя, поиск пользователей по номеру паспорта и реквизитам,
 * а также перевод средств между пользователями.
 * @author Igor Mashkov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователя осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет создать нового пользователя.
     * @param user пользователь, который будет создан, только если такого пользователя нет в системе
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалить пользователя по параметру passport, если такой пользователь будет найден в системе
     * @param passport паспорт пользователя, которого требуется удалить из системы
     * @return возвращает true если пользователь был удален и false если не был
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод позволяет добавить аккаунт к существующему пользователю
     * @param passport паспорт пользователя
     * @param account аккаунт, который будет добавлен пользователю
     */
    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> userAccounts = users.get(foundUser);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя по номеру его паспорта
     * @param passport паспорт пользователя
     * @return возвращает найденного пользователя или null если пользователь не был найден
     */
    public User findByPassport(String passport) {
        User resultUser = null;
        for (User user: users.keySet()) {
            if (user.getPassport().equals(passport)) {
                resultUser = user;
                break;
            }
        }
        return resultUser;
    }

    /**
     * Метод возвращает аккаунт пользователя по номеру его паспорта и реквизитам счета
     * @param passport паспорт пользователя
     * @param requisite реквизиты счёта
     * @return возвращает аккаунт пользователя или null если пользователь не был найден
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод позволяет перевести средства с одного аккаунта на другой по реквизитам пользователя
     * @param srcPassport паспорт пользователя с аккаунта которого осуществляется перевод
     * @param srcRequisite реквизиты счёта с которого осуществляется перевод
     * @param destPassport паспорт пользователя которому осуществляется перевод
     * @param destRequisite реквизиты счёта на который осуществляется перевод
     * @param amount сумма перевода
     * @return в случае успешного перевода возвращает true, если перевод не был осуществлен, то возвращается false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает список аккаунтов пользователя
     * @param user пользователь для которого осуществляется возврат списка имеющихся аккаунтов
     * @return возвращает список аккаунтов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}