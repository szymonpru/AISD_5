import java.util.StringTokenizer;

/**
 * Created by Szymon - Laptop on 05.04.2017.
 */
public class InfixtoPostfix {

    private Stos stos;
    private String wyrazeniePostfiksowe;

    public InfixtoPostfix() {
    }

    public void convert(String expression) {

        String wyrazenieInfiksowe = expression;
        wyrazeniePostfiksowe = "";
        stos = new Stos();
        StringTokenizer st = new StringTokenizer(wyrazenieInfiksowe, "+-*/()%", true);

        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            char znak = s.charAt(0);

            if (isInt(s)) wyrazeniePostfiksowe += s + " ";
            else if (isOperator(znak)) {
                proccessOperator(znak);
            } else {System.out.println("Wystąpił błąd");
                    System.exit(0);}
        }
        while(!stos.empty()){
            wyrazeniePostfiksowe+=stos.pop()+ " ";
        }
    }


   public int  precedence(char op){
       if(op=='+' || op=='-') return 1;
        else if(op=='*' || op=='/') return 2;
        else return -1;
   }

    private boolean isOperator(char ch){
        if(ch=='+' || ch=='*' || ch=='-' || ch=='/' || ch=='%' || ch=='(' || ch==')')return true;
        return false;
    }

    private void proccessOperator(char op){
            if(stos.empty() || op=='(')stos.push(op);
            else {
                char topOp=(char)stos.peek();
                if(precedence(op)>precedence(topOp))stos.push(op);
                else{
                while (!stos.empty() && precedence(topOp) >= precedence(op)) {
                    topOp=(char)stos.pop();
                    if (topOp=='(')break;
                    wyrazeniePostfiksowe +=topOp+ " ";
                    if(!stos.empty())topOp=(char)stos.peek();
                }
                if (op != ')')stos.push(op);
            }
        }
    }

    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public String toString() {
        return wyrazeniePostfiksowe;
    }

}
