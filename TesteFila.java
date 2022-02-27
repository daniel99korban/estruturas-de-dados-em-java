package questao01;

import util.File;

public class TesteFila {
    public static void main(String[] args) {
        /*File arquivo = new File();
        String valores = arquivo.Read("valores.txt");
        for(String valor : valores.split(";")){// o split(";") retorna um vetor
                minhaArvore.inserir(valor);
        }*/
        var minhaFila = new FilaDinamica<Integer>();

        // EXEMPLO
        minhaFila.adicionar(1);
        minhaFila.adicionar(5);

        minhaFila.mostrar();
    }
}
