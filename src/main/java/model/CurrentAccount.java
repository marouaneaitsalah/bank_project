package model;

public class CurrentAccount extends BankAccount
{
   private double overDraft;

    public CurrentAccount(double overDraft)
    {
        this.overDraft = overDraft;
    }

    public CurrentAccount(String accountId, String currency, double balance, double overDraft)
    {
        super(accountId, currency, balance);
        this.overDraft = overDraft;
    }

    public String getType()
    {
        return "Current Account";
    }

    @Override
    public String toString()
    {
        return "CurrentAccount{" +
                "overDraft=" + overDraft +super.toString()+
                '}';
    }
}

