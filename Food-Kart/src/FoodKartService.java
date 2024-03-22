import java.util.*;

public class FoodKartService {
    public static Restaurant add_restaurant(String name, Map<String, Integer> menu, int capacity) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setTotal_capacity(capacity);
        restaurant.setMenu(menu);
        return restaurant;
    }

    public static void update_menu(String name, Map<String, Integer> menu, Map<String, Restaurant> restaurantMap) {
        Restaurant restaurant = restaurantMap.get(name);
        Map<String, Integer> restaurantMenu = restaurant.getMenu();
        restaurantMenu.putAll(menu);
        restaurant.setMenu(restaurantMenu);
        restaurantMap.put(name, restaurant);
    }

    public static void printAllRestaurants(Map<String, Restaurant> restaurantMap) {
        for (Map.Entry<String, Restaurant> map : restaurantMap.entrySet()) {
            System.out.println(map);
        }
    }

    public static void printAllOrders(Map<Integer, Order> orderMap) {
        for (Map.Entry<Integer, Order> map : orderMap.entrySet()) {
            System.out.println(map);
        }
    }

    public static List<Object> book(String custName, OrderDetails orderDetails, Map<Integer, Order> orderMap, Map<String, Restaurant> restaurantMap) {
        List<Object> list = new ArrayList<>();
        Map<String, OrderDetails> orderDetailsMap = new HashMap<>();
        int size = orderMap.size();
        int orderId = size + 1;

        Map<String, Integer> items = orderDetails.getItems();
        int allItems = items.size();
        for (Map.Entry<String, Integer> it : items.entrySet()) {
            int totalCost = 0;
            int minCost = Integer.MAX_VALUE;
            String resName = "";
            String item = it.getKey();
            int q = it.getValue();

            for (Map.Entry<String, Restaurant> restaurantEntry : restaurantMap.entrySet()) {
                Restaurant restaurant = restaurantEntry.getValue();
                String name = restaurantEntry.getKey();
                int cap = restaurant.getTotal_capacity();
                Map<String, Integer> menu = restaurant.getMenu();

                if (cap >= q) {
                    for (Map.Entry<String, Integer> m : menu.entrySet()) {
                        if (m.getKey().equals(item) && minCost > m.getValue()) {
                            resName = name;
                            minCost = m.getValue();
                            break;
                        }
                    }
                }
            }
            if (!resName.isBlank()) {
                allItems--;
                totalCost = totalCost + minCost * q;
                Restaurant restaurant = restaurantMap.get(resName);
                int updatedCapacity = restaurant.getTotal_capacity() - q;
                int updatedCapacityInUse = restaurant.getCapacity_in_use() + q;
                restaurant.setTotal_capacity(updatedCapacity);
                restaurant.setCapacity_in_use(updatedCapacityInUse);
                restaurantMap.put(resName, restaurant);
                if(orderDetailsMap.containsKey(resName))
                {
                    OrderDetails orderDetails1 = orderDetailsMap.get(resName);
                    orderDetails1.setCost(orderDetails1.getCost()+totalCost);
                    Map<String, Integer> m = orderDetails1.getItems();
                    m.put(item, q);
                    orderDetails1.setItems(m);
                    orderDetailsMap.put(resName, orderDetails1);
                }
                else{
                    OrderDetails orderDetails1 = new OrderDetails();
                    Map<String, Integer> m = new HashMap<>();
                    m.put(item, q);
                    list.add(resName);
                    orderDetails1.setItems(m);
                    orderDetails1.setCost(totalCost);
                    orderDetails1.setRestaurant(resName);
                    orderDetailsMap.put(resName, orderDetails1);
                }
            }
        }
        if (allItems == 0) {
            Order newOrder = new Order();
            newOrder.setUser(custName);
            newOrder.setOrder_id(orderId);
            List<OrderDetails> orderDetailsList = new ArrayList<>();
            for(Map.Entry<String, OrderDetails> orderDetailsEntry : orderDetailsMap.entrySet())
            {
                orderDetailsList.add(orderDetailsEntry.getValue());
            }
            newOrder.setOrder_details(orderDetailsList);
            orderMap.put(orderId, newOrder);
            list.add(orderId);
        }
        else{
            list.clear();
        }
        return list;
    }

    public static void markAsComplete(int orderId, Map<Integer, Order> orderMap, Map<String, Restaurant> restaurantMap)
    {
        Order order = orderMap.get(orderId);
        List<OrderDetails> orderDetailsList = order.getOrder_details();
        for(OrderDetails orderDetails : orderDetailsList)
        {
            Restaurant restaurant = restaurantMap.get(orderDetails.getRestaurant());
            int cap = 0;
            for(Map.Entry<String, Integer> item : orderDetails.getItems().entrySet())
            {
                cap+=item.getValue();
            }
            restaurant.setTotal_capacity(restaurant.getTotal_capacity()+cap);
            restaurant.setCapacity_in_use(restaurant.getCapacity_in_use()-cap);
            restaurantMap.put(orderDetails.getRestaurant(), restaurant);
        }
    }
}
