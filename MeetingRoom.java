package PhamThuanHoang_9436;

import java.util.Date;
import java.util.Scanner;

public class MeetingRoom extends Room{
    private int capacity;

    public MeetingRoom(int capacity, String id, String name, double baseCost, Date checkinDate, Date checkoutDate) {
        super(id, name, baseCost, checkinDate, checkoutDate);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    @Override
    public double calculateCost(){
        double cost = getBaseCost() * calculateDayStays();
        if(capacity > 50){
            cost *= 1.2;
        }
        return cost;
    }
    
    @Override
    public void enterRoomInfo() {
        super.enterRoomInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Capacity: ");
        capacity = sc.nextInt();
    }
    
    @Override
    public void updateRoomById(String id) {
        if (getId().equals(id)) {
            System.out.println("Updating meeting room with ID: " + id);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter new Capacity: ");
            capacity = sc.nextInt();
        } else {
            System.out.println("Room ID does not match.");
        }
    }
    
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Capacity: " + capacity);
        System.out.println("Total Cost: " + calculateCost());
    }
}
