import java.util.Map;

public interface Global 
{
    Map<String, Double> Breakfast = Map.of(
        "Pancakes", 6.99,
        "Omelette", 7.99,
        "Waffles", 6.98,
        "French Toast", 5.99
    );
    Map<String, Double> Meal = Map.of(
        "Burger", 3.99,
        "Pizza", 7.99,
        "Fries", 2.98,
        "Soup", 5.99,
        "Sandwich", 4.99,
        "Pasta", 8.99
    );
    Map<String, Double> Dessert = Map.of(
        "Ice Cream", 4.99,
        "Cake", 6.99,
        "Brownie", 3.98,
        "Cheesecake", 7.99
    );
    enum Option {
        ALL,
        BREAKFAST,
        MEAL,
        DESSERT
    }
    Map<Option, Map<String, Double>> Menu = Map.of(
        Option.BREAKFAST, Breakfast,
        Option.MEAL, Meal,
        Option.DESSERT, Dessert
    );
}
