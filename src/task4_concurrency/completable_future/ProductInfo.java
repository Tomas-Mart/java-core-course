package task4_concurrency.completable_future;

public record ProductInfo(String name, double price, String description, double rating) {

    public ProductInfo {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null or blank");
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        if (rating < 0 || rating > 5) throw new IllegalArgumentException("Rating must be between 0 and 5");
    }

    @Override
    public double price() {
        return round(price, 2);
    }

    @Override
    public double rating() {
        return round(rating, 1);
    }

    private static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
               "name='" + name + '\'' +
               ", price=" + price() +
               ", description='" + description + '\'' +
               ", rating=" + rating() +
               '}';
    }
}