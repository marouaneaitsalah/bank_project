import model.BankAccount;
import model.BankaccountIMPL;
import model.IBankAccount;

public class Application
{

    public static void main(String[] args)
    {
        IBankAccount banks=new BankaccountIMPL();
        banks.addaccount(new BankAccount("AE160937","MAD",42000));
        banks.addaccount(new BankAccount("AE160938","MAD",20000));
        banks.addaccount(new BankAccount("AE160939","MAD",38000));
        System.out.println(banks.getAllAccount());
        System.out.println(banks.CheckIfExist("AE160931"));
    }
}
