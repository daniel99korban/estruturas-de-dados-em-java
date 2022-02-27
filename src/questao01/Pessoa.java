package questao01;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private Integer idade;

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    Pessoa(){
        this.nome = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome = '" + nome + '\'' +
                ", idade = " + idade +
                '}';
    }

    @Override
    public int compareTo(Pessoa o) {// Essse comparador ira tomar o atributo idade para inserir na estrutura
        return (this.idade < o.getIdade())? -1 : (this.idade > o.getIdade())? 1 : 0;
    }
}
