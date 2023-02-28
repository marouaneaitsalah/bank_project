package Business;

import Exceptions.AccountNotFoundException;
import Exceptions.BalanceNotSufficientException;
import model.AccountStatus;
import model.BankAccount;
import model.CurrentAccount;
import model.SavingAccount;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BankAccountServiceImpl implements BankAccountService{

    private List<BankAccount> bankAccounts=new ArrayList<BankAccount>();

    @Override
    public BankAccount addBankAccount(BankAccount account)
    {
        bankAccounts.add(account);
        return account;
    }

    @Override
    public List<BankAccount> getAllAccount()
    {
        return bankAccounts;
    }

    @Override
    public BankAccount getAccountbyId(String id) throws AccountNotFoundException
    {
        for(BankAccount bankAccount : bankAccounts){
            if(bankAccount.getAccountId().equals(id))
                return bankAccount;
        }
        throw new AccountNotFoundException("BankAccount not found");
       // bankAccounts.stream().filter((account -> account.getAccountId().equals(id))).fin;
    }

    @Override
    public void addRandomData(int size)
    {
        AccountStatus[] values=AccountStatus.values();
        Random random=new Random();

        for (int i = 0; i <size; i++)
        {
            BankAccount bankAccount;
            if(Math.random()>0.5){
                bankAccount=new CurrentAccount(UUID.randomUUID().toString(),Math.random()>0.5?"MAD":"USD",Math.random()*10000000,Math.random()*500000);
            bankAccount.setStatus(values[random.nextInt(values.length)]);
            }
                 else{
                bankAccount=new SavingAccount(UUID.randomUUID().toString(),Math.random()>0.5?"MAD":"USD",Math.random()*10000000,3+Math.random()*7);
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            }
             bankAccounts.add(bankAccount);
            }
    }

    @Override
    public void credit(String accountID, double amount) throws AccountNotFoundException
    {
        BankAccount accountbyId = getAccountbyId(accountID);
        accountbyId.setBalance(accountbyId.getBalance()+amount);
    }

    @Override
    public void debit(String accountID, double amount)throws AccountNotFoundException,BalanceNotSufficientException
    {
        BankAccount accountbyId = getAccountbyId(accountID);
        if(amount>accountbyId.getBalance())throw new BalanceNotSufficientException("Solde insuffisant");

        else
        accountbyId.setBalance(accountbyId.getBalance()-amount);
    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException
    {
         debit(accountSource,amount);
         credit(accountDestination,amount);
    }

    @Override
    public List<BankAccount> getSavingAccounts() throws AccountNotFoundException
    {
       return bankAccounts
               .stream()
               .filter(account -> account instanceof SavingAccount)
               .collect(Collectors.toList());
    }

    @Override
    public List<BankAccount> getCurrentAccounts()
    {
        return bankAccounts
                .stream()
                .filter(account -> account instanceof CurrentAccount)
                .collect(Collectors.toList());
    }


    @Override
    public double TotalBalance()
    {  /* double somme=0;
        for (BankAccount account:bankAccounts)
        {
            somme=somme+account.getBalance();
        }
        return somme;*/

    return bankAccounts
            .stream()
            .map(account -> account.getBalance())
            .reduce(0.0,(a,v)->a+v);
    }

    @Override
    public List<BankAccount> searchAccount(Predicate<BankAccount> condition)
    {
        List<BankAccount> result=new ArrayList<>();
        for(BankAccount acc:result){
            if(condition.test(acc)){
                result.add(acc);
            }
        }

        return result;
    }

    @Override
    public BankAccount getAccountbyIdStreams(String id) throws AccountNotFoundException{
        return bankAccounts
                .stream()
                .filter((account -> account.getAccountId().equals(id)))
                .findAny()
                .orElseThrow(()->new AccountNotFoundException(String.format("BankAccount %s not found",
                        id)));

    }
}