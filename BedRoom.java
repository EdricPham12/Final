package PhamThuanHoang_9436;

import java.util.Date;
import java.util.Scanner;

public class BedRoom extends Room{
    private int numberOfBeds;

    public BedRoom(int numberOfBeds, String id, String name, double baseCost, Date checkinDate, Date checkoutDate) {
        super(id, name, baseCost, checkinDate, checkoutDate);
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
    
    @Override
    public double calculateCost(){
        double cost = getBaseCost() * calculateDayStays();
        if(numberOfBeds >= 3){
            cost *= 1.1;
        }
        return cost;
    }
    
    @Override
    public void enterRoomInfo() {
        super.enterRoomInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Beds: ");
        numberOfBeds = sc.nextInt();
    }
    
    @Override
    public void updateRoomById(String id) {
        if (getId().equals(id)) {
            System.out.println("Updating bed room with ID: " + id);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter new Number of Beds: ");
            numberOfBeds = sc.nextInt();
        } else {
            System.out.println("Room ID does not match.");
        }
    }
    
     @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Beds: " + numberOfBeds);
        System.out.println("Total Cost: " + calculateCost());
    }
}
