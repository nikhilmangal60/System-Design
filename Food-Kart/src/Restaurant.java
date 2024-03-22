import java.util.Map;

public class Restaurant {
    private String name;
    private Map<String, Integer> menu;
    private int total_capacity;
    private int capacity_in_use;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Integer> menu) {
        this.menu = menu;
    }

    public int getTotal_capacity() {
        return total_capacity;
    }

    public void setTotal_capacity(int total_capacity) {
        this.total_capacity = total_capacity;
    }

    public int getCapacity_in_use() {
        return capacity_in_use;
    }

    public void setCapacity_in_use(int capacity_in_use) {
        this.capacity_in_use = capacity_in_use;
    }

    public Restaurant() {
    }

    public Restaurant(String name, Map<String, Integer> menu, int total_capacity, int capacity_in_use) {
        this.name = name;
        this.menu = menu;
        this.total_capacity = total_capacity;
        this.capacity_in_use = capacity_in_use;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", menu=" + menu +
                ", total_capacity=" + total_capacity +
                ", capacity_in_use=" + capacity_in_use +
                '}';
    }
}
