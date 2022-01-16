package exercise01.application;

import exercise01.entities.Employee;
import exercise01.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Uma empresa possui funcionários próprios e terceirizados.
 * Para cada funcionário, deseja-se registrar nome, horas
 * trabalhadas e valor por hora. Funcionários terceirizado
 * possuem ainda uma despesa adicional.
 * O pagamento dos funcionários corresponde ao valor da hora
 * multiplicado pelas horas trabalhadas, sendo que os
 * funcionários terceirizados ainda recebem um bônus
 * correspondente a 110% de sua despesa adicional.
 * Fazer um programa para ler os dados de N funcionários (N
 * fornecido pelo usuário) e armazená-los em uma lista. Depois
 * de ler todos os dados, mostrar nome e pagamento de cada
 * funcionário na mesma ordem em que foram digitados.
 */
public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nInforme o número de funcionários: ");
        int n = sc.nextInt();
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            System.out.println("\nFuncionário #" + i);
            System.out.print("Terceirizado? (s/n) ");
            char opt = sc.next().charAt(0);
            while (optValidate(opt)){
                System.out.print("Opção inválida! Tente novamente: ");
                opt = sc.next().charAt(0);
            }
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Horas Trabalhadas: ");
            int hours = sc.nextInt();
            System.out.print("Valor por hora: ");
            double valuePerHour = sc.nextDouble();
            if (opt == 'n'){
                employeeList.add(new Employee(name, hours, valuePerHour));
            }
            if (opt == 's'){
                System.out.print("Cobrança Adicional: ");
                double additionalCharge = sc.nextDouble();
                employeeList.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            }
        }

        System.out.println("\nPAGAMENTOS");
        for (Employee e : employeeList){
            System.out.println(e.getName() + " - R$ " + String.format("%.2f", e.payment()));
        }

        sc.close();

    }

    public static boolean optValidate(char value){
        return value != 's' && value != 'n';
    }
}
