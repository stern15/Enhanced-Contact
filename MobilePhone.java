package com.challenge2;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private Contact contact;
    private ArrayList<Contact> contactList = new ArrayList<Contact>();
    private Scanner scanner = new Scanner(System.in);


    public void printContact() {
        System.out.println("You have " + contactList.size() + " contacts");
        System.out.println();
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + ". " + contactList.get(i).getName() + " -> " + contactList.get(i).getPhoneNum());
        }
    }


    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void updateContact(String name) {
        Boolean isOnContactListName = onContactListName(name);
        if (isOnContactListName) {
            System.out.println("Please enter the new name:");
            String newName = scanner.nextLine();
            System.out.println("Please enter the new phone number:");
            String newPhoneNum = scanner.nextLine();
            contactList.set(onContactListNameIndex(name), new Contact(newName, newPhoneNum));
            System.out.println(name + " successfully updated...");
        } else {
            System.out.println(name + " is not on your contact list...");
        }

    }

    public void removeContact(String name) {
        int index = onContactListNameIndex(name);
        if (index >= 0) {
            contactList.remove(index);
            System.out.println(name + " successfully deleted...");
        } else {
            System.out.println(name + " is not on your contact list...");
        }
    }

    public Contact searchContact(String name) {
        int index = onContactListNameIndex(name);
        if (index >= 0) {
            System.out.println("Contact found!");
            return contactList.get(index);
        } else {
            return null;
        }
    }


    public boolean onContactListName(String name) {
        for (int i = 0; i < contactList.size(); i++) {
            if ((contactList.get(i).getName()).toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private int onContactListNameIndex(String name) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                return contactList.indexOf(contactList.get(i));
            }
        }
        return -1;
    }

}
