package model;

public class PassengerMapper {
    public PassengerDTO toDTO(Passenger passenger) {
        return new PassengerDTO(passenger.getName(), passenger.getSeatNumber());
    }

    public Passenger toDomainObject(PassengerDTO passengerDTO) {
        return new Passenger(passengerDTO.getName(), passengerDTO.getSeatNumber());
    }
}

