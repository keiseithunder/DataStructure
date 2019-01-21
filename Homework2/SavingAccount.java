public class SavingAccount extends BankingAccount{
    private double interestRate;

    public SavingAccount(double money,double rate){
        super(money);
        interestRate=rate;
    }
    public void setInterestRate(double rate){
        interestRate = rate;
    }
    public double getRate(){
        return interestRate;
    }
    public double getMoney(){
        return super.getBalance()*(100.0+interestRate)/100.0;
    }
    public String toString(){
        return "Saving "+super.toString()+" Interest Rate: "+interestRate+" Your money will be :"+this.getMoney();
    }
}