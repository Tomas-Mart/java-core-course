package task4_concurrency.completable_future;

public final class CompletableFutureExample {
    public static void main(String[] args) {
        DataAggregator aggregator = new DataAggregator();

        String productName = "Ноутбук";
        ProductInfo productInfo = aggregator.aggregateProductInfo(productName);

        System.out.println(productInfo);
    }
}