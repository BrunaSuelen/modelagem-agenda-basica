import java.util.*;

import DAOs.*;
import classes.*;
import GUI.*;


public class Programa{

//	static Scanner t = new Scanner(System.in);
//	static TaskDAO dp = new TaskDAO();
//	static String n = "";
	
	public static void main(String args[]) {
//		lista();
		TaskListGUI t = new TaskListGUI();
	}
	
/*	public static void insere(){
		
		System.out.println(" * Cadastro *\n");
		System.out.print("Nome: ");
		p.setNome(t.nextLine());
		System.out.print("End.: ");
		p.setEndereco(t.nextLine());
		System.out.print("Fone: ");
		p.setFone(t.nextLine());
		
		dp.insere(p);
		System.out.println("Pessoa Inserida!\n\n");
	}
	
	public static void busca(){

		System.out.println(" * Consulta *\n");
		System.out.print("Nome: ");
		n = t.nextLine();
		p = dp.busca(n);
		
		if(p.getNome().equals(n)){
			System.out.println("End.: " + p.getEndereco());
			System.out.println("Fone: " + p.getFone());			
		} else {
			System.out.println("Pessoa nao encontrada!");			
		}

		System.out.println("Consulta Executada!\n\n");
	}
	
	public static void altera(){

		System.out.println(" * Alteracao *\n");

		System.out.println("Dados de: " + p.getNome());
		
		System.out.print("Nome: ");
		p.setNome(t.nextLine());
		System.out.print("End.: ");
		p.setEndereco(t.nextLine());
		System.out.print("Fone: ");
		p.setFone(t.nextLine());

		dp.altera(p, n);
		System.out.println("Dados Alterados!\n\n");
	}
	
	public static void apaga(){

		String res = "";
		System.out.println(" * Delecao *\n");
		
		System.out.println("Nome: " + p.getNome());
		System.out.println("End.: " + p.getEndereco());
		System.out.println("Fone: " + p.getFone());

		System.out.print("Confirma delecao? (S/n): ");
		res = t.nextLine();
		
		if(res.equals("S")){
			dp.apaga(p.getNome());
			System.out.println("Registro Apagado!\n\n");
		} else {
			System.out.println("Operacao Cancelada!\n\n");
		}
	} */
	
//	public static void lista(){
		
//		List<Task> lp = new ArrayList<Task>();
//		
//		lp = dp.getTasks();
//
//		System.out.println(" * Listagem *\n");
//		
//		System.out.println("------------------");
//		System.out.println("        Nome      ");
//		System.out.println("------------------");
//		
//		
//		for(int i = 0; i<lp.size();i++){
//			System.out.println(lp.get(i).getTitle());
//		}
//		System.out.println("------------------\n\n");
//
//	}
}


