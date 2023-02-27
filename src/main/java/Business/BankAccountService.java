package Business;

import model.BankAccount;

import java.util.List;

public interface BankAccountService
{
    BankAccount addBankAccount(BankAccount account);
    List<BankAccount>getAllAccount();
    BankAccount getAccountbyId(String id);
    void addRandomData(int size);
    void credit(String accountID,double amount);
    void debit(String accountID,double amount);
    void transfer(String accountSource,String accountDestination,double amount);

}
