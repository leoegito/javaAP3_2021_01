import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class APX3_2021_1_Q2 {
//Aluno: Leonardo Barros Egito da Silva
//Matricula: 19113050001

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contato c1 = new Contato("Fulano");
		Contato c2 = new Contato("Ciclano");
		Contato c3 = new Contato("Beltrano");
		Grupo amigos = new Grupo("Amizade");
		amigos.adicionaContato(c1);
		amigos.adicionaContato(c2);
		c1.enviaMensagem(c2, "Bom dia!");
		c1.enviaMensagem(amigos, "Olá a todos!");
		c3.enviaMensagem(amigos, "Olá amigos!");
		System.out.println(c1);
		System.out.println(c2);

	}

}

class Contato{
	
	String nome;
	ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();
	//Resolvi deixar a variavel ultimoGrupo, embora ela nao seja necessaria para a resolucao
	//dessa questao, ela mostra o caminho que percorri
	Grupo ultimoGrupo = null;
	ArrayList<Grupo> meusGrupos = new ArrayList<Grupo>();
	
	Contato(String name){
		this.nome = name;
	}
	
	public void enviaMensagem(Contato destino, String mensagem){

		new Mensagem(this, destino, mensagem);
		
	}
	
	public void enviaMensagem(Grupo grupo, String mensagem) {
		
		if(meusGrupos.contains(grupo)) {
			new Mensagem(this, grupo, mensagem);
		} else {
			System.out.println("" +this.nome +" nao faz parte do grupo " +grupo.nome +" !!!\n");
		}
		
	}
	
	public void armazenaMensagem(Mensagem msg) {
		mensagens.add(msg);
	}
	
	public String toString() {
		String retorno = "";
		int cont = 0;
		retorno += "Mensagens de " +this.nome+":\n";
		for(Mensagem m : mensagens) {
			retorno += "Mensagem " +String.valueOf(cont+1)+":\n";
			retorno += m.remetente.nome+"->"+m.destinatario.nome+"\n";
			retorno += m.dataEnvio+"\n";
			retorno += m.textoMsg+"\n";
			cont++;
		}
		
		for(Grupo meuGrupo : meusGrupos) {
			retorno += meuGrupo.toString();
		}

		return retorno;
	}
	
}

class Grupo extends Contato{
	
	ArrayList<Contato> contatosDoGrupo = new ArrayList<Contato>();
	
	Grupo(String name){
		super(name);
	}
	
	public void adicionaContato(Contato contato){
		//Resolvi deixar a variavel ultimoGrupo, embora ela nao seja necessaria para a resolucao
		//dessa questao, ela mostra o caminho que percorri
		contato.ultimoGrupo = this;
		contato.meusGrupos.add(this);
		contatosDoGrupo.add(contato);
	}
	
}

class Mensagem{
	
	Contato remetente;
	Contato destinatario;
	String textoMsg;
	String dataEnvio;
	
	Mensagem(Contato quemEnvia, Contato quemRecebe, String txt){
		this.dataEnvio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		this.remetente = quemEnvia;
		this.destinatario = quemRecebe;
		this.textoMsg = txt;
		
		destinatario.armazenaMensagem(this);
		
	}
	
}
//fim