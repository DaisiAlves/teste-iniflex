package aplicacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;
import entidades.Pessoa;

public class Principal {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);


        List<Funcionario> list = new ArrayList<>();
        
        System.out.println("Quantos funcionários você irá inserir?");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i=0; i < n; i++) {
        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("Data de nascimento: dd/mm/aaaa ");
        String dateStr = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/2yyyy");
        LocalDate dataDeNascimento = LocalDate.parse(dateStr, formatter);

        System.out.println("Salário:");
        BigDecimal salario = sc.nextBigDecimal();
        sc.nextLine();

        System.out.println("Função: ");
        String funcao = sc.nextLine();
       
        Funcionario func = new Funcionario (salario, funcao);
        Pessoa pessoa = new Pessoa (nome, dataDeNascimento);

         list.add(func);
        }
        
        
        for (Funcionario func : list) {
            System.out.println(func);
        }

        sc.close();
    }
}
