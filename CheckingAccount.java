import java.util.Scanner;

public class CheckingAccount {
    private double balance = 0;
    private int accNum;

    public CheckingAccount(double balance, int accNum){
        this.balance = balance;
        this.accNum = accNum;
    }
    public void deposit(double money){
        if(money<=0){
            throw new IllegalArgumentException("ERROR: Amount to deposit should be more than 0");
        }
        this.balance += money;
    }
    public void withdraw(double money){
        if(money<=0){
            throw new IllegalArgumentException("ERROR: Amount to withdraw should be more than 0");
        }
        this.balance -= money;
    }

    public double getBalance() {return balance;}
    public int getAccNum() {return accNum;}

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        CheckingAccount acc01 = new CheckingAccount(0,123456);
        System.out.println("Account No.:" + acc01.getAccNum() + "\nCurrent Balance:" + acc01.getBalance());
        try {
            System.out.print("How much to deposit: ");
            double moneyDeposit = scan.nextDouble();
            acc01.deposit(moneyDeposit);
            System.out.print("How much to withdraw: ");
            double moneyWith = scan.nextDouble();
            if(moneyWith <= moneyDeposit){
                acc01.withdraw(moneyWith);
                System.out.println("The balance after withdraw is: $" + acc01.getBalance());
            }
            if(moneyWith > moneyDeposit){
                double shortOF = moneyWith - moneyDeposit;
                try{
                    throw new InsufficientFundsException(shortOF);
                }catch(InsufficientFundsException e){System.out.println(e.getMessage());}
            }
        }catch(IllegalArgumentException e){System.out.println(e.getMessage());}
    }
}
