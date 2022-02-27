package questao01;

public class PilhaDinamica<T extends Comparable<T>>{
    // DESCRITOR
    private Nodo<T> topo;// ultimo elemento(topo da pilha)
    private Nodo<T> fundo;
    private int quantidade;
    //====================
    // classe interna
    public class Nodo<T extends Comparable<T>>{
        private T valor;
        private Nodo<T> proximo;
    }
    public PilhaDinamica(){
        this.quantidade = 0;
    }

    public void adicionar(T _valor){
        var novoNo = new Nodo<T>();
        novoNo.valor = _valor;
        // verificar se esta vazio
        if(tamanho() == 0){
            topo = novoNo;
            fundo = novoNo;
        }else{
            novoNo.proximo = topo;
            topo = novoNo;
        }
        quantidade++;
    }
    public void desempilhar(){// exclui o elemento do topo
        // A função pode ser alterada para obter o elemento do topo da pilha
        if(topo != null){
            // verificar se é o unico item na lista
            if(topo == fundo){
                topo = null;
                fundo = null;
            }else{
                var noAux = new Nodo<T>();
                noAux = topo;
                topo = topo.proximo;
                noAux = null;// desligando  no da lista
            }
            quantidade--;
        }
    }
    public void mostrar(){
        var noAux = new Nodo<T>();
        noAux = topo;
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
