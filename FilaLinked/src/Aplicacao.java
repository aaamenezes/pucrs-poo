package exercicio;

public class Aplicacao {

	private MeuDeque<Pessoa> meuDeque;

	public Aplicacao(MeuDeque<Pessoa> meuDeque) {
		this.meuDeque = meuDeque;
	}

	public void executa() {
		Pessoa pessoa;
		// Inclusao de valores
		System.out.println("Inserindo dados:");
		pessoa = new Pessoa("Maria da Silva", new Nascimento(11,11,2011));
		meuDeque.inserirInicio(pessoa);
		System.out.println("Dado do inicio: "+meuDeque.consultarInicio());
		System.out.println("Dado do fim: "+meuDeque.consultarFim());
		System.out.println("Tamanho: "+meuDeque.tamanho());
		pessoa = new Pessoa("Pedro Souza", new Nascimento(12,12,2012));
		meuDeque.inserirFim(pessoa);
		System.out.println("Dado do inicio: "+meuDeque.consultarInicio());
		System.out.println("Dado do fim: "+meuDeque.consultarFim());
		System.out.println("Tamanho: "+meuDeque.tamanho());
		pessoa = new Pessoa("Joao da Silva", new Nascimento(10,10,2010));
		meuDeque.inserirInicio(pessoa);
		System.out.println("Dado do inicio: "+meuDeque.consultarInicio());
		System.out.println("Dado do fim: "+meuDeque.consultarFim());
		System.out.println("Tamanho: "+meuDeque.tamanho());
		// Mostra todos em ordem crescente
		System.out.println("Valores do deque:");
		while(meuDeque.tamanho()!=0) {
			pessoa = meuDeque.removerInicio();
			System.out.println(pessoa);
		}

	}
}
