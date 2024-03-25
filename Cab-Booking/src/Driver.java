public class Driver {
    private String name;
    private int age;
    private Character gender;
    private Vehicle vehicle;
    private int[] location;
    private Boolean isAvailable = true;
    private int earning;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public int getEarning() {
        return earning;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }

    public Driver() {
    }

    public Driver(String name, int age, Character gender, Vehicle vehicle, int[] location, Boolean isAvailable, int earning) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.vehicle = vehicle;
        this.location = location;
        this.isAvailable = isAvailable;
        this.earning = earning;
    }
}
