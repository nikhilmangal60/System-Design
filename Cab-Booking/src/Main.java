import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map<String, User> userMap = new HashMap<>();
        Map<String, Driver> driverMap = new HashMap<>();
        userMap.put("Abhishek", BookingService.add_user("Abhishek", 23, 'M'));
        userMap.put("Rahul", BookingService.add_user("Rahul", 29, 'M'));
        userMap.put("Nandini", BookingService.add_user("Nandini", 22, 'F'));
        BookingService.update_userLocation("Abhishek", userMap, 0, 0);
        BookingService.update_userLocation("Rahul", userMap, 10, 0);
        BookingService.update_userLocation("Nandini", userMap, 15, 6);

        driverMap.put("Driver1", BookingService.add_driver("Driver1", 22, 'M', new Vehicle("Swift", "KA-01-12345"), 10, 1));
        driverMap.put("Driver2", BookingService.add_driver("Driver2", 29, 'M', new Vehicle("Swift", "KA-01-12345"), 11, 10));
        driverMap.put("Driver3", BookingService.add_driver("Driver3", 24, 'M', new Vehicle("Swift", "KA-01-12345"), 5, 3));

        List<Driver> availableDrivers = BookingService.find_ride("Abhishek", new int[]{0,0}, new int[]{20,1}, driverMap);
        BookingService.isDriverAvailable(availableDrivers);

        availableDrivers = BookingService.find_ride("Rahul", new int[]{10,0}, new int[]{15,3}, driverMap);
        BookingService.isDriverAvailable(availableDrivers);
        BookingService.choose_ride("Rahul",availableDrivers.getFirst().getName());
        BookingService.calculateBill("Rahul", "Driver1", new int[]{10,0}, new int[]{15,3}, driverMap);
        BookingService.update_userLocation("Rahul", userMap, 15, 3);
        BookingService.update_driverLocation("Driver1", 15, 3, driverMap);
        BookingService.change_driver_status("Driver1", false, driverMap);

        availableDrivers = BookingService.find_ride("Nandini", new int[]{15,6}, new int[]{20,4}, driverMap);
        BookingService.isDriverAvailable(availableDrivers);
        BookingService.find_total_earning(driverMap);
    }
}