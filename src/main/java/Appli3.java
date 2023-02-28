import Business.BankAccountService;
import Business.BankAccountServiceImpl;
import Utils.DataTransformationUtils;
import model.BankAccount;

import java.util.List;
import java.util.stream.Stream;

public class Appli3
{
    public static void main(String[] args)
    {
        BankAccountService accountService=new BankAccountServiceImpl();
        accountService.addRandomData(20);
       /*
        accountService.getAllAccount().forEach(account->
                System.out.println(DataTransformationUtils.toJson(account)));
*/
                accountService.getAllAccount()
                .stream()
                        .map(DataTransformationUtils::toJson)
                        .forEach(System.out::println);

        System.out.println("*********************************************END");

        List<BankAccount> bankAccounts1 = accountService.searchAccount(account -> account.getBalance()>100);

        bankAccounts1.stream().map(DataTransformationUtils::toJson).forEach(System.out::println);


    }
}
