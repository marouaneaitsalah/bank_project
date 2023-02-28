package Business;

import model.BankAccount;

@FunctionalInterface
public interface Condition<T>
{

    boolean test(T o);
}
