
import java.util.Scanner;

class CircularList {
    class Node {
        String name;
        Node next;

        Node(String n) {
            name = n;
            next = null;
        }
    }

    Node head = null;

    // Add a player
    void insert(String name) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }

        System.out.println("Player added: " + name);
    }

    // Delete a player
    void delete(String name) {
        if (head == null) {
            System.out.println("No players available");
            return;
        }

        Node current = head;
        Node previous = null;

        do {
            if (current.name.equals(name)) {
                if (current == head && current.next == head) {
                    head = null;
                } else {
                    if (current == head) {
                        Node last = head;

                        while (last.next != head) {
                            last = last.next;
                        }

                        head = head.next;
                        last.next = head;
                    } else {
                        previous.next = current.next;
                    }
                }

                System.out.println("Player removed: " + name);
                return;
            }

            previous = current;
            current = current.next;

        } while (current != head);

        System.out.println("Player not found");
    }

    // Display players
    void display() {
        if (head == null) {
            System.out.println("No players available");
            return;
        }

        Node temp = head;

        System.out.println("Players:");

        do {
            System.out.println(temp.name);
            temp = temp.next;
        } while (temp != head);
    }
}

public class CircularSinglyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularList list = new CircularList();

        int choice;

        do {
            System.out.println("\n1. Add Player");
            System.out.println("2. Remove Player");
            System.out.println("3. Display Players");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter player name: ");
                    String name = sc.nextLine();
                    list.insert(name);
                    break;

                case 2:
                    System.out.print("Enter player name to remove: ");
                    String removeName = sc.nextLine();
                    list.delete(removeName);
                    break;

                case 3:
                    list.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);

        sc.close();
    }
}