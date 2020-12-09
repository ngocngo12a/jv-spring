package lesson1.Activity5;

public class Activity5 {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(20000000);
        WithdrawThread husbandThread = new WithdrawThread("Husband", bankAccount, 15000000);
        WithdrawThread wifeThread = new WithdrawThread("Wife", bankAccount, 20000000);

        husbandThread.start();
        wifeThread.start();
    }
}
class BankAccount {
    long balance;

    public BankAccount(long balance) {
        this.balance = balance;
    }

    public static void withDraw(String threadName, long withdrawAmount, BankAccount bankAccount) {
        System.out.println(threadName + " need: " + withdrawAmount);
        if (withdrawAmount > bankAccount.balance) {
            System.out.println(threadName + " withdraw error!");
        } else {
            System.out.println(threadName + " withdraw success: " + withdrawAmount);
            bankAccount.balance -= withdrawAmount;
        }
        System.out.println(threadName + " see balance: " + bankAccount.balance);
    }
}
class WithdrawThread extends Thread {

    String threadName;
    final BankAccount bankAccount;
    int withdrawAmount;

    public WithdrawThread(String threadName, BankAccount bankAccount, int withdrawAmount) {
        this.threadName = threadName;
        this.bankAccount = bankAccount;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        try {
            synchronized (bankAccount) {
                BankAccount.withDraw(threadName, withdrawAmount, bankAccount);;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
