package entidades;
import java.math.BigDecimal;

public class Funcionario {

    private BigDecimal salario;
    private String funcao; 

    public Funcionario () {

    }

    public Funcionario(BigDecimal salario, String funcao) {
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Funcionario [salario=" + salario + ", funcao=" + funcao + "]";
    }

    
    
}
