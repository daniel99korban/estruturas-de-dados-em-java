package questao01;

public class FilaDinamica<T> {
    // DESCRITOR
    private Nodo<T> inicio;
    private Nodo<T> fim;
    private int quantidade;
    //====================
    // classe interna
    public class Nodo<T>{
        T valor;//
        Nodo<T> proximo;
    }
    public FilaDinamica(){
        this.quantidade = 0;
    }

    public void adicionar(T _valor){
        var novoNo = new Nodo<T>();
        novoNo.valor = _valor;
        // verificar se esta vazio
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
        }else{
            var noAux = new Nodo<T>();
            noAux = inicio;
            // procurar o final da lista
            while (noAux.proximo != null){
                noAux = noAux.proximo;
            }
            noAux.proximo = novoNo;
            fim = novoNo;
        }
        quantidade++;
    }
    public void remover(){
        if(tamanho() > 0){
            // verificar se é o unico item na lista
            if(fim == inicio){
                fim = null;
                inicio = null;
            }else{
                var noAux = new Nodo<T>();
                noAux = inicio;
                inicio = noAux.proximo;
                noAux = null;
            }
            quantidade--;
        }
    }
    public void buscar(T _valor){
        var noAux = new Nodo<T>();
        noAux = inicio;
        while(noAux != null && !noAux.valor.equals(_valor)){
            noAux = noAux.proximo;
        }
        if(noAux == null){
            System.out.println("Valor não encontrado :(");
        }else{
            System.out.println(noAux.valor);
        }
    }
    public void mostrar(){
        var noAux = new Nodo<T>();
        noAux = inicio;
        if(noAux == null){
            System.out.println("estrutura vazia :(");
        }
        while (noAux != null){
            System.out.println("[" + noAux.valor + "]");
            noAux = noAux.proximo;
        }
    }
    public int tamanho(){
        return this.quantidade;
    }
}
