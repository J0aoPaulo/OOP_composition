package app;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.nuns.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf02 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("Enter a client data:");
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date dateBirth = sdf.parse(input.next());
        System.out.println("Enter a order data:");
        System.out.print("Status: ");
        input.nextLine();
        String status = input.nextLine();

        Order pedido = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, dateBirth));

        System.out.print("How many items to this order? ");
        int n = input.nextInt();
        for(int i = 1; i<= n; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            input.nextLine();
            String nameProduct = input.nextLine();
            System.out.print("Product price: ");
            double productPrice = input.nextDouble();
            System.out.print("Quantity: ");
            int quantity = input.nextInt();
            OrderItem orderItem = new OrderItem(quantity, productPrice, new Product(nameProduct));
            pedido.addItem(orderItem);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.print(pedido.toString());
    }
}
