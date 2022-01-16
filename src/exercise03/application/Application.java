package exercise03.application;

import exercise03.entities.Circle;
import exercise03.entities.Rectangle;
import exercise03.entities.Shape;
import exercise03.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Fazer um programa para ler os dados de N figuras (N fornecido
 * pelo usuário), e depois mostrar as áreas destas figuras na
 * mesma ordem em que foram digitadas.
 */
public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Shape> shapeList = new ArrayList<>();

        System.out.print("\nInforme a quantidade de formas: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("\nForma #" + i);
            System.out.print("Retângulo ou Círculo? (r/c) ");
            char opt = sc.next().charAt(0);
            while (optValidation(opt)){
                System.out.print("Opção inválida! Tente novamente: ");
                opt = sc.next().charAt(0);
            }
            System.out.print("Cor? (BLACK, BLUE, RED) ");
            Color color = Color.valueOf(sc.next());
            if (opt == 'r'){
                System.out.print("Largura: ");
                double width = sc.nextDouble();
                System.out.print("Altura: ");
                double height = sc.nextDouble();
                shapeList.add(new Rectangle(color, width, height));
            }
            if (opt == 'c'){
                System.out.print("Raio: ");
                double radius = sc.nextDouble();
                shapeList.add(new Circle(color, radius));
            }
        }

        System.out.println("\nÁrea das formas cadastradas:");
        for (Shape s : shapeList){
            System.out.printf("%.2f%n", s.area());
        }

        sc.close();
    }

    public static boolean optValidation(char value){
        return value != 'r' && value != 'c';
    }
}
