public class BankingAccount{
    private int accountNumber;
    private double balance;
    private Transaction[] transactionHistory;
    private int numberOfTransaction=0;
    private static int numberOfAccount = 1;
    private final static int maxTransaction=100; 

    public BankingAccount(double money){
        accountNumber = numberOfAccount;
        balance=money;
        numberOfAccount++;
        transactionHistory = new Transaction[maxTransaction];
    }
    public void addTransation(Transaction t){
        if(numberOfTransaction<maxTransaction&&((t.getAmount()>=0)||Math.abs(t.getAmount())<=balance)){
            transactionHistory[numberOfTransaction]=t;
            balance+=t.getAmount();
            numberOfTransaction++;
        }else if(numberOfTransaction<maxTransaction&&t.getAmount()<0&&Math.abs(t.getAmount())>this.balance){
            System.out.println("Not enough money to do transaction");
        }else{
            System.out.println("This account reah max Transaction");
        }
    }

    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance+=amount;
    }
    public void withdraw(double amount){
        if(balance>=amount){
            balance-=amount;
        }else{
            System.out.println("Not enough money to withdraw");
        }
    }
    public void printTransaction(){
        System.out.println("These are transaction of Account ID : "+accountNumber);
        for(int i=0;i<numberOfTransaction;i++){
            System.out.println(transactionHistory[i]);
        }
    }
    public String toString(){
        //System.out.print("Acc ID: "+accountNumber+" Balance: "+balance);
        return "Account ID: "+accountNumber+" Balance: "+balance;
    }
}