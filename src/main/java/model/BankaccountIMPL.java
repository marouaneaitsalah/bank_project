package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BankaccountIMPL implements IBankAccount
{
    List<BankAccount>banks= new ArrayList<BankAccount>();

    public BankAccount addaccount(BankAccount account)
    {
        banks.add(account);
        return account;
    }

    public boolean CheckIfExist(String c1)
    {
        for(int i=0;i<banks.size();i++){
            if(banks.get(i).getAccountId()==c1){
                return true;
            }
            break;
        }
        return false;
    }

    public List<BankAccount> getAllAccount()
    {
        return banks;
    }
}
