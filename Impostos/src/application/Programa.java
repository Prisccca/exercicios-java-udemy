package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public abstract class Programa {

	public static void main(String[] args) {


		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<Contribuinte>();
		
		System.out.print("Entre com o numero de contribuintes: ");
		int N = sc.nextInt();
		
		for ( int i = 1; i <= N; i++) {
			
			System.out.println("Contribuinte #" + i + " data:");
			System.out.print("Pessoa Fisica (P) ou Pessoa Juricia (E)?");
			char ctbt = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Renda Anual:");
			Double rendaAnual = sc.nextDouble();
			
			if ( ctbt == 'P') {
				System.out.print("Gastos com Saúde: ");
				double gastosSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome,rendaAnual,gastosSaude));
			}
			else {
				System.out.print("Numero de Funcionários: ");
				Integer numeroFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome,rendaAnual,numeroFuncionarios));
			}			
			
		}
		
		System.out.println();
		System.out.println("Impostos pagos: ");
		for (Contribuinte ctbte : list) {
			System.out.println(ctbte.getNome() + ": $ " + String.format("%.2f", ctbte.imposto()));
			
		}
		
		System.out.println();
		double soma = 0.0;
		for (Contribuinte ctbte2 : list) {
			soma += ctbte2.imposto();
		}
		
		System.out.println("Impostos totais recolhidos: $ " + String.format("%.2f", soma));
		
		sc.close();
		
		

	}

}
