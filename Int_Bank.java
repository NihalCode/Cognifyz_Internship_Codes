class BankAccount
{
    private int balance =0;

    // Synchronized method to prevent concurrent access issues
    public synchronized void deposit(int amount)
    {
        balance += amount;
        System.out.println("Deposited amount "+ amount +" Updated balance "+balance);
    }
    public synchronized void withdraw(int amount)
    {
        if(balance>=amount)
        {
            balance-=amount;
            System.out.println("Withdraw: "+ amount+ " Updated balance "+balance);
        }
        else
        {
            System.out.println("Insufficient balance");
        }
    }
    public int getbalance()
    {
        return balance;
    }
}
// to handle deposit operations in a separate thread
class Deposit implements Runnable
{
    private BankAccount account;
    private int amount;

    public Deposit (BankAccount account, int amount)
    {
        this.account = account;
        this.amount = amount;
    }

    // run method contains code to be executed by the thread
    @Override
    public void run()
    {
        account.deposit(amount);
    }
}
// to handle withdraw operations in a separate thread
class Withdraw implements Runnable
{
    private BankAccount account;
    private int amount;

    public Withdraw (BankAccount account, int amount)
    {
        this.account = account;
        this.amount = amount;
    }

    // run method contains code to be executed by the thread
    @Override
    public void run()
    {
        account.withdraw(amount);
    }
}
public class Int_Bank
{
    public static void main(String args[])
    {
        BankAccount obj = new BankAccount();

        //creating threads for depositing and withdrawing money
        // The order of execution is random and depends on the scheduling by JVM thread scheduler
        Thread dthread1 = new Thread(new Deposit(obj, 100));
        Thread dthread2 = new Thread(new Deposit(obj, 80));
        Thread wthread1 = new Thread(new Withdraw(obj, 30));
        Thread wthread2 = new Thread(new Withdraw(obj, 40));

        // starts all threads, nearly simultaneously
        dthread1.start();
        dthread2.start();
        wthread1.start();
        wthread2.start();

        try
        {
            // waits for all threads to finish
            dthread1.join();
            dthread2.join();
            wthread1.join();
            wthread2.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();// prints if the Interrupted Exception occurs
        }

        System.out.println("Final Balance "+obj.getbalance());
    }
}