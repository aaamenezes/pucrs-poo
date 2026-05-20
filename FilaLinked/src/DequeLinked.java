public class DequeLinked<T> implements MeuDeque<T> {
    class Nodo {
        T dado;
        Nodo proximo;

        public Nodo(T dado, Nodo proximo) {
            this.dado = dado;
            this.proximo = proximo;
        }

        public T getDado() {
            return dado;
        }

        public Nodo getProximo() {
            return proximo;
        }

        public void setProximo(Nodo proximo) {
            this.proximo = proximo;
        }
    }

    public boolean inserirInicio(T valor) {
        
    }

	public boolean inserirFim(T valor) {
        Nodo novo = new Nodo(valor, null);
        if(tamanho()==0) {
            inicio = novo;
        }
        else {
            fim.setProximo(novo);
        }
        fim = novo;
        return true;
    }

	public T removerInicio() {

    }

	public T removerFim() {

    }

	public T consultarInicio() {

    }

	public T consultarFim() {

    }

	public int tamanho() {

    }
}
