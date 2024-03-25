public class Vehicle {
    private String vName;
    private String vNumber;

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvNumber() {
        return vNumber;
    }

    public void setvNumber(String vNumber) {
        this.vNumber = vNumber;
    }

    public Vehicle() {
    }

    public Vehicle(String vName, String vNumber) {
        this.vName = vName;
        this.vNumber = vNumber;
    }
}
