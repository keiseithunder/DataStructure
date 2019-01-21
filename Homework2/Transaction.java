public class Transaction{
    private int transactionNumber;
    private double amount;
    private String date; 
    private static int numberOfTransaction=1;

    public Transaction(double amount,String date){
        transactionNumber=numberOfTransaction;
        numberOfTransaction++;
        this.amount = amount;
        this.date = date;
    }

    public double getAmount(){
        return amount;
    }


    public String toString(){
        return "Transaction ID: "+transactionNumber+" Date: "+date+" Amount: "+amount;
    }

}