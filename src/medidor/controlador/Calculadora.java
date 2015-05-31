package medidor.controlador;

import java.util.Stack;

public class Calculadora { 
	 public String expresion; 
	 public String postfijo; 
	 public String resultado; 

	 public Calculadora() {
		 expresion = ""; 
		 postfijo = "";
		 resultado = "";
	 } 

	 /*********************	INFIJO A POSTFIJO	*********************/	    
	private String transformar(){
		String infijo = depurar();
		return infPost(infijo);
	}
		    
	private String infPost(String expr)
	{
		String[] infijo = expr.split(" ");
						  
		Stack < String > inf = new Stack < String > (); 
		Stack < String > aux = new Stack < String > (); 
		Stack < String > pos = new Stack < String > (); 
		
		for (int i = infijo.length - 1; i >= 0; i--)
			inf.push(infijo[i]);
	
		try {
			while (!inf.isEmpty()) {
				switch (precedencia(inf.peek())){
					case 1:
						aux.push(inf.pop());
						break;
					case 3:
					case 4:
						while(precedencia(aux.peek()) >= precedencia(inf.peek())) {
							pos.push(aux.pop());
						}
						aux.push(inf.pop());
						break; 
					case 2:
						while(!aux.peek().equals("(")) {
							pos.push(aux.pop());
						}
						aux.pop();
						inf.pop();
						break; 
					default:
						pos.push(inf.pop()); 
				} 
			} 
			String postfix = pos.toString().replaceAll("[\\]\\[,]", "");			      
			postfijo = postfix;
		}catch(Exception ex){ 
			System.out.println("Error");
			System.err.println(ex);
		}
		return  postfijo;
	}
		    
	private String depurar() {
		String exp = expresion;
		exp = exp.replaceAll("\\s+", ""); 
		exp = "(" + exp + ")";
		String operadores = "+-*/()";
		String expLimp = "";
					  
		for (int i = 0; i < exp.length(); i++) {
			if (operadores.contains("" + exp.charAt(i)))
				expLimp += " " + exp.charAt(i) + " ";
			else expLimp += exp.charAt(i);
		}
		return expLimp.replaceAll("\\s+", " ").trim();
	} 
	
	private int precedencia(String op) 
	{
		int prf = 99;
		if (op.equals("^")) prf = 5;
		if (op.equals("*") || op.equals("/")) prf = 4;
		if (op.equals("+") || op.equals("-")) prf = 3;
		if (op.equals(")")) prf = 2;
		if (op.equals("(")) prf = 1;
		return prf;
	}
			  
	/*********************	CALCULAR	*********************/
	public String calcular(String exp) {
		expresion = exp;
		transformar();
		procesar();
		return resultado;
	}
			  
	private String procesar() {  
		String[] post = postfijo.split(" ");    
						    
		Stack < String > E = new Stack < String > (); 
		Stack < String > P = new Stack < String > (); 
		
		for (int i = post.length - 1; i >= 0; i--)
			E.push(post[i]);
		
		String operadores = "+-*/%"; 
		while (!E.isEmpty()) {
			if (operadores.contains("" + E.peek())) 
				P.push(evaluar(E.pop(), P.pop(), P.pop()) + "");
			else P.push(E.pop());
		}
		resultado = P.peek();
		return resultado;
	}
			  
	private double evaluar(String op, String n2, String n1) {
		double num1 = Double.parseDouble(n1);
		double num2 = Double.parseDouble(n2);
		if (op.equals("+")) return (num1 + num2);
		if (op.equals("-")) return (num1 - num2);
		if (op.equals("*")) return (num1 * num2);
		if (op.equals("/")) return (num1 / num2);
		if (op.equals("%")) return (num1 % num2);
		return 0;
	}		  
}