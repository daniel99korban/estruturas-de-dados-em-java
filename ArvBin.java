package questao01;

import java.lang.Exception;

/**
 * Classe que implementa a estrutura da arvore binaria
 *
 * @author Daniel Lima Azevedo
 * @param <T> coparador usado para o tipo generico
 * @see <a href="https://www.devmedia.com.br/usando-generics-em-java/28981">Entenda o generics</a>
 */
public class ArvBin<T extends Comparable<T>>{

    private NoBin<T> raiz;

    ArvBin(){
        this.raiz = null;
    }

    public void inserir(T valor){
        var novoNo = new NoBin<T>(valor);
        this.raiz = inserir(raiz, novoNo);
    }

    private NoBin<T> inserir(NoBin<T> noAtual, NoBin<T> novoNo){// Algoritmo recursivo
        if(noAtual == null){
            return novoNo;
        }else if(novoNo.valor.compareTo(noAtual.valor) < 0){
            noAtual.noEsq = inserir(noAtual.noEsq, novoNo);
        }else if(novoNo.valor.compareTo(noAtual.valor) > 0){
            noAtual.noDir = inserir(noAtual.noDir, novoNo);
        }
        return noAtual;
    }

    public void remover(T valor){
        var maiorValorAEsquerda = new NoBin<T>();
        var noAnt = new NoBin<T>();
        if(raiz == null){
            System.out.println("Arvore vazia :)");
            return;// nenhum valor na arvore
        }
        // se o valor a ser removido for uma raiz
        if(valor.compareTo(raiz.valor) == 0){
            noAnt = raiz;
            maiorValorAEsquerda = buscarMaiorValorEsquerdaDaRaiz(raiz.noEsq, noAnt);

            if(maiorValorAEsquerda == null){// Não tinha ninguém no lado esquerdo
                raiz = raiz.noDir;
            }else{
                maiorValorAEsquerda.noEsq = raiz.noEsq;
                maiorValorAEsquerda.noDir = raiz.noDir;
                raiz = maiorValorAEsquerda;// meu novo nó raiz
            }
        }else{
            noAnt = raiz;// remover valor qualqer na arvore
            try {
                removerNo(raiz, noAnt, valor);
            } catch (NullPointerException e) {
                System.err.println("Erro: Valor não foi encontrado :(");
            }
        }

    }

    /**
     * @param noAtual parametro pasado por metodo chamador
     * @param noAnt parametro pasado por metodo chamador
     * @param valor parametro pasado por metodo chamador
     * @throws NullPointerException caso em algun momento da recursão se faça referência a um nulo
     */
    private void removerNo(NoBin<T> noAtual, NoBin<T> noAnt, T valor) throws NullPointerException{// como remover no folha
        if(valor.compareTo(noAtual.valor) < 0){
            if(noAtual==null){
                // Nó não foi encontrado!
                throw new NullPointerException("Valor não encontrado :(");
            }
            noAnt = noAtual;
            removerNo(noAtual.noEsq, noAnt, valor);
        }else if(valor.compareTo(noAtual.valor) > 0){
            if(noAtual==null){
                // Nó não foi encontrado!
                throw new NullPointerException("Valor não encontrado :(");
            }
            noAnt = noAtual;
            removerNo(noAtual.noDir, noAnt, valor);
        }else{
            var maiorValorAEsquerda = new NoBin<T>();
            var ant = new NoBin<T>();
            ant = noAtual;
            // tratar nó folha
            if(noAtual.noEsq == null && noAtual.noDir == null){
                if(noAnt.noDir == noAtual){
                    noAnt.noDir = null;
                }else{
                    noAnt.noEsq = null;
                }
            }else{
                if(noAtual.noEsq==null){
                    noAnt.noEsq = noAtual.noDir;
                }else{
                    maiorValorAEsquerda = buscarMaiorValorEsquerdaDaRaiz(noAtual.noEsq, ant);
                    maiorValorAEsquerda.noEsq = noAtual.noEsq;
                    maiorValorAEsquerda.noDir = noAtual.noDir;
                    noAnt.noEsq = maiorValorAEsquerda;
                }
            }

        }
    }

    private NoBin<T> buscarMaiorValorEsquerdaDaRaiz(NoBin<T> no, NoBin<T> noAnt){
        var noAtual = new NoBin<T>();
        noAtual = no;

        if(noAtual == null) return null;

        if(noAtual.noEsq == null && noAtual.noDir == null){
            noAnt.noEsq = null;
            return noAtual;
        }else {
            while(noAtual.noDir != null){
                noAnt = noAtual;
                noAtual = noAtual.noDir;
            }
            if(noAtual.noEsq != null){
                noAnt.noEsq = noAtual.noEsq;
            }
            else{
                noAnt.noDir = noAtual.noDir;// pode ser qualqer valor e até null
            }
        }
        return noAtual;
    }



    public NoBin<T> buscar(T valor) throws Exception{
        var noAux = new NoBin<T>();
        noAux = raiz;
        while(noAux != null){
            if(valor.compareTo(noAux.valor) == 0){// se eu achei o meu valor
                return noAux;
            }else{
                if(valor.compareTo(noAux.valor) < 0)// se valor for menor
                    noAux = noAux.noEsq;
                else
                    noAux = noAux.noDir;
            }
        }
        throw new Exception("Valor não encontrado") ;// O valor não se encontra na arvore
    }

    public void verEmOrdem(){
        if(raiz == null) return;
        verEmOrdem(raiz);
    }
    private void verEmOrdem(NoBin<T> no){
        if(no != null){
            verEmOrdem(no.noEsq);
            System.out.println(no.valor);
            verEmOrdem(no.noDir);
        }
    }

    public void verPreOrdem(){
        if(raiz == null) return;
        verPreOrdem(raiz);
    }
    private void verPreOrdem(NoBin<T> no){
        if(no != null){
            System.out.println(no.valor);
            verPreOrdem(no.noEsq);
            verPreOrdem(no.noDir);
        }
    }

    public void verPosOrdem(){
        if(raiz == null) return;
        verPosOrdem(raiz);
    }
    private void verPosOrdem(NoBin<T> no){
        if(no != null){
            verPosOrdem(no.noEsq);
            verPosOrdem(no.noDir);
            System.out.println(no.valor);
        }
    }

    public int tamanho(){
        return contar(raiz);
    }

    private int contar(NoBin<T> no){
        if(no != null){
            return 1 + contar(no.noEsq) + contar(no.noDir);
        }
        return 0;
    }

}

class NoBin<T extends Comparable<T>> {
    T valor;
    NoBin<T> noEsq;
    NoBin<T> noDir;

    NoBin(T valor){// Ajustando o no
        this. valor = valor;
        noEsq = noDir = null;
    }

    NoBin(){}// Uso somente para nós auxialares

    // Getters e Setters
    //...

    @Override
    public String toString() {
        return valor.toString();
    }

}
