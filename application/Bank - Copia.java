package application;

import entitties.Client;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Client client = null;

        System.out.println("--Register bank account---");
        System.out.print("Your account number: ");
        int number = input.nextInt();
        System.out.print("Holder account name: ");
        input.nextLine();
        String holderName = input.nextLine();
        System.out.print("You have a initial deposit [Y/N]?: ");
        char option = input.next().charAt(0);

        if (option == 'Y' || option == 'y') {
            System.out.print("How much you will deposit?: ");
            double holderDeposit = input.nextDouble();
            client = new Client(number, holderName, holderDeposit);
        } else if (option == 'N' || option == 'n') {
            client = new Client(number, holderName);
        }
        System.out.println("---Account data---");
        System.out.print(client);
        System.out.println();

        System.out.println("You want change your holder name?[Y/N] ");
        char response = input.next().charAt(0);
        if(response == 'Y' || response == 'y'){
            System.out.print("Digit you new name: ");
            input.nextLine();
            String newName = input.nextLine();
            client.setName(newName);
        }
        System.out.println();
        System.out.print("Enter a deposit value: ");
        double holderDeposit = input.nextDouble();
        client.deposit(holderDeposit);
        System.out.println("---Updated Account data---");
        System.out.print(client);
        System.out.println();

        System.out.println("Set a withdraw value");
        double withdraw = input.nextDouble();
        client.draw(withdraw);
        System.out.println("---Updated Account data---");
        System.out.println(client);
        input.close();
        System.out.print("fodase");
    }
}