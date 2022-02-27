package questao01;

import util.File;

public class TesteArvoreBin {
    public static void main(String[] args) {
        /*File arquivo = new File();
        String valores = arquivo.Read("valores.txt");
        for(String valor : valores.split(";")){// o split(";") retorna um vetor
                minhaArvore.inserir(valor);
        }*/
        var minhaArvore = new ArvBin<Integer>();// o var é a mesma coisa de ArvBin<Integer>... só ajuda a escrever menos ;)


        minhaArvore.inserir(11);
        minhaArvore.inserir(20);
        minhaArvore.inserir(9);
        minhaArvore.inserir(16);
        minhaArvore.inserir(21);
        minhaArvore.inserir(10);

        minhaArvore.verPreOrdem();
        System.out.println("========");
        System.out.println("Tamanho: " + minhaArvore.tamanho());


    }
}
