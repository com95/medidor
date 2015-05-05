package medidor.controlador;

import java.util.Stack;

public class Resolver {
    public double resolverAritmetico(String expresion)
    {
        String postfijo = new String();
        expresion = "0+"+expresion+'#';
        postfijo = in_a_pos(expresion);
        //System.out.println(postfijo);
        Stack<String>aux=pilaDeOperacion(postfijo);

        double rpta = resolverOperacion(aux);
        return rpta;
    }
    public double  resolverOperacion(Stack<String> postfijo)
    {
        double aux1,aux2,aux3, resultado;
        char ope;
        aux1 = 0; aux2 = 0; aux3 = 0; resultado = 0;

        String aux4 = new String(); ope = 0;
        Stack<String> aux5 = new Stack<String>();

        if(postfijo.size()>1)
        {
            while(postfijo.size()>1)
            {
                ope=(postfijo.peek()).charAt(0);

                if(operador(ope))
                {
                    //System.out.println(ope);
                    aux1=Double.parseDouble(aux5.peek());    /** **/
                    aux5.pop();

                    aux2=Double.parseDouble(aux5.peek());    /** **/					
                    aux5.pop();

                    aux3 = operar(aux2,aux1,ope);
                    //System.out.println(aux3);
                    postfijo.pop();

                    postfijo.push(Double.toString(aux3));
                    //System.out.println(postfijo);
                    while(!aux5.empty())
                    {						
                        postfijo.push(aux5.peek());
                        aux5.pop();
                    }
                }
                else
                {
                    aux5.push(postfijo.peek());
                    postfijo.pop();
                }
                //System.out.println(postfijo);
            }
            aux1=Double.parseDouble(aux5.peek());     /** **/
            aux5.pop();

            aux2=Double.parseDouble(aux5.peek());     /** **/
            aux5.pop();

            ope=(postfijo.peek()).charAt(0);
            postfijo.pop();

            aux3 = operar(aux2,aux1,ope);
            postfijo.push(Double.toString(aux3));
        }
        double rp = 0;
        if(postfijo!=null)
        if(postfijo.peek()!=" ")
                        rp = Double.parseDouble(postfijo.peek());
        return rp;
    }
    static int[][] m =       //devuelve la prioridad de resolucion entre dos operacdores aritmeticos
            {                      //es prioridad : 1 //no es priorotario : 0
                    { 1,1,0,0,0,0,1 },
                    { 1,1,0,0,0,0,1 },
                    { 1,1,1,1,0,0,1 },
                    { 1,1,1,1,0,0,1 },
                    { 1,1,1,1,1,0,1 },
                    { 0,0,0,0,0,0,0 }
            };
    public boolean operando (char c)      //verifica si es operando
    {
        return ( !operador(c) && c != ')' && c != '(' );
    }
    public boolean operador (char c)     //verifica si es operador
    {
        return ( c == '+' || c == '-' ||  c == '*' || c == '/' || 	c == '^'  );
    }


    public Stack<String> pilaDeOperacion(String postfijo)
    {
        Stack<String> pila = new Stack<String>();
        Stack<String> pilapiv = new Stack<String>();
        char esp='$';
        int g=0,aux=0;
        String tokens ;

        if(postfijo.indexOf(esp)>0) //si el caracter existe en la cadena
        {
            aux = postfijo.indexOf(esp,g);
            tokens = postfijo.substring(0,aux-g);
            pilapiv.push(tokens);

            g=aux;

            while(g<postfijo.length())
            {
                aux = postfijo.indexOf(esp,g+1);
                if(aux<0)
                {
                    tokens = postfijo.substring(g+1,postfijo.length());
                    pilapiv.push(tokens);
                    break;
                }else
                {
                    tokens = postfijo.substring(g+1,aux);// tokens = postfijo.substring(g+1,aux-g-1);

                    pilapiv.push(tokens);

                    g = aux;
                }
            }

            while(!pilapiv.empty())
            {

                    pila.push(pilapiv.peek());

                    pilapiv.pop();
            }
        }
        else
        {
            pila.push(postfijo);
        }


        return pila;
    }
    public boolean prioridadAritmetica (char op1,char op2)
    {
        int i,j;
        i = 0; j = 0;
        switch (op1)
        {   	case '+' :  i = 0; break;
                        case '-' :  i = 1; break;
                        case '*' :  i = 2; break;
                        case '/' :  i = 3; break;
                        case '^' :  i = 4; break;
                        case '(' :  i = 5; break;  }
        switch (op2)
        {		case '+' :  j = 0; break;
                        case '-' :  j = 1; break;
                        case '*' :  j = 2; break;
                        case '/' :  j = 3; break;
                        case '^' :  j = 4; break;
                        case '(' :  j = 5; break;
                        case ')' :  j = 6; break;	}
        return ((m [i][j])==1)?true:false;
    }


    public String in_a_pos (String infijo)  //
    {	
        Stack<Character> pila = new Stack<>();
        String postfijo;
        //stack<char> pila;
        char[] posfijo = new char[30];

        //char posfijo[30];
        int i=0,j=-1;

        while (infijo.charAt(i) != '#')
        {
            if (operando(infijo.charAt(i)) )
            {
                posfijo[++j] = infijo.charAt(i++);
            }
            else
            {
                if(posfijo[j]!='$')
                    posfijo [++j] = '$';
                while (!pila.empty() &&	prioridadAritmetica (pila.peek(),infijo.charAt(i) ) )
                {
                    if(posfijo[j]!='$')
                            posfijo [++j] = '$';
                    posfijo[++j] = pila.peek();
                    pila.pop();
                }
                if(posfijo[j]!='$')
                    posfijo [++j] = '$';
                if (infijo.charAt(i) == ')')
                    pila.pop();
                else
                {
                    pila.push(infijo.charAt(i));

                }
                i++;
            }
        }

        while (!pila.empty())
        {
            if(posfijo[j]!='$')
                posfijo [++j] = '$';
            posfijo[++j] = pila.peek();
            pila.pop();
        }

        posfijo [++j] = '\0';

        postfijo=String.copyValueOf(posfijo);
        return postfijo;
    }
    public double operar(double n1, double n2, char caract)  //+
    {
        if(caract=='+')
                return n1+n2;
        if(caract=='-')
                return n1-n2;
        if(caract=='*')
                return n1*n2;
        if(caract=='/')
                return n1/n2;
        if(caract=='^')
                return Math.pow(n1,n2);
        return 0;
    }
}
