package aplicacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;

public class Principal {

    public static void main(String[] args) {
        
    
        Locale brasil = new Locale("pt","BR");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner (System.in);


        List<Funcionario> list = new ArrayList<>();
        list.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        list.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        list.add(new Funcionario("Caio", LocalDate.of(1961, 5, 02), new BigDecimal("9836.14"), "Coordenador"));
        list.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        list.add(new Funcionario("Alice", LocalDate.of(1995, 1, 05), new BigDecimal("2234.68"), "Recepcionista"));
        list.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        list.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        list.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        list.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        list.add(new Funcionario("Helena", LocalDate.of(1996, 9, 02), new BigDecimal("2799.93"), "Gerente"));

        list.removeIf(f -> f.getNome().equals("João"));
        
        System.out.println("Funcionários:");

        for (Funcionario f : list) {
            String dataNascimento = f.getDataDeNascimento().format(formatter);

            String salario = f.getSalario().toString();

            System.out.printf("Nome: %s, Data de Nascimento: %s, Salário: R$ %s, Função: %s%n",
            f.getNome(), dataNascimento, salario, f.getFuncao());

        }
       
        for (Funcionario f : list) {
            BigDecimal salarioAtualizado = f.getSalario().multiply(new BigDecimal(1.1));
            f.setSalario(salarioAtualizado);
        }
        
        System.out.println("Funcionários com salário atualizado: ");

        for (Funcionario f : list) {
            String dataNascimento = f.getDataDeNascimento().format(formatter);

            String salario = f.getSalario().toString();

            System.out.printf("Nome: %s, Data de Nascimento: %s, Salário: R$ %s, Função: %s%n",
            f.getNome(), dataNascimento, salario, f.getFuncao());

        }

        System.out.println("Funcionários que fazem aniversário nos meses 10 e 12:");

        for (Funcionario f : list) {
            int mesNascimento = f.getDataDeNascimento().getMonthValue();

            if (mesNascimento == 10 || mesNascimento == 12) {
                String dataNascimento = f.getDataDeNascimento().format(formatter);
                System.out.printf("Nome: %s, Data de Nascimento: %s, Salário: R$ %.2f, Função: %s%n",
                f.getNome(), dataNascimento, f.getSalario().doubleValue(), f.getFuncao());
            }
        }

        Funcionario funcionarioMaisVelho = null;
        int maiorIdadeEmDias = Integer.MIN_VALUE;

        for (Funcionario f : list) {
            int idadeEmDias = LocalDate.now().compareTo(f.getDataDeNascimento());
            if (idadeEmDias > maiorIdadeEmDias) {
                maiorIdadeEmDias = idadeEmDias;
                funcionarioMaisVelho = f;
            }
        }

        if (funcionarioMaisVelho != null) {
            int idade = LocalDate.now().getYear() - funcionarioMaisVelho.getDataDeNascimento().getYear();
            System.out.printf("Funcionário com a maior idade: Nome: %s, Idade: %d anos%n", 
            funcionarioMaisVelho.getNome(), idade);
        }

        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario f : list) {
            totalSalarios = totalSalarios.add(f.getSalario());
        }
        
        System.out.printf("Total dos salários dos funcionários: R$ %.2f%n", totalSalarios);

        sc.close();
    }
}
