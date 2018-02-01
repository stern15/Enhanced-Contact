package com.challenge2;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean flag = true;
        int choice;
        phoneStart();
        printInstruction();
        while (flag) {
            System.out.println("\nPlease enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstruction();
                    break;
                case 1:
                    mobilePhone.printContact();
                    break;
                case 2:
                    mobilePhone.addContact();
                    break;
                case 3:
                    mobilePhone.updateContact();
                    break;
                case 4:
                    mobilePhone.removeContact();
                    break;
                case 5:
                    mobilePhone.searchContact();
                    break;
                case 6:
                    phoneShutDown();
                    flag = false;
                    break;
            }
        }


    }
    private static void phoneStart(){
        System.out.println("Phone starting...");
    }
    private static void phoneShutDown(){
        System.out.println("Phone shutting down...");
    }

    public static void printInstruction() {
        System.out.println("\nPress " +
                "\n" +
                "\n0 - To print choice options." +
                "\n1 - To print the list of contact." +
                "\n2 - To add a new contact." +
                "\n3 - To update an existing contact." +
                "\n4 - To remove an existing contact." +
                "\n5 - To search for a contact." +
                "\n6 - To shutdown the phone.");
    }

}
