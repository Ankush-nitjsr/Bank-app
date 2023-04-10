import java.util.Scanner;
import java.util.UUID;

public class WorldBankAccount implements Bank{
    private int balance;
    private String name;
    private int age;
    private int roi;// let's assume it is fixed for now 5% = 5
    private String password;
    private String accountNumber;
    Scanner sc = new Scanner(System.in);

    public WorldBankAccount() {
        System.out.println("Enter name : ");
        name = sc.next();

        System.out.println("Enter your age : ");
        age = sc.nextInt();

        System.out.println("Enter password : ");
        password = sc.next();

        System.out.println("Enter opening balance : ");
        balance = sc.nextInt();

        this.accountNumber = String.valueOf(UUID.randomUUID());
        //this.roi = getROI();
        System.out.println("Bank account created successfully for " + name);
        //System.out.println("Current account balance is INR " + balance);
    }

//    public WorldBankAccount(String name, String password) {
//        this.name = name;
//        this.password = password;
//        this.balance = 0;
//        this.accountNumber = String.valueOf(UUID.randomUUID());
//        this.roi = 5;
//    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoi() {
        return roi;
    }

    public void setRoi(int roi) {
        this.roi = roi;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public int checkBalance() {
        return this.balance;
    }

    @Override
    public Boolean addMoney() {
        System.out.println("Do you want to deposit money? Yes or No");
        String response = sc.next();
        if(response.equals("Yes")){
            System.out.println("Enter below amount to deposit :");
            int money = sc.nextInt();
            this.balance += money;
            return true;
        }
        return false;
    }

    @Override
    public Boolean withdrawMoney() {
        System.out.println("Do you want to withdraw money? Yes or No");
        String response = sc.next();
        if(response.equals("Yes")){
            System.out.println("Enter below the amount to withdraw :");
            int withdrawAmount = sc.nextInt();
            if(withdrawAmount == 0 || this.balance < withdrawAmount){
                return false;
            }
            this.balance -= withdrawAmount;
            return true;
        }
        return false;
    }

    @Override
    public int getROI() {
        System.out.println("Are you interested in taking a loan? Yes or No");
        String response = sc.next();
        if (response.equals("Yes")){
            System.out.println("Below is the rate of interest applicable for you :");

            if(this.age < 18){
                System.out.println("No loan can be given to you. Only deposit and withdrawal facility available for you");
                return 0;
            } else if (this.age > 18 && this.age < 30) {
                this.roi = 11;
                System.out.println(roi);
            } else if (this.age > 30 && this.age < 50) {
                this.roi = 10;
                System.out.println(roi);
            } else if (this.age > 50 && this.age < 62) {
                this.roi = 9;
                System.out.println(roi);
            } else {
                this.roi = 8;
                System.out.println(roi);
            }
        }
        return this.roi;
    }

    @Override
    public int totalInterest() {
        int totalInterestAmount = 0;
        System.out.println("Are you still interested in taking a loan? Yes or No");
        String response = sc.next();
        if (response.equals("Yes")){
            System.out.println("Enter below the loan amount :");
            int loanAmount = sc.nextInt();
            System.out.println("Enter below the tenure of loan in Years");
            int timeInYears = sc.nextInt();
            if(roi != 0){
                totalInterestAmount = loanAmount * roi * timeInYears / 100;
            }
            return totalInterestAmount;
        }
        if (totalInterestAmount == 0) System.out.println("You are not eligible to take a loan");
        return totalInterestAmount;
    }
}
