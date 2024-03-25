import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class BookingService {
    public static User add_user(String userName, int age, Character gender)
    {
        User user = new User();
        user.setUserName(userName);
        user.setAge(age);
        user.setGender(gender);
        return user;
    }

    public static void update_user(String userName, Map<String, User> userMap, String mobileNumber, String email)
    {
        User user = userMap.get(userName);
        user.setEmail(email);
        user.setMobileNumber(mobileNumber);
        userMap.put(userName, user);
    }

    public static void update_userLocation(String userName, Map<String, User> userMap, int x, int y)
    {
        User user = userMap.get(userName);
        int[] currLocation = user.getLocation();
        currLocation[0] = x;
        currLocation[1] = y;
        user.setLocation(currLocation);
        userMap.put(userName, user);
    }

    public static Driver add_driver(String name, int age, Character gender, Vehicle vehicle, int x, int y)
    {
        Driver driver =  new Driver();
        driver.setName(name);
        driver.setAge(age);
        driver.setGender(gender);
        driver.setVehicle(vehicle);
        int[] location = new int[2];
        location[0] = x;
        location[1] = y;
        driver.setLocation(location);
        return driver;
    }

    public static void update_driverLocation(String name, int x, int y, Map<String, Driver> driverMap)
    {
        Driver driver = driverMap.get(name);
        int[] currLocation = driver.getLocation();
        currLocation[0] = x;
        currLocation[1] = y;
        driver.setLocation(currLocation);
        driverMap.put(name, driver);
    }

    public static void change_driver_status(String name, Boolean isAvailable, Map<String, Driver> driverMap)
    {
        Driver driver = driverMap.get(name);
        driver.setAvailable(isAvailable);
        driverMap.put(name, driver);
    }

    public static List<Driver> find_ride(String userName, int[] source, int[] destination, Map<String, Driver> driverMap)
    {
        List<Driver> availableDrivers = new ArrayList<>();
        String name ="";
        int min = Integer.MAX_VALUE;
        for(Map.Entry<String, Driver> map : driverMap.entrySet())
        {
            Driver driver = map.getValue();
            if(driver.getAvailable())
            {
                int[] driverLocation = driver.getLocation();
                int distance = (int) Math.round(Math.sqrt(Math.pow(source[0]-driverLocation[0],2)+Math.pow(source[1]-driverLocation[1],2)));
                if(distance<=5 && min>distance)
                {
//                    availableDrivers.add(driver);
                    name=driver.getName();
                    min = distance;
                }
            }
        }
        if(!name.isBlank())
            availableDrivers.add(driverMap.get(name));
        return availableDrivers;
    }

    public static void choose_ride(String userName, String driverName)
    {
        System.out.println("Ride Started for user- "+userName+" with driver- "+driverName);
    }

    public static int calculateBill(String userName, String driverName, int[] source, int[] destination, Map<String, Driver> driverMap)
    {
        int bill = (int) Math.round(Math.sqrt(Math.pow(source[0]-destination[0],2)+Math.pow(source[1]-destination[1],2)));
        Driver driver = driverMap.get(driverName);
        driver.setEarning(driver.getEarning()+bill);
        driverMap.put(driverName, driver);
        System.out.println("ride Ended bill amount "+ bill);
        return bill;
    }

    public static void find_total_earning(Map<String, Driver> driverMap)
    {
        for(Map.Entry<String, Driver> map : driverMap.entrySet())
        {
            Driver driver = map.getValue();
            System.out.println(driver.getName()+" earn- "+driver.getEarning());
        }
    }

    public static void isDriverAvailable(List<Driver> drivers)
    {
        if(drivers.isEmpty())
            System.out.println("No ride found");
        else
            System.out.println("Available drivers: "+ drivers.size());
    }
}
