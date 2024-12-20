package PhamThuanHoang_9436;

import java.util.ArrayList;

public class RoomList {
    ArrayList<Room> roomList = new ArrayList<>();

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public boolean updateRoomById(String id, Room updatedRoom) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId().equals(id)) {
                roomList.set(i, updatedRoom);
                return true;
            }
        }
        return false;
    }

    public boolean deleteRoomById(String id) {
        return roomList.removeIf(room -> room.getId().equals(id));
    }

    public Room findRoomById(String id) {
        for (Room room : roomList) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public void displayAllRooms() {
        if (roomList.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }
        for (Room room : roomList) {
            room.displayDetails();
        }
    }

    public Room findMostExpensiveRoom() {
        if (roomList.isEmpty()) return null;

        Room mostExpensive = null;
        double highestCost = 0;
        for (Room room : roomList) {
            double cost = room.calculateCost();
            if (cost > highestCost) {
                highestCost = cost;
                mostExpensive = room;
            }
        }
        return mostExpensive;
    }

    public void countRooms() {
        int meetingRooms = 0, bedRooms = 0;
        for (Room room : roomList) {
            if (room instanceof MeetingRoom) {
                meetingRooms++;
            } else if (room instanceof BedRoom) {
                bedRooms++;
            }
        }
        System.out.println("Meeting Rooms: " + meetingRooms + ", Bed Rooms: " + bedRooms);
    }
}
