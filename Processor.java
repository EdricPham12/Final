package PhamThuanHoang_9436;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        RoomList roomList = new RoomList();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new Meeting Room");
            System.out.println("2. Add a new Bed Room");
            System.out.println("3. Update Room by ID");
            System.out.println("4. Delete Room by ID");
            System.out.println("5. Find Room by ID");
            System.out.println("6. Display all Rooms");
            System.out.println("7. Find the most expensive Room");
            System.out.println("8. Count Rooms");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter ID: ");
                        String id = sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Base Cost: ");
                        double baseCost = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Enter Check-in Date (dd/MM/yyyy): ");
                        String checkin = sc.nextLine();

                        System.out.print("Enter Check-out Date (dd/MM/yyyy): ");
                        String checkout = sc.nextLine();

                        System.out.print("Enter Capacity: ");
                        int capacity = sc.nextInt();
                        sc.nextLine();

                        MeetingRoom meetingRoom = new MeetingRoom(capacity, id, name, baseCost, sdf.parse(checkin), sdf.parse(checkout));
                        roomList.addRoom(meetingRoom);
                        System.out.println("Meeting Room added.");
                    } catch (Exception e) {
                        System.out.println("Error adding Meeting Room. Try again.");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter ID: ");
                        String id = sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Base Cost: ");
                        double baseCost = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Enter Check-in Date (dd/MM/yyyy): ");
                        String checkin = sc.nextLine();

                        System.out.print("Enter Check-out Date (dd/MM/yyyy): ");
                        String checkout = sc.nextLine();

                        System.out.print("Enter Number of Beds: ");
                        int numberOfBeds = sc.nextInt();
                        sc.nextLine();

                        BedRoom bedRoom = new BedRoom(numberOfBeds, id, name, baseCost, sdf.parse(checkin), sdf.parse(checkout));
                        roomList.addRoom(bedRoom);
                        System.out.println("Bed Room added.");
                    } catch (Exception e) {
                        System.out.println("Error adding Bed Room. Try again.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    String updateId = sc.nextLine();
                    Room roomToUpdate = roomList.findRoomById(updateId);
                    if (roomToUpdate != null) {
                        roomToUpdate.enterRoomInfo();
                        System.out.println("Room updated.");
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = sc.nextLine();
                    if (roomList.deleteRoomById(deleteId)) {
                        System.out.println("Room deleted.");
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to find: ");
                    String findId = sc.nextLine();
                    Room foundRoom = roomList.findRoomById(findId);
                    if (foundRoom != null) {
                        foundRoom.displayDetails();
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;

                case 6:
                    roomList.displayAllRooms();
                    break;

                case 7:
                    Room mostExpensive = roomList.findMostExpensiveRoom();
                    if (mostExpensive != null) {
                        System.out.println("Most Expensive Room:");
                        mostExpensive.displayDetails();
                    } else {
                        System.out.println("No rooms available.");
                    }
                    break;

                case 8:
                    roomList.countRooms();
                    break;

                case 9:
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
