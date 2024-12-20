package PhamThuanHoang_9436;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class Room implements IRoom{
    
    private String id;
    private String name;
    private double baseCost;
    private Date checkinDate;
    private Date checkoutDate;

    public Room(String id, String name, double baseCost, Date checkinDate, Date checkoutDate) {
        this.id = id;
        this.name = name;
        this.baseCost = baseCost;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    @Override
    public abstract double calculateCost();
    
    @Override
    public void enterRoomInfo() {
        Scanner sc = new Scanner(System.in);
         SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("id: " + id);
        id = sc.nextLine();
        System.out.println("Name: " + name);
        name = sc.nextLine();
        System.out.println("Bast Cost: " + baseCost);
        baseCost = sc.nextDouble();
        sc.nextLine();
        
        try {
            System.out.print("Enter Check-in Date (dd/MM/yyyy): ");
            checkinDate = sd.parse(sc.nextLine());

            System.out.print("Enter Check-out Date (dd/MM/yyyy): ");
            checkoutDate = sd.parse(sc.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        }    }
    
    @Override
    public void updateRoomById(String id){
        if (this.id.equals(id)) {
            System.out.println("Updating room with ID: " + id);
            enterRoomInfo();
        } else {
            System.out.println("Room ID does not match.");
        }
    }
    
    @Override
    public void displayDetails(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Base Cost: " + baseCost);
        System.out.println("Checkin Date: " + checkinDate);
        System.out.println("Checkout Date: " + checkoutDate);
    }
    
    public long calculateDayStays() {
        long diff = checkoutDate.getTime() - checkinDate.getTime();
        return diff / (1000 * 60 * 60 * 24);
    }
}

