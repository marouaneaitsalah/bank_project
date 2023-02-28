package Business;

import Exceptions.AccountNotFoundException;
import model.BankAccount;

import java.util.ArrayList;
import java.util.List;

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
    }

    @Override
    public void addRandomData(int size)
    {

    }

    @Override
    public void credit(String accountID, double amount)
    {

    }

    @Override
    public void debit(String accountID, double amount)
    {

    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount)
    {

    }
}