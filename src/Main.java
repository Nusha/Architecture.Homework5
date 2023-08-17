import java.io.*;
import java.util.List;

import model.*;
import service.*;
public class Main {
    public static void main(String[] args) throws IOException {
        PassengerService service = new PassengerService();

        Passenger ivan  = new Passenger("Иван", 1);
        Passenger masha = new Passenger("Маша", 2);

        File file = new File("passengers.txt");

        // saving the passengers to file
        service.savePassengerToFile(ivan, file);
        service.savePassengerToFile(masha, file);

        System.out.println("Список пассажиров сохранен в файл.");

        List<Passenger> passengers = service.readPassengersFromFile(file);
        System.out.println("Список пассажиров:" + passengers);
    }
}