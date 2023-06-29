
public interface Global 
{
    String[] breakfastItems = {"Omelette", "Pancakes", "Waffles", "French Toast"};
	double[] breakfastPrices = {7.99, 6.99, 6.98, 5.99};
	String[] mealItems = {"Burger", "Pizza", "Fries", "Salad", "Soup", "Sandwich", "Pasta"};
	double[] mealPrices = {3.99, 7.99, 2.99, 5.99, 4.99, 6.99, 8.99};
	String[] dessertItems = {"Ice Cream", "Cake", "Brownie", "Cheesecake"};
	double[] dessertPrices = {4.99, 6.99, 3.99, 7.99};
    enum Option {
        ALL,
        BREAKFAST,
        MEAL,
        DESSERT
    }
}
