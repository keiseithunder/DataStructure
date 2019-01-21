public class CheckingAccount extends BankingAccount{
    private double overDraft;
    private double currentOD=0;

    public CheckingAccount(double money,double OD){
        super(money);
        overDraft=OD;
    }

    public void paidCheck(double amount){
        if(super.getBalance()>amount){
            super.withdraw(amount);
        }else if((amount-super.getBalance())<=overDraft-currentOD){
            double temp=super.getBalance();
            super.withdraw(super.getBalance());
            currentOD+=amount-temp;
        }else{
            System.out.println("Cannot Paid. Exceed Overdraft!");
        }
    }

    public String toString(){
        return "Checking "+super.toString()+" OverDraft: "+currentOD+"/"+overDraft;
    }

}