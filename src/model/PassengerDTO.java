package model;

public class PassengerDTO {
    private String name;
    private int seatNumber;

    public PassengerDTO(String name, int seatNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return name;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
