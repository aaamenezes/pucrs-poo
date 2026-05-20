package exercicio;

public interface MeuDeque<T> {

	public abstract boolean inserirInicio(T valor);

	public abstract boolean inserirFim(T valor);

	public abstract T removerInicio();

	public abstract T removerFim();

	public abstract T consultarInicio();

	public abstract T consultarFim();

	public abstract int tamanho();

}
