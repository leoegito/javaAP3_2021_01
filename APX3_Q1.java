import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class APX3_Q1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int i, N = args.length-1;
		int k;
		//List<Lista> vet[] = new ArrayList[N];
		BufferedReader in;
		Lista minhaLista = new Lista(N);
		Elemento meuElemento = null;
		//int globalID = 0;
		
		k = Integer.parseInt(args[args.length-1]);
		
		try {
			//Leitura dos arquivos passados como parametro
			for(i = 0; i < N; i++) {
				in = new BufferedReader(new FileReader(args[i]));
				//listagemListas[i] = new Lista(i);
				String linha = in.readLine();
				
				
				//le linha por linha do arquivo
				while(linha != null) {
					String numerosTemp[] = linha.split(" ");
					//Considerando que sempre serão 2 conjuntos a serem comparados, sempre 2 arquivos de entradas
					//A solucao foi adicionar manualmente os conjuntos A e B. Porem, se fossem mais arquivos, usaria o iterador
					//Para declarar o nome dos conjuntos
					
					//int contAux = 0;
					
					for(int cont = 0; cont < numerosTemp.length; cont++) {
						//System.out.println("i = " +i);
						//System.out.println(s);
						
						if(i == 0) {
							meuElemento = new Elemento(Integer.parseInt(numerosTemp[cont]),"A");
							//System.out.println("Elemento criado A: " + meuElemento);
							//System.out.println("Adicionado na lista: ");
							//System.out.println("GlobalID = " +globalID);
							minhaLista.insereLista(meuElemento, i);
							//globalID++;
						}
						if(i == 1) {
							meuElemento = new Elemento(Integer.parseInt(numerosTemp[cont]),"B");
							//System.out.println("Elemento criado B: " + meuElemento);
							//System.out.println("Adicionado na lista: ");
							//System.out.println("GlobalID = " +globalID);
							minhaLista.insereLista(meuElemento, i);
							//globalID++;
						}
						
//						for(int aux=0; aux < minhaLista.vet.length; aux++) {
//							System.out.println(minhaLista.vet[aux]);
//						}
					}
					
//					for(String s : numerosTemp) {
//						System.out.println("i = " +i);
//						//System.out.println(s);
//						if(i == 0) {
//							meuElemento = new Elemento(Integer.parseInt(s),"A");
//							System.out.println("Elemento criado A: " + meuElemento);
//						}
//						if(i == 1) {
//							meuElemento = new Elemento(Integer.parseInt(s),"B");
//							System.out.println("Elemento criado B: " + meuElemento);
//						}
//						System.out.println("Adicionado na lista: ");
//						minhaLista.insereLista(meuElemento, contAux);
//						for(int aux=0; aux < minhaLista.vet.length; aux++) {
//							System.out.println(minhaLista.vet[aux]);
//						}
//						
//						contAux++;
//					}
					
//					System.out.println("--- Lista até agora: ---");
//					System.out.println(minhaLista.get(i));
					linha = in.readLine();

				}
				
				//Elemento meuElemento = new Elemento();
				in.close();
				
//				for(List<Elemento> saidaLista : minhaLista.vet) {
//					for(int j = 0; j<minhaLista.vet.length; j++) {
//						System.out.println(saidaLista.get(j));
//					}
//				}
				//System.out.println("Metodo criado no improviso: ");
				//minhaLista.imprimeLista();
				
//				System.out.println("tentativa manual: ");
//				for(List<Elemento> saidaLista: minhaLista.vet) {
//					for(Elemento element : saidaLista) {
//						System.out.println(element);
//						System.out.println(element.nome_conjunto);
//						
//					}
//				}
				
//				for(int auxiliar = 0; auxiliar < minhaLista.vet[0].size(); auxiliar++) {
//					//aqui entra o k no lugar do 9
//					int valorProc = 9 - minhaLista.vet[0].get(auxiliar).num;
//					
//					for(int aux2 = 0; aux2 < minhaLista.vet[1].size(); aux2++) {
//
//						if(minhaLista.vet[1].get(aux2).num == valorProc) {
//							System.out.println("("+minhaLista.vet[0].get(auxiliar).num+","+minhaLista.vet[1].get(aux2).num+")");
//						}
//						
//					}
//					
//				}
				
//				for(int aux2 = 0; aux2 < minhaLista.vet[0].size(); aux2++) {
//					//int valorProc = k - minhaLista.vet[0].get(CONT).num
//					if(minhaLista.vet[1].get(aux2).num < 0) {
//						
//					}
//				}
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
		
//		System.out.println(vet[0].size());
//		System.out.println(k);
		
	}
	
	public void encontraPares() {
		
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
	
//	public void imprimeLista() {
//		for(int k=0; k<vet.length; k++) {
//			System.out.println("k = " +k);
//			for(int kk = 0; kk<vet[k].size(); kk++) {
//				//System.out.println("k = " +k);
//				System.out.println("kk = " +kk);
//				System.out.println(vet[k].get(kk));
//			}
//			for(Elemento e : vet[k]) {
//				System.out.println("tentativa elemento");
//				System.out.println(e);
//				System.out.println("length: " + vet.length);
//				System.out.println("size:" +vet[k].size());
//				//System.out.println(vet[k].get(10));
//			}
//		}
//	}
}


