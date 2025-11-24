package app;

import java.util.ArrayList;
import modelo.Pessoa;
import modelo.Sexo;
import modelo.Telefone;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		 List<Pessoa> listaDePessoas = new ArrayList<>();
	
	

	        System.out.println("--- CADASTROS ---");
	       
			for (int i = 0; i < 5; i++) {
	            System.out.println("\nCadastrando Pessoa " + (i + 1) + "/" + 5);
	            listaDePessoas.add(lerDados());
	        }

	        System.out.println("--LISTA COMPLETA DOS CADASTRADOS--");
	        imprimirLista(listaDePessoas);

	
	        System.out.println("--FUNFIONÁRIOS DO SEXO MASCULINO--");
	        imprimirLista(listaDePessoas, Sexo.MASCULINO);
	        
	        System.out.println("--FUNFIONÁRIOS DO SEXO FEMININO--");
	        imprimirLista(listaDePessoas, Sexo.FEMININO);

	        
	        imprimirListaOrdenadaPorNome(listaDePessoas);
	        imprimirListaOrdenadaPorIdade(listaDePessoas);
	        imprimirListaOrdenadaPorSexo(listaDePessoas);

	       
	        imprimirListaOrdenadaPorNomeLambda(listaDePessoas);
	        imprimirListaOrdenadaPorIdadeLambda(listaDePessoas);
	        imprimirListaOrdenadaPorSexoLambda(listaDePessoas);

	        
			scanner.close();
	        System.out.println("--- FIM ---");
	    }

	    
	    public static Pessoa lerDados() {
	        System.out.print("Digite o nome: ");
			String nome = scanner.nextLine();

	        System.out.print("Digite a idade: ");
	        int idade = Integer.parseInt(scanner.nextLine());

	        System.out.print("Informe o sexo (1 para MASCULINO, 2 para FEMININO): ");
	        int sexoOp = Integer.parseInt(scanner.nextLine());
	        Sexo sexo = (sexoOp == 1) ? Sexo.MASCULINO : Sexo.FEMININO;

	        Pessoa pessoa = new Pessoa(nome, idade, sexo);

	        System.out.print("Quantos telefones? ");
	        int qtdeTelefones = Integer.parseInt(scanner.nextLine());

	        for (int i = 0; i < qtdeTelefones; i++) {
	            System.out.print("Digite seu DDD: ");
	            String ddd = scanner.nextLine();
	            System.out.print("Digite seu Numero: ");
	            String numero = scanner.nextLine();
	            pessoa.adicionarTelefone(new Telefone(ddd, numero));
	        }

	        System.out.println("Pessoa cadastrada!");
	        return pessoa;
	    }

	    public static void imprimirLista(List<Pessoa> lista) {
	        System.out.println("---------------------------------");
	        for (Pessoa p : lista) {
	            p.imprimir();
	        }
	        System.out.println("---------------------------------");
	    }

	    // --- Filtro de sexo ---
	    public static void imprimirLista(List<Pessoa> lista, Sexo sexo) {
	        System.out.println("---------------------------------");
	        System.out.println("Filtrando por: " + sexo);
	        for (Pessoa p : lista) {
	            if (p.getSexo() == sexo) {
	                p.imprimir();
	            }
	        }
	        System.out.println("---------------------------------");
	    }

	    // --- Classes Anônimas ---
	    public static void imprimirListaOrdenadaPorNome(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);
	        
	        listaCopiada.sort(new java.util.Comparator<Pessoa>() {
	            @Override
	            public int compare(Pessoa o1, Pessoa o2) {
	                return o1.getNome().compareTo(o2.getNome());
	            }
	        });
	        
	        System.out.println("\n--- LISTA ORDENADA POR NOME (Anônima) ---");
	        imprimirLista(listaCopiada);
	    }

	    public static void imprimirListaOrdenadaPorIdade(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);

	        listaCopiada.sort(new java.util.Comparator<Pessoa>() {
	            @Override
	            public int compare(Pessoa o1, Pessoa o2) {
	                if (o1.getIdade() < o2.getIdade()) {
	                    return -1;
	                } else if (o1.getIdade() == o2.getIdade()) {
	                    return 0;
	                } else {
	                    return 1;
	                }
	            }
	        });

	        System.out.println("\n--- LISTA ORDENADA POR IDADE (Anônima) ---");
	        imprimirLista(listaCopiada);
	    }

	    public static void imprimirListaOrdenadaPorSexo(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);
	        
	        listaCopiada.sort(new java.util.Comparator<Pessoa>() {
	            @Override
	            public int compare(Pessoa o1, Pessoa o2) {
	                return o1.getSexo().compareTo(o2.getSexo());
	            }
	        });
	        
	        System.out.println("\n--- LISTA ORDENADA POR SEXO (--- Anônima ---");
	        imprimirLista(listaCopiada);
	    }

	    // --- Lambda ---
	    public static void imprimirListaOrdenadaPorNomeLambda(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);
	        
	        listaCopiada.sort( (o1, o2) -> o1.getNome().compareTo(o2.getNome()) );
	        
	        System.out.println("\n--- LISTA ORDENADA POR NOME --- Lambda ---");
	        imprimirLista(listaCopiada);
	    }

	    public static void imprimirListaOrdenadaPorIdadeLambda(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);

	        listaCopiada.sort( (o1, o2) -> Integer.compare(o1.getIdade(), o2.getIdade()) );

	        System.out.println("\n--- LISTA ORDENADA POR IDADE --- Lambda ---");
	        imprimirLista(listaCopiada);
	    }

	    public static void imprimirListaOrdenadaPorSexoLambda(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);
	        
	        listaCopiada.sort( (o1, o2) -> o1.getSexo().compareTo(o2.getSexo()) );
	        
	        System.out.println("\n--- LISTA ORDENADA POR SEXO --- Lambda ---");
	        imprimirLista(listaCopiada);
	    }
	 


     

   	// TODO Auto-generated method stub
		
	


	public static void impressao(Pessoa pessoa) {
        pessoa.imprimir();
    }
    public static void impressao(Telefone telefone) {
        telefone.imprimir();
    }
}

