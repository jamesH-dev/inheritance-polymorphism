package exercise02.application;

import exercise02.entities.ImportedProduct;
import exercise02.entities.Product;
import exercise02.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Fazer um programa para ler os dados de N
 * produtos (N fornecido pelo usuário). Ao final,
 * mostrar a etiqueta de preço de cada produto na
 * mesma ordem em que foram digitados.
 * Todo produto possui nome e preço. Produtos
 * importados possuem uma taxa de alfândega, e
 * produtos usados possuem data de fabricação.
 * Estes dados específicos devem ser
 * acrescentados na etiqueta de preço conforme
 * exemplo (próxima página). Para produtos
 * importados, a taxa e alfândega deve ser
 * acrescentada ao preço final do produto.
 */
public class Application {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> productList = new ArrayList<>();

        System.out.print("\nInforme o número de produtos: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++){
            System.out.println("\nProduto #" + i);
            System.out.print("Comum, Importado ou Usado? (c/i/u) ");
            char opt = sc.next().charAt(0);
            while (optValidation(opt)){
                System.out.print("Opção inválida! Tente novamente: ");
                opt = sc.next().charAt(0);
            }
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Preço: ");
            double price = sc.nextDouble();
            if (opt == 'c'){
                productList.add(new Product(name, price));
            }
            if (opt == 'i'){
                System.out.print("Taxa da Alfândega: ");
                double customFee = sc.nextDouble();
                productList.add(new ImportedProduct(name, price, customFee));
            }
            if (opt == 'u'){
                System.out.print("Data de Fabricação: ");
                Date manufactureDate = sdf.parse(sc.next());
                productList.add(new UsedProduct(name, price, manufactureDate));
            }
        }

        System.out.println("\nRótulos de Preço");
        for (Product p : productList){
            System.out.println(p.priceTag());
        }

        sc.close();
    }

    public static boolean optValidation(char value){
        return value != 'c' && value != 'i' && value != 'u';
    }
}
