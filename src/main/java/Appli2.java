import Business.BankAccountService;
import Business.BankAccountServiceImpl;
import Exceptions.AccountNotFoundException;
import model.BankAccount;
import model.CurrentAccount;
import model.SavingAccount;

import java.util.ArrayList;
import java.util.List;

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
            BankAccount bankAccount= accountService.getAccountbyId("FE16000938");
            System.out.println(bankAccount.toString());
        } catch (AccountNotFoundException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("*********************************************");
        List<BankAccount>bankAccounts=accountService.getAllAccount();
        //bankAccounts.forEach(account -> System.out.println(account));
        bankAccounts.forEach(System.out::println);
        System.out.println("*********************************************");
        System.out.println("suite du programme");



    }


}
