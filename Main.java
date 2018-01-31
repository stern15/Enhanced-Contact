package com.challenge2;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    private static Contact contact;

    public static void main(String[] args) {
        boolean flag = true;
        int choice;
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
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }


    }

    private static void printInstruction() {
        System.out.println("\nPress " +
                "\n" +
                "\n0 - To print choice options." +
                "\n1 - To print the list of contact." +
                "\n2 - To add a new contact." +
                "\n3 - To update an existing contact." +
                "\n4 - To remove an existing contact." +
                "\n5 - To search for a contact." +
                "\n6 - To quit the application.");
    }

    private static void addContact() {
        System.out.println("\nPlease enter the name:");
        String name = scanner.nextLine().toLowerCase();
        if (!mobilePhone.onContactListName(name)) {
            System.out.println("Please enter the phone number");
            String phoneNum = scanner.nextLine().toLowerCase();
            mobilePhone.addContact(new Contact(name, phoneNum));
            System.out.println("\nContact successfully added...");
        } else {
            System.out.println(name + " already exist...\n\nWould you like to update the contact[Y\\N]:");
            char updateContactChoice = Character.toLowerCase(scanner.findInLine(".").charAt(0));
            scanner.nextLine();
            switch (updateContactChoice) {
                case 'y':
                    mobilePhone.updateContact(name);
                    break;
                case 'n':
                    printInstruction();
                    break;
                default:
                    System.out.println("choose between 'y' or 'n' ");
                    break;
            }
        }

    }

    private static void updateContact() {
        System.out.println("\nPlease enter the name to be updated:");
        String name = scanner.nextLine().toLowerCase();
        mobilePhone.updateContact(name);
    }

    private static void removeContact() {
        System.out.println("\nPlease enter the name of the contact to delete:");
        String name = scanner.nextLine().toLowerCase();
        mobilePhone.removeContact(name);
    }

    private static void searchContact() {
        System.out.println("\nPlease enter the name to query:");
        String name = scanner.nextLine().toLowerCase();
        Contact contactDetails = mobilePhone.searchContact(name);
        if (contactDetails != null) {
            System.out.println("\nName: " + contactDetails.getName() + " , Phone number: " + contactDetails.getPhoneNum());
        } else {
            System.out.println("\n" + name + " is not on your contact list...");
        }
    }
}
