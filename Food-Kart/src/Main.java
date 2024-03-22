import java.util.*;

import static java.util.Map.entry;

public class Main {
    public static void main(String[] args) {
        Map<String, Restaurant> restaurantMap = new HashMap<>();
        Map<Integer, Order> orderMap = new HashMap<>();

        Map<String, Integer> menu1 = new HashMap<>();
        menu1.put("king_burger", 10);
        menu1.put("samosa_pizza", 20);
        menu1.put("alu_pasta",19);

        Map<String, Integer> menu2 = new HashMap<>();
        menu2.put("bendi_macaroni",12);
        menu2.put("samosa_pizza", 25);
        menu2.put("alu_pasta", 17);

        restaurantMap.put("resta1", FoodKartService.add_restaurant("resta1", menu1, 15));
        restaurantMap.put("resta2", FoodKartService.add_restaurant("resta2", menu2, 12));

        Map<String, Integer> nMenu1 = new HashMap<>();
        nMenu1.put("bendi_macaroni", 8);
        nMenu1.put("king_burger", 15);
        nMenu1.put("samosa_pizza", 20);

        FoodKartService.update_menu("resta1", nMenu1, restaurantMap);

        FoodKartService.printAllRestaurants(restaurantMap);

        Map<String, Integer> bookMenu1 = Map.ofEntries(
                entry("bendi_macaroni",3),
                entry("samosa_pizza", 2)
        );
        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setItems(bookMenu1);

        List<Object> list = FoodKartService.book("cust1", orderDetails1, orderMap, restaurantMap);
        System.out.println(list);

        FoodKartService.printAllRestaurants(restaurantMap);
        FoodKartService.printAllOrders(orderMap);

        if(!list.isEmpty())
        {
            int orderId = (int) list.getLast();
            FoodKartService.markAsComplete(orderId, orderMap, restaurantMap);
        }
        else {
            System.out.println("Order not placed successfully");
        }

        FoodKartService.printAllRestaurants(restaurantMap);
    }
}