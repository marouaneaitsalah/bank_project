package model;

public class SavingAccount extends BankAccount
{
private double interestRate=2.5;

    public SavingAccount()
    {
        super();
    }

    public SavingAccount(String accountId, String currency, double balance, double interestRate)
    {
        super(accountId, currency, balance);
        this.interestRate = interestRate;
    }

    public String getType()
    {
        return "Saving Account";
    }

    @Override
    public String toString()
    {
        return "SavingAccount{" +
                "interestRate=" + interestRate +super.toString()+
                '}';
    }
}
