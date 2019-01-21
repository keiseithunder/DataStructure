public class Fraction {
    private int numerator;
    private int denominator;
    private boolean isD0=false;

    public Fraction(int numerator,int denominator){
        this.numerator=numerator;
        if (denominator!=0){
            this.denominator=denominator;
        }else{
            System.out.println("Denominator cannot be 0. Please set new denominator");
            isD0=true;
        }

    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
        this.isD0 = denominator!=0;
    }

    public boolean isD0() {
        return isD0;
    }

    @Override
    public String toString() {
        System.out.println(numerator+"/"+denominator);
        return numerator+"/"+denominator;
    }

    public void add(Fraction x){
        if(!this.isD0()&&!x.isD0()) {
            if (this.getDenominator() == x.getDenominator()) {
                this.numerator += x.getNumerator();
            } else {
                int newDenominator = this.getDenominator() * x.getDenominator();
                int newNumerator = (this.getNumerator() * x.getDenominator()) + (this.getDenominator() * x.getNumerator());
                this.numerator = newNumerator;
                this.denominator = newDenominator;
            }
        }else {
            System.out.println("Fraction has 0 as denominator");
        }
    }

    public void subtract(Fraction x){
        if(!this.isD0()&&!x.isD0()) {
            if (this.getDenominator() == x.getDenominator()) {
                this.numerator -= x.getNumerator();
            } else {
                int newDenominator = this.getDenominator() * x.getDenominator();
                int newNumerator = (this.getNumerator() * x.getDenominator()) - (this.getDenominator() * x.getNumerator());
                this.numerator = newNumerator;
                this.denominator = newDenominator;
            }
        }else {
            System.out.println("Fraction has 0 as denominator");
        }
    }

    public void multiply(Fraction x){
        if(!this.isD0()&&!x.isD0()) {
            this.numerator *= x.getNumerator();
            this.denominator *= x.getDenominator();
        }else {
            System.out.println("Fraction has 0 as denominator");
        }
    }

    public void divide(Fraction x){
        if(!this.isD0()&&!x.isD0()&&x.getNumerator()!=0) {
            this.numerator *= x.getDenominator();
            this.denominator *= x.getNumerator();
        }else {
            System.out.println("Fraction has 0 as denominator or has 0 as divider ");
        }
    }

    public void reduce(){
        if(!this.isD0()) {
            int GCF = GCF(Math.abs(this.getNumerator()),Math.abs(this.getDenominator()));

            if(GCF!=0) {
                this.numerator /= GCF;
                this.denominator /= GCF;
            }
        }else {
            System.out.println("Fraction has 0 as denominator");
        }
    }

    private static int GCF(int x,int y){
        if(x>y){
            int z =x;
            x=y;
            y=z;
        }
        if(x==y){
            return x;
        }else if(x<0||y<0){
            return 1;
        }else if(x==0||y==0){
            return 0;
        }
        y-=x;
        return GCF(y,x);
    }

}
