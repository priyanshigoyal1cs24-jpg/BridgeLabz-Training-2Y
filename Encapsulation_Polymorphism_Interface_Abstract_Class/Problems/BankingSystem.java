interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract double calculateInterest();

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Application: $" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 1000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Application: $" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() + overdraftLimit >= 2000;
    }
}

public class BankingSystem {
    public static void processAccounts(BankAccount[] accounts) {
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
            double interest = account.calculateInterest();
            System.out.println("Interest Earned: $" + interest);

            if (account instanceof Loanable) {
                Loanable loanable = (Loanable) account;
                loanable.applyForLoan(5000);
                System.out.println("Loan Eligible: " + loanable.calculateLoanEligibility());
            }

            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = new SavingsAccount("SA1001", "Alice", 3000, 4.5);
        accounts[1] = new CurrentAccount("CA2001", "Bob", 1500, 1000);

        processAccounts(accounts);
    }
}
