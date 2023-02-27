import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.BankAccount;
import model.CurrentAccount;

import java.util.ArrayList;
import java.util.List;

public class Application
{
    public static void main(String[] args) throws JsonProcessingException
    {
        List<BankAccount>bankAccounts=new ArrayList<BankAccount>();
        bankAccounts.add(new CurrentAccount(42000));

        System.out.println("**************************");
        for(BankAccount ba : bankAccounts){
            System.out.println(toJson(ba));
        }
    }
    public static String toJson(Object o)throws JsonProcessingException
    {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }
}
