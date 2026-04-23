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
     * Хранение пользователя осуществляется в коллекции типа Map.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет создать нового пользователя.
     * @param user пользователь, который будет создан, только если такого пользователя нет в системе.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалить пользователя по параметру passport, если такой пользователь будет найден в системе.
     * @param passport паспорт пользователя, которого требуется удалить из системы.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод позволяет добавить аккаунт к существующему пользователю.
     * @param passport паспорт пользователя.
     * @param account аккаунт, который будет добавлен пользователю.
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
     * Метод осуществляет поиск пользователя по номеру его паспорта.
     * @param passport паспорт пользователя.
     * @return возвращает найденного пользователя или null если пользователь не был найден.
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
     * Метод возвращает аккаунт пользователя по номеру его паспорта и реквизитам счета.
     * @param passport паспорт пользователя.
     * @param requisite реквизиты счёта.
     * @return возвращает аккаунт пользователя или null если пользователь не был найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод позволяет перевести средства с одного аккаунта на другой по реквизитам пользователя.
     * @param sourcePassport паспорт пользователя с аккаунта которого осуществляется перевод.
     * @param sourceRequisite реквизиты счёта с которого осуществляется перевод.
     * @param destinationPassport паспорт пользователя которому осуществляется перевод.
     * @param destinationRequisite реквизиты счёта на который осуществляется перевод.
     * @param amount сумма перевода.
     * @return в случае успешного перевода возвращает true, если перевод не был осуществлен, то возвращается false.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account srcAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает список аккаунтов пользователя.
     * @param user пользователь для которого осуществляется возврат списка имеющихся аккаунтов.
     * @return возвращает список аккаунтов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}