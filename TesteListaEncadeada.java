package questao01;

import util.File;
import java.util.Random;

public class TesteListaEncadeada {
    public static void main(String[] args) {
        /*File arquivo = new File();
        String valores = arquivo.Read("valores.txt");
        for(String valor : valores.split(";")){// o split(";") retorna um vetor
                minhaArvore.inserir(valor);
        }*/
        var minhaLista = new ListaDuplaLigada<Integer>();

        minhaLista.adicionar(5);
        minhaLista.adicionarEmOrdem(7);
        minhaLista.adicionarEmOrdem(3);
        minhaLista.adicionarEmOrdem(1);

        minhaLista.exibir();
    }
}
