public class Driver {
    public static void main(String[] args) {
        System.out.println("----Test constructor----");
        Fraction c1 =new Fraction(23,72);
        Fraction c2 =new Fraction(33,0);

        Fraction a1 =new Fraction(23,72);
        Fraction a2 =new Fraction(33,72);
        System.out.println("----Test add----");
        a1.add(a2);
        a1.toString();


        Fraction s1 =new Fraction(43,72);
        Fraction s2 =new Fraction(33,72);
        System.out.println("----Test subtract----");
        s1.subtract(s2);
        s1.toString();


        Fraction m1 =new Fraction(11,72);
        Fraction m2 =new Fraction(0,72);
        System.out.println("----Test multiply----");
        m1.multiply(m2);
        m1.toString();


        Fraction d1 =new Fraction(-12,72);
        Fraction d2 =new Fraction(21,72);
        System.out.println("----Test divide----");
        d1.divide(d2);
        d1.toString();

        System.out.println("----Test reduce----");
        a1.reduce();
        a1.toString();
        s1.reduce();
        s1.toString();
        m1.reduce();
        m1.toString();
        d1.reduce();
        d1.toString();
    }
}
