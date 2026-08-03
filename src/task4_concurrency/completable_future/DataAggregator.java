package task4_concurrency.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public final class DataAggregator {

    private static final double DEFAULT_PRICE = 0.0;
    private static final String DEFAULT_DESCRIPTION = "Нет данных";
    private static final double DEFAULT_RATING = 0.0;

    public ProductInfo aggregateProductInfo(String productName) {
        CompletableFuture<Double> priceFuture = CompletableFuture
                .supplyAsync(this::fetchPrice)
                .exceptionally(ex -> DEFAULT_PRICE);

        CompletableFuture<String> descriptionFuture = CompletableFuture
                .supplyAsync(this::fetchDescription)
                .exceptionally(ex -> DEFAULT_DESCRIPTION);

        CompletableFuture<Double> ratingFuture = CompletableFuture
                .supplyAsync(this::fetchRating)
                .exceptionally(ex -> DEFAULT_RATING);

        return priceFuture
                .thenCombine(descriptionFuture, (price, description) ->
                        new ProductInfo(productName, price, description, 0.0))
                .thenCombine(ratingFuture, (productInfo, rating) ->
                        new ProductInfo(productInfo.name(), productInfo.price(), productInfo.description(), rating))
                .join();
    }

    private double fetchPrice() {
        simulateDelay();
        if (shouldFail()) throw new RuntimeException("Price service failed");
        return 899.99 + ThreadLocalRandom.current().nextDouble(-100, 100);
    }

    private String fetchDescription() {
        simulateDelay();
        if (shouldFail()) throw new RuntimeException("Description service failed");
        return "High-performance with advanced features";
    }

    private double fetchRating() {
        simulateDelay();
        if (shouldFail()) throw new RuntimeException("Rating service failed");
        return 4.5 + ThreadLocalRandom.current().nextDouble(-0.5, 0.5);
    }

    private void simulateDelay() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3001));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean shouldFail() {
        return ThreadLocalRandom.current().nextDouble() < 0.2;
    }
}