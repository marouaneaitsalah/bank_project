import Business.BankAccountService;
import Business.BankAccountServiceImpl;
import Business.Condition;
import Exceptions.AccountNotFoundException;
import Utils.DataTransformationUtils;
import model.AccountStatus;
import model.BankAccount;
import model.CurrentAccount;
import model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Appli2
{
    public static void main(String[] args) throws Exception
    {
        BankAccountService accountService=new BankAccountServiceImpl();

        accountService.addBankAccount(new CurrentAccount("AM160937","MAD",42000,5000));
        accountService.addBankAccount(new SavingAccount("TH160936","MAD",92000,4.5));
        accountService.addBankAccount(new CurrentAccount("FE160938","MAD",82000,5000));
        accountService.addBankAccount(new SavingAccount("AD160939","MAD",42400,3.5));
        accountService.addBankAccount(new CurrentAccount("XE160940","MAD",46000,5000));
        accountService.addBankAccount(new SavingAccount("AB160941","MAD",45000,2.5));

        System.out.println("*********************************************");
        try
        {
            BankAccount bankAccount= accountService.getAccountbyIdStreams("AB160941");
            System.out.println(DataTransformationUtils.toJson(bankAccount));
            System.out.println("********************************************* AFTER Transfer");
            accountService.transfer("AB160941","TH1609798936",5000);
            System.out.println(DataTransformationUtils.toJson(bankAccount));
            System.out.println("********************************************* AFTER Debit");
            accountService.debit("AB160941",5000);
            System.out.println(DataTransformationUtils.toJson(bankAccount));
            System.out.println("********************************************* AFTER Credit");
            accountService.credit("AB160941",5000);
            System.out.println(DataTransformationUtils.toJson(bankAccount));

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("*********************************************");
        List<BankAccount>bankAccounts=accountService.getAllAccount();
        //bankAccounts.forEach(account -> System.out.println(account));
        bankAccounts.forEach(System.out::println);
        System.out.println("*********************************************");
        System.out.println("suite du programme");
       List<BankAccount>bb= accountService.getSavingAccounts();
        bb.forEach(account -> System.out.println(account));
        System.out.println("*********************************************");
        accountService.getCurrentAccounts()
                .stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);
        System.out.println("*********************************************");
        System.out.println(accountService.TotalBalance());

        System.out.println("*********************************************END");

        List<BankAccount> bankAccounts3 = accountService.searchAccount(acc -> acc.getStatus()
                .equals(AccountStatus.CREATED));

        bankAccounts3.stream().map(DataTransformationUtils::toJson).forEach(System.out::println);


        System.out.println("*********************************************END");

        Consumer<String> consumer=(input)->{
            System.out.println(input);
        };
        consumer.accept("hello");

    }
}

