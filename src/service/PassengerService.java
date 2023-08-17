package service;
import model.*;
import java.io.*;
import java.util.*;

public class PassengerService {
        private PassengerMapper mapper = new PassengerMapper();

        public void savePassengerToFile(Passenger passenger, File file) throws IOException {
            PassengerDTO dto = mapper.toDTO(passenger);
            FileWriter writer = null;
            BufferedWriter buffer = null;
            try {
                writer = new FileWriter(file, true);
                buffer = new BufferedWriter(writer);
                buffer.write(dto.getName() + ", " + dto.getSeatNumber() + "\n");
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
            }
        }
        // Add this method to the PassengerService class
        public List<Passenger> readPassengersFromFile(File file) throws IOException {
            List<Passenger> passengers = new ArrayList<>();
            BufferedReader buffer = null;

            try {
                buffer = new BufferedReader(new FileReader(file));
                String line;

                while ((line = buffer.readLine()) != null) {
                    String[] parts = line.split(", ");
                    String name = parts[0];
                    int seatNumber = Integer.parseInt(parts[1]);

                    PassengerDTO dto = new PassengerDTO(name, seatNumber);
                    Passenger passenger = mapper.toDomainObject(dto);
                    passengers.add(passenger);
                }
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
            }

            return passengers;
        }

    }


