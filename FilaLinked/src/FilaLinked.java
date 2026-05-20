package exercicio;

public class FilaLinked<T> {

    private Nodo inicio=null, fim=null;

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
        if(tamanho()!=0) {
            T valor = inicio.getDado();
            if(inicio == fim) {
                inicio = null;
                fim = null;
            }
            else {
                inicio = inicio.getProximo();
            }
            return valor;
        }
        return null;
    }

    public T consultarInicio() {
        if(tamanho()!=0) {
            return inicio.getDado();
        }
        return null;
    }

    public int tamanho() {
        int contador = 0;
        Nodo aux = inicio;
        while(aux != null) {
            contador++;
            aux = aux.getProximo();
        }
        return contador;
    }

}
