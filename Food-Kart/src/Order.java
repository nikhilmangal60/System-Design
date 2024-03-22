import java.util.List;

public class Order {
    private int order_id;
    private String user;
    private List<OrderDetails> order_details;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<OrderDetails> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(List<OrderDetails> order_details) {
        this.order_details = order_details;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", user='" + user + '\'' +
                ", order_details=" + order_details +
                '}';
    }
}
