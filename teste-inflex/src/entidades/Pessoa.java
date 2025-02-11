package entidades;
import java.time.LocalDate;

public class Pessoa {

    private String name; 
    private LocalDate dataDeNascimento;

    public Pessoa () {

    }

    public Pessoa(String name, LocalDate dataDeNascimento) {
        this.name = name;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    

}
