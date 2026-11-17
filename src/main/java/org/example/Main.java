package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Event {
    private int id;
    private String name;
    private String date;
    private String venue;
    private int registeredCount;

    public Event(int id, String name, String date, String venue) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.registeredCount = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void registerParticipant() {
        registeredCount++;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Event: %-20s | Date: %-12s | Venue: %-15s | Registered: %d",
                id, name, date, venue, registeredCount);
    }
}

public class Main {
    private static ArrayList<Event> events = new ArrayList<>();
    private static int eventIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pre-populating with sample events
        events.add(new Event(eventIdCounter++, "TechFest 2026", "2026-12-05", "Main Auditorium"));
        events.add(new Event(eventIdCounter++, "Cultural Night", "2026-12-12", "Open Air Theatre"));

        while (true) {
            System.out.println("\n=== College Event Management System ===");
            System.out.println("1. Add New Event");
            System.out.println("2. View All Events");
            System.out.println("3. Register for an Event");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Event Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Event Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Venue: ");
                    String venue = scanner.nextLine();

                    events.add(new Event(eventIdCounter++, name, date, venue));
                    System.out.println("Event added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Upcoming College Events ---");
                    if (events.isEmpty()) {
                        System.out.println("No events scheduled.");
                    } else {
                        for (Event e : events) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Event ID to register: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;

                    for (Event e : events) {
                        if (e.getId() == id) {
                            System.out.print("Enter Student Name: ");
                            String studentName = scanner.nextLine();
                            e.registerParticipant();
                            System.out.println("Success! " + studentName + " is registered for " + e.getName() + ".");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid Event ID.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}