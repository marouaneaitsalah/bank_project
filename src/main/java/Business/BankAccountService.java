package Business;

import Exceptions.AccountNotFoundException;
import Exceptions.BalanceNotSufficientException;
import model.BankAccount;

import java.util.List;
import java.util.function.Predicate;

public interface BankAccountService
{
    BankAccount addBankAccount(BankAccount account);
    List<BankAccount>getAllAccount();
    BankAccount getAccountbyId(String id) throws AccountNotFoundException;
    BankAccount getAccountbyIdStreams(String id)throws AccountNotFoundException ;
    void addRandomData(int size);
    void credit(String accountID,double amount)throws AccountNotFoundException;
    void debit(String accountID,double amount)throws AccountNotFoundException, BalanceNotSufficientException;
    void transfer(String accountSource,String accountDestination,double amount) throws AccountNotFoundException, BalanceNotSufficientException;
    List<BankAccount>getSavingAccounts() throws AccountNotFoundException;
    List<BankAccount>getCurrentAccounts();
    double TotalBalance();
    List<BankAccount> searchAccount(Predicate<BankAccount> condition);
}
