import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class APX3_2021_1_Q1 {
//Aluno: Leonardo Barros Egito da Silva
//Matricula: 19113050001

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//length - 1 pois a entrada consiste em 2 arquivos e o ultimo parametro = k
		int i, N = args.length-1;
		int k;
		BufferedReader in;
		Lista minhaLista = new Lista(N);
		Elemento meuElemento = null;
		k = Integer.parseInt(args[args.length-1]);
		
		try {
			//Leitura dos arquivos passados como parametro
			for(i = 0; i < N; i++) {
				in = new BufferedReader(new FileReader(args[i]));

				String linha = in.readLine();
				
				//le linhas  do arquivo
				while(linha != null) {
					String numerosTemp[] = linha.split(" ");
					//Considerando que sempre serão 2 conjuntos a serem comparados, sempre 2 arquivos de entradas
					//A solucao foi adicionar os conjuntos A e B como uma string. Porem, se fossem mais arquivos, usaria o iterador
					//Para declarar o nome dos conjuntos. No caso dessa questao achei que nao seria necessario pois sempre
					//e uma comparacao de 2 arquivos
					
					for(int cont = 0; cont < numerosTemp.length; cont++) {
						//decidi deixar o insereLista dentro de cada if por clareza
						if(i == 0) {
							meuElemento = new Elemento(Integer.parseInt(numerosTemp[cont]),"A");
							minhaLista.insereLista(meuElemento, i);

						}
						if(i == 1) {
							meuElemento = new Elemento(Integer.parseInt(numerosTemp[cont]),"B");
							minhaLista.insereLista(meuElemento, i);
						}
						
					}
					
					linha = in.readLine();

				}
				
				//Fechamento do Arquivo
				in.close();
				
				imprimePares(minhaLista.vet, k);
			}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}
	
	static void imprimePares(List<Elemento>vet[], int k) {
		
		for(int auxiliar = 0; auxiliar < vet[0].size(); auxiliar++) {
			//aqui entra o k no lugar do 9
			int valorProc = k - vet[0].get(auxiliar).num;
			
			for(int aux2 = 0; aux2 < vet[1].size(); aux2++) {

				if(vet[1].get(aux2).num == valorProc) {
					System.out.println("("+vet[0].get(auxiliar).num+","+vet[1].get(aux2).num+")");
				}
				
			}
			
		}
		
	}
	
}

class Elemento{
	int num;
	String nome_conjunto;
	
	Elemento(int num, String cjto){
		this.num = num;
		nome_conjunto = cjto;
	}
	
	public String toString() {
		return num + "";
	}
}

//Classe da ERRATA APX3 -> 19:00 - forum da disciplina
class Lista{
	List<Elemento> vet[];
	
	Lista(int N){
		vet = new ArrayList[N];
		for(int i=0; i<N;i++) {
			vet[i] = new ArrayList<Elemento>();
		}
	}
	
	void insereLista(Elemento elem, int indice) {
		if(indice < vet.length)
			vet[indice].add(elem);
	}
}
//fim