import java.util.Scanner;

/**
 * Created by Szymon - Laptop on 05.04.2017.
 */
public class Main {

    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        String ss=scan.next();
        InfixtoPostfix infix=new InfixtoPostfix();
        infix.convert(ss);
        System.out.println(infix.toString());
        Calculate calculate=new Calculate();
        System.out.println(calculate.oblicz(infix.toString()));
    }
}
