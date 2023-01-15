package entitties;

public class Client {

    private int accountNumber;
    private String name;
    private double balance;

    public Client(int accountNumber, String name, double initialDeposit){
        this.accountNumber = accountNumber;
        this.name = name;
        deposit(initialDeposit);
    }
    public Client(int accountNumber, String name){
        this.accountNumber = accountNumber;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public double getHolderDeposit(){
        return balance;
    }
    public void deposit(double holderDeposit){
        balance += holderDeposit;
    }
    public void draw(double bankDraw){
        balance -= (bankDraw + 5);
    }
    public String toString(){
        return "Account "
                + accountNumber
                + ", Holder: "
                + name
                + ", Balance: $ "
                + String.format("%.2f", balance);
    }
}