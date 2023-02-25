package model;

import java.util.List;

public interface IBankAccount
{
    BankAccount addaccount(BankAccount account);
    boolean CheckIfExist(String c1);
    List<BankAccount>getAllAccount();
}
