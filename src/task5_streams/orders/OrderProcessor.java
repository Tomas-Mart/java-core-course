package task5_streams.orders;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class OrderProcessor {

    public List<Map.Entry<String, Double>> getTop3ProductsByTotalCost(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return List.of();
        }

        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::product,
                        Collectors.summingDouble(Order::cost)
                ))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public void printTop3Products(List<Map.Entry<String, Double>> top3) {
        if (top3.isEmpty()) {
            System.out.println("No orders found");
            return;
        }

        System.out.println("Top 3 most expensive products:");
        for (Map.Entry<String, Double> entry : top3) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}