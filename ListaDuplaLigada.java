package questao01;

public class ListaDuplaLigada<T extends Comparable<T>>{
    // DESCRITOR
    private Nodo<T> inicio;
    Nodo<T> fim;
    private int quantidade;
    //====================
    // classe interna
    public class Nodo<T extends Comparable<T>>{
        T valor;
        Nodo<T> anterior;
        Nodo<T> proximo;
    }
    public ListaDuplaLigada(){
       // comparador = null;
        this.quantidade = 0;
    }


    public void adicionar(T _valor){
        var novoNo = new Nodo<T>();
        novoNo.valor = _valor;
        // verificar se esta vazio
        if(tamanho() == 0){
            inicio = novoNo;
            fim = novoNo;
        }else{
            var noAux = new Nodo<T>();
            noAux = inicio;
            // vamos procurar o final da lista
            while (noAux.proximo != null){
                noAux = noAux.proximo;
            }
            novoNo.anterior = noAux;
            noAux.proximo = novoNo;
            fim = novoNo;
        }
        quantidade++;
    }

    public void adicionarEmOrdem(T _valor){
        var novoNo = new Nodo<T>();
        novoNo.valor = _valor;
        // verificar se esta vazio
        if(tamanho() == 0){
            inicio = novoNo;
            fim = novoNo;
        }else{
            var noAtual = new Nodo<T>();
            var noAnt = new Nodo<T>();
            noAtual = inicio;

            if(tamanho() == 1) {// só um elemento na lista
                if (novoNo.valor.compareTo(noAtual.valor) == -1){
                    noAtual.anterior = novoNo;
                    novoNo.proximo = noAtual;
                    inicio = novoNo;
                }else{
                    novoNo.anterior = noAtual;
                    noAtual.proximo = novoNo;
                    fim = novoNo;
                }
            }else{
                while(noAtual.proximo != null &&  _valor.compareTo(noAtual.valor) > 0){//(this.idade < o.getIdade())? -1 : (this.idade > o.getIdade())? 1 : 0;
                    noAnt = noAtual;
                    noAtual = noAtual.proximo;
                }// se no for inserido no inicio
                if(noAtual.valor == inicio.valor){
                    inicio.anterior = novoNo;
                    novoNo.proximo = inicio;
                    inicio = novoNo;
                }else{
                    if(noAtual.proximo == null){// chegou no final
                        // verificar se o valor é menor ou maior que o ultimo elemento
                        if(novoNo.valor.compareTo(noAtual.valor) < 0){
                            noAnt.proximo = novoNo;
                            novoNo.anterior = noAnt;
                            novoNo.proximo = noAtual;
                            noAtual.anterior = novoNo;
                        }else{
                            novoNo.anterior = noAtual;
                            noAtual.proximo = novoNo;
                            fim = novoNo;
                        }
                    }else{
                        noAnt.proximo = novoNo;
                        novoNo.anterior = noAnt;
                        novoNo.proximo = noAtual;
                        noAtual.anterior = novoNo;
                    }
                }
            }

        }
        quantidade++;
    }

    public void remover(T _valor){
        if(tamanho() > 0){
            var noAux = new Nodo<T>();
            noAux = inicio;
            while(noAux.valor != _valor && noAux != null){
                noAux = noAux.proximo;
            }
            if(noAux == null){
                return;// encerra o metodo pois o valor não foi encontrado
            }else{
// TEM UMA BUG AQUI, SÓ NUM SEI ONDE É
                if(noAux == fim && noAux == fim){// so restou apenas um valor na lista
                    fim = null;
                    inicio = null;
                }else{
                    if(noAux == fim){// o no esta no fim da lista
                        // atualizando o fim
                        fim = noAux.anterior;
                        noAux.anterior = null;
                        fim.proximo = null;
                        noAux = null;
                    }else if(noAux == inicio){// // o no esta no inicio da lista
                        // atualizando o inicio
                        inicio = noAux.proximo;
                        noAux.proximo = null;
                        inicio.anterior = null;
                    }else{// entre dois elementos;
                        noAux.anterior.proximo = noAux.proximo;
                        noAux.proximo = noAux.anterior;
                        // desligando o elemnto da lista
                        noAux.proximo = null;
                        noAux.anterior = null;
                    }
                }
            }
            quantidade--;
        }
    }
    public void remover(){
        if(tamanho() > 0){
            // verificar se é o unico item na lista
            if(fim == inicio){
                fim = null;
                inicio = null;
            }else{
                fim = fim.anterior;
                fim.proximo.anterior = null;//
                fim.proximo = null;
            }
            quantidade--;
        }
    }
    public void obter(T _valor){
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
    public void exibir(){
        if(tamanho() > 0){
            var noAux = new Nodo<T>();
            noAux = inicio;
            while(noAux != null){
                System.out.println(noAux.valor);
                noAux = noAux.proximo;
            }
        }else{
            System.out.println("Nenhum item na lista :(");
        }
    }

    public int tamanho(){
        return this.quantidade;
    }

}