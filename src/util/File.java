package util;

import java.io.*;

public class File {
    public Boolean Write(String path, String content){
        try{
            FileWriter file = new FileWriter(path);
            PrintWriter writeFile = new PrintWriter(file);
            //writeFile.print(content);
            writeFile.write(content);
            writeFile.close();
            return true;
        }catch (IOException e){
            System.err.println(":( Erro ao escrever arquivo: " + path);
        }
        return false;
    }

    public String Read(String path){
        String content = "";
        try{
            FileReader file = new FileReader(path);
            BufferedReader readFile = new BufferedReader(file);
            String linha = "";
            try{
                linha = readFile.readLine();
                while (linha != null){
                    content += linha + "\r\n";
                    linha = readFile.readLine();
                }
            }catch (IOException e){
                System.err.println(e.getMessage());
            }
       }catch (FileNotFoundException e){// tratar para que o erro seja entendidos (formatar erros genericos)
            System.err.println(e.getMessage());
        }
        return content;
    }
}
