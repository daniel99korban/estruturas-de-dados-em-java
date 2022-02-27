package util;

import java.io.*;

public class Arquivo {
    public String Read(String caminho){// path
        String conteudo = "";
        try {
            String linha = "";
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            try{// ler todo o arquivo e acresentar a uma string
                linha = lerArq.readLine();
                while (linha != null){
                    conteudo += linha + "\r\n";
                    linha = lerArq.readLine();
                }
                arq.close();// Não foi possivel ler arquivo do buffer
            }catch (IOException ex){
                conteudo = "Erro: Não foi possivel ler Arquivo!";
            }
        }catch (FileNotFoundException ex){
            conteudo = "Erro: Arquivo não encontrado!";
        }
        if(conteudo.contains("Erro"))
            return "";
        else{
            return conteudo;
        }
    }
    public static Boolean Write(String caminho, String texto){
        try {
            FileWriter arq = new FileWriter(caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.write(texto);
            //gravarArq.println(texto);
            gravarArq.close();
            return true;
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
