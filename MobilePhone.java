package com.challenge2;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private ArrayList<Contact> contactList;
    private Scanner scanner;

    public MobilePhone() {
        this.contactList = new ArrayList<Contact>();
        scanner = new Scanner(System.in);
    }

    public void printContact() {
        System.out.println("You have " + contactList.size() + " contacts");
        System.out.println();
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + ". " + contactList.get(i).getName() + " -> " + contactList.get(i).getPhoneNum());
        }
    }


    public void addContact() {
        System.out.println("\nPlease enter the name:");
        String name = scanner.nextLine().toLowerCase();
        if (!isOnContactList(name)) {
            System.out.println("Please enter the phone number");
            String phoneNum = scanner.nextLine().toLowerCase();
            contactList.add(new Contact(name,phoneNum));
            System.out.println("\nContact successfully added...");
        } else {
            System.out.println(name + " already exist...\n\nWould you like to update the contact[Y\\N]:");
            char updateContactChoice = Character.toLowerCase(scanner.findInLine(".").charAt(0));
            scanner.nextLine();
            switch (updateContactChoice) {
                case 'y':
                    updateContact();
                    break;
                case 'n':
                    Main.printInstruction();
                    break;
                default:
                    System.out.println("choose between 'y' or 'n' ");
                    break;
            }
        }
    }

    public void updateContact() {
        System.out.println("\nPlease enter the name to be updated:");
        String name = scanner.nextLine().toLowerCase();
        Boolean isOnContactListName = isOnContactList(name);
        if (isOnContactListName) {
            System.out.println("Please enter the new name:");
            String newName = scanner.nextLine();
            System.out.println("Please enter the new phone number:");
            String newPhoneNum = scanner.nextLine();
            contactList.set(getIndex(name), new Contact(newName, newPhoneNum));
            System.out.println(name + " successfully updated...");
        } else {
            System.out.println(name + " is not on your contact list...");
        }

    }

    public void removeContact() {
        System.out.println("\nPlease enter the name of the contact to delete:");
        String name = scanner.nextLine().toLowerCase();
        int index = getIndex(name);
        if (index >= 0) {
            contactList.remove(index);
            System.out.println(name + " successfully deleted...");
        } else {
            System.out.println(name + " is not on your contact list...");
        }
    }

    public void searchContact() {
        System.out.println("\nPlease enter the name to query:");
        String name = scanner.nextLine().toLowerCase();
        int contactDetails = getIndex(name);
        if (contactDetails>=0) {
            System.out.println("Contact found!");
            System.out.println("\nName: " + contactList.get(contactDetails).getName() + " ---> Phone number: " + contactList.get(contactDetails).getPhoneNum());
        } else {
            System.out.println("\n" + name + " is not on your contact list...");
        }

    }


    private boolean isOnContactList(String name) {
        for (Contact aContactList : contactList) {
            if ((aContactList.getName()).toLowerCase().equals(name.toLowerCase())) {
                return true;

            }
        }
        return false;
    }

    private int getIndex(String name) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

}
