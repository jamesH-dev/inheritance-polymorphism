package exercise04.application;

import exercise04.entities.Company;
import exercise04.entities.Individual;
import exercise04.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usuário), os quais
 * podem ser pessoa física ou pessoa jurídica, e depois mostrar o valor do imposto pago por cada um,
 * bem como o total de imposto arrecadado.
 * Os dados de pessoa física são: nome, renda anual e gastos com saúde. Os dados de pessoa jurídica
 * são nome, renda anual e número de funcionários. As regras para cálculo de imposto são as
 * seguintes:
 * Pessoa física: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. Pessoas com
 * renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve gastos com saúde, 50%
 * destes gastos são abatidos no imposto.
 * Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, o imposto
 * fica: (50000 * 25%) - (2000 * 50%) = 11500.00
 * Pessoa jurídica: pessoas jurídicas pagam 16% de imposto. Porém, se a empresa possuir mais de 10
 * funcionários, ela paga 14% de imposto.
 * Exemplo: uma empresa cuja renda foi 400000.00 e possui 25 funcionários, o imposto fica:
 * 400000 * 14% = 56000.00
 */
public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> taxPayerList = new ArrayList<>();

        System.out.print("\nInforme a quantidade de pagadores: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("\nPagador #" + i);
            System.out.print("Pessoa Física ou Jurídica? (f/j) ");
            char opt = sc.next().charAt(0);
            while (optValidation(opt)){
                System.out.print("Opção inválida! Tente novamente: ");
                opt = sc.next().charAt(0);
            }
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Renda Anual: ");
            Double annualIncome = sc.nextDouble();
            if (opt == 'f'){
                System.out.print("Gastos com Saúde: ");
                double healthSpenditures = sc.nextDouble();
                taxPayerList.add(new Individual(name, annualIncome, healthSpenditures));
            }
            if (opt == 'j'){
                System.out.print("Número de funcionários: ");
                int numberOfEmployees = sc.nextInt();
                taxPayerList.add(new Company(name, annualIncome, numberOfEmployees));
            }
        }

        System.out.println("\nImpostos pagos:");
        for (TaxPayer t : taxPayerList){
            System.out.println(t.getName() + ": R$ " + String.format("%.2f", t.tax()));
        }

        sc.close();
    }
    public static boolean optValidation(char value){
        return value != 'f' && value != 'j';
    }
}
