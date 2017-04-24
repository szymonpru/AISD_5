import java.util.StringTokenizer;

/**
 * Created by Szymon - Laptop on 06.04.2017.
 */
public class Calculate {

    private Stos stos = new Stos();

    public Calculate(){
        stos = new Stos();
    }

    public int oblicz(String postExpression) {

        StringTokenizer st = new StringTokenizer(postExpression, " ");
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            if (!s.equals("+") && !s.equals("*") && !s.equals("-") && !s.equals("/") && !s.equals("%")) {
                int value = Integer.parseInt(s);
                stos.push(value);
            }
                else {
                int number1 =(int) stos.pop();
                int number2 =(int) stos.pop();
                switch(s.charAt(0)) {
                    case '*': {stos.push(number2 * number1); break;}
                    case '+': {stos.push(number2 + number1); break;}
                    case '-': {stos.push(number2 - number1); break;}
                    case '/': {
                        try {
                            stos.push(number2 / number1);
                        } catch (ArithmeticException e) {
                            System.out.println("Dzielenie przez 0 ");
                           // e.printStackTrace();
                            System.exit(0);
                        }
                        break;
                    }
                    case '%': {stos.push(number2 % number1); break;}
                }
            }
        }
        return (int)stos.pop();
    }
}
