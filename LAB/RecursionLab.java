/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursionlab;

/**
 *
 * @author Student
 */
public class RecursionLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        print1Ton(8);
        System.out.println("");
        printNTo1(12);
        System.out.println("");
        printOddAscending(12);
        System.out.println("");
        printOddFirstTime(22);
        System.out.println("");
        System.out.println("Fibo(10): " + fibo(10));
        System.out.println("100/5=" + divisionLoop(100, 5));
        System.out.println("100/5=" + recursiveDivision(10000, 1));
        System.out.println("3 power 4 =" + babyExponential(3, 4));
        System.out.println("2 ^ 8=" + exponential(2, 8));
        System.out.println("2 ^ -8=" + exponential(2, -8));
        System.out.println("log 512 base 2 is "+log(1050, 10));
        System.out.println("EuclidGCD(24,36) = "+EuclidGCD(24,36));
    }

    public static void print1ToN(int n) {
        if (n > 0) {
            print1ToN(n - 1);
            System.out.print(n + " ");
        }

    }

    public static void print1Ton(int n) {
        if (n == 1) {
            System.out.print(" 1 ");
        } else {
            print1ToN(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void printNTo1(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            printNTo1(n - 1);
        }

    }

    public static void printOddAscendingMe(int n) {
        if (n > 0) {
            if (n % 2 == 1) {
                printOddAscendingMe(n - 2);
                System.out.print(n + " ");
            } else {
                printOddAscendingMe(n - 1);
            }
        }
    }

    public static void printOddAscending(int n) {
        if (n <= 1) {
            System.out.print("1 ");
        } else {
            if (n % 2 == 0) {
                printOddAscending(n - 1);
            } else {
                printOddAscending(n - 2);
                System.out.print(n + " ");
            }
        }
    }

    public static void printOddFirstTime(int n) {
        if (n % 2 == 0) {
            printOddAscendingV2(n - 1);
        } else {
            printOddAscendingV2(n);
        }
    }

    public static void printOddAscendingV2(int n) {
        if (n <= 1) {
            System.out.print("1 ");
        } else {
            printOddAscending(n - 2);
            System.out.print(n + " ");
        }
    }

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
    static long[] fib = new long[100];

    public static long f(int n) {
        if (n < 2) {
            fib[n] = n;
        }
        return 454;
    }

    public static int divisionLoop(int a, int b) {
        int answer = 0;
        while (a >= b) {
            a -= b;
            answer++;
        }
        return answer;
    }

    public static int recursiveDivision(int a, int b) {
        if (b <= 0 || a < 0) {
            System.out.println("A is <0 or B is 0|| <0");
            return -1;
        }
        if (a >= b) {
            return recursiveDivision(a - b, b) + 1;
        }
        return 0;
    }

    public static int babyExponential(int a, int b) {
        int ans = 1;
        for (int i = 0; i < b; i++) {
            ans *= a;
        }
        return ans;
    }

    public static double recursiveExponential(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return recursiveExponential(a, b - 1) * a;
    }

    public static double exponential(int a, int b) {
        if (b >= 0) {
            return recursiveExponential(a, b);
        }
        return 1.0 / recursiveExponential(a, -1 * b);
    }
    
    public static int log(int a , int base){
        if(a==1){
            return 0;
        }
        if(a<base){
            return 0;
        }
        return log(a/base,base)+1;
    }
    public static int EuclidGCD(int a ,int b){
        if(a<b){
            int temp  = a;
            a=b;
            a=temp;
        }
        if(b==0){
            return a;
        }
        return EuclidGCD(b,a%b);
    }
    public static int gcd(int a ,int b){
        int commonDivisor=1;
        for (int i = 2; i < (a<b?a:b); i++) {
            if(a%i==0&&b%i==0){
                commonDivisor=i;
            }
        }
        return commonDivisor;
    }
}
