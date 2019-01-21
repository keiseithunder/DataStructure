public class Driver{
    public static void main(String[] args) {
        BankingAccount b1 = new BankingAccount(1000.00);
        Transaction t1 = new Transaction(500,"20/01/2018");
        Transaction t2 = new Transaction(-50,"20/01/2018");
        
        System.out.println("----Test Banking ACC----");
        System.out.println(b1);        
        System.out.println(t1);
        b1.addTransation(t1);
        b1.addTransation(t2);
        System.out.println(b1);
        b1.printTransaction();
        
        System.out.println("----Test Saving ACC----");
        SavingAccount sa1= new SavingAccount(1000, 5);
        System.out.println(sa1);
        
        System.out.println("----Test Checking ACC----");
        CheckingAccount ca1 = new CheckingAccount(1000,500);
        ca1.paidCheck(550);
        System.out.println(ca1);
        Transaction t3 = new Transaction(1000,"20/01/2018");
        ca1.addTransation(t3);
        System.out.println(ca1);
        ca1.paidCheck(1500);
        System.out.println(ca1);
        ca1.paidCheck(450);
        System.out.println(ca1);
        Transaction t4 = new Transaction(-1000,"20/01/2018");
        ca1.addTransation(t4);
        ca1.paidCheck(5);
        ca1.printTransaction();
        
    }
}