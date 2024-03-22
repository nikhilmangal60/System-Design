import java.util.Map;

public class OrderDetails {
    private String restaurant;
    private Map<String, Integer> items;

    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public OrderDetails() {
    }

    public OrderDetails(String restaurant, Map<String, Integer> items, int cost) {
        this.restaurant = restaurant;
        this.items = items;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "restaurant='" + restaurant + '\'' +
                ", items=" + items +
                ", cost=" + cost +
                '}';
    }
}
