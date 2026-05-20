package exercicio;

public class Main {

	public static void main(String[] args) {
		// Uso de classe que implementa uma interface
		Aplicacao aplicacao = new Aplicacao(new DequeLinked<Pessoa>());
		aplicacao.executa();
	}

}
