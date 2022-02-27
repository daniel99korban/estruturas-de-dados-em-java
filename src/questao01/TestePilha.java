package questao01;

import util.File;

public class TestePilha {
    public static void main(String[] args) {
        /*File arquivo = new File();
        String valores = arquivo.Read("valores.txt");
        for(String valor : valores.split(";")){// o split(";") retorna um vetor
                minhaArvore.inserir(valor);
        }*/
        var minhaPilha = new PilhaDinamica<Integer>();

        minhaPilha.adicionar(2);
        minhaPilha.adicionar(4);
        minhaPilha.adicionar(6);
        minhaPilha.adicionar(7);

        minhaPilha.mostrar();
    }
}
