import java.util.Scanner;
import java.util.Arrays;

class Main {
	static String[] breakfastItems = {"Omelette", "Pancakes", "Waffles", "French Toast"};
	static double[] breakfastPrices = {7.99, 6.99, 6.98, 5.99};
	static String[] mealItems = {"Burger", "Pizza", "Fries", "Salad", "Soup", "Sandwich", "Pasta"};
	static double[] mealPrices = {3.99, 7.99, 2.99, 5.99, 4.99, 6.99, 8.99};
	static String[] dessertItems = {"Ice Cream", "Cake", "Brownie", "Cheesecake"};
	static double[] dessertPrices = {4.99, 6.99, 3.99, 7.99};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (true) {
			if (choice == 3)
			break;
			printMain();
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			switch (choice) {
	        	case 1:
		        	System.out.println("view menue");
		        	break ;
		        case 2:
					printCategory(null, true);
		        	makeOrder();
		        	break ;
		        case 3:
	          		System.out.println("Bye !");
					break ;
		        default:
		          System.out.println("Sorry This Service Doesn't Exist please Try Agian !");
				  break ;
	      	}
		}
	}
	

	// Search Menu
	public static String findItem(String category, double price)
	{
		if (category.compareTo(category) == 0)
		{
			for (int i = -1; ++i < breakfastPrices.length;)
			{
				if (breakfastPrices[i] == price)
					return breakfastItems[i];
			}
		}
		else if (category.compareTo("Meal") == 0)
		{
			for (int i = -1; ++i < mealPrices.length;)
			{
				if (mealPrices[i] == price)
					return mealItems[i];
			}
		}
		else if (category.compareTo("Dessert") == 0)
		{
			for (int i = -1; ++i < dessertPrices.length;)
			{
				if (dessertPrices[i] == price)
					return dessertItems[i];
			}
		}
		return "Not Found";
	}

	public static double findPrice(String element)
	{
		for (int i = -1; ++i < breakfastItems.length;) {
			if (breakfastItems[i].compareTo(element) == 0)
				return (breakfastPrices[i]);
		}
		for (int i = -1; ++i < mealItems.length;) {
			if (mealItems[i].compareTo(element) == 0)
				return (mealPrices[i]);
		}
		for (int i = -1; ++i < dessertItems.length;) {
			if (dessertItems[i].compareTo(element) == 0)
				return (dessertPrices[i]);
		}
		return (0.0);
	}

	// Sort Menu
	public static void sortMenu(String category, String sort)
	{
		if (sort.compareTo("Normal") == 0)
		{
			printCategory(category, false);
			return ;
		}
		double [] copy = new double[1];
		if (category.compareTo("Breakfast") == 0)
			copy = Arrays.copyOf(dessertPrices, dessertPrices.length);
		else if (category.compareTo("Meal") == 0)
			copy = Arrays.copyOf(mealPrices, mealPrices.length);
		else if (category.compareTo("Dessert") == 0)
			copy = Arrays.copyOf(dessertPrices, dessertPrices.length);
		Arrays.sort(copy);
		if (sort.compareTo("High/Low") == 0)
		{
			for (int i = copy.length; --i >= 0;)
				System.out.println(findItem(category, copy[i]) + " " + copy[i] + "AED");
		}
		else if (sort.compareTo("Low/High") == 0)
		{
			for (int i = -1; ++i < copy.length;)
				System.out.println(findItem(category, copy[i]) + " " + copy[i] + "AED");
		}
	}

	public static void sortFeatures()
	{
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Choose which food category you are looking for");
		System.out.println("1. Breakfast");
		System.out.println("2. Meal");
		System.out.println("3. Dessert");
		int category = scanner.nextInt();
		System.out.println("1. Show Normal");
		System.out.println("2. Show High/Low Price");
		System.out.println("3. Show Low/High Price");
		int sort = scanner.nextInt();
		switch (category) {
			case 1:
				if (sort == 1)
					sortMenu("Breakfast", "Normal");
				else if (sort == 2)
					sortMenu("Breakfast", "High/Low");
				else if (sort == 3)
					sortMenu("Breakfast", "Low/High");
				break ;
			case 2:
				if (sort == 1)
					sortMenu("Meal", "Normal");
				else if (sort == 2)
					sortMenu("Meal", "High/Low");
				else if (sort == 3)
					sortMenu("Meal", "Low/High");
				break ;
			case 3:
				if (sort == 1)
					sortMenu("Dessert", "Normal");
				else if (sort == 2)
					sortMenu("Dessert", "High/Low");
				else if (sort == 3)
					sortMenu("Dessert", "Low/High");
				break ;
			default:
				System.out.println("Sorry This Service Doesn't Exist please Try Agian !");
				break ;
		}

	}


	// Menu Operations
	public static void makeOrder()
	{
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
	    String order [] = new String[1];
	    while (true) {
			printOperations();
		    choice = scanner.nextInt();
			while (true)
			{
				System.out.println("");
				if (choice == 1)
					System.out.println("- What is the name of the Food you want to Add ?");
				else if (choice == 2)
					System.out.println("- What is the name of the Food you want to Remove ?");
				else if (choice == 3)
				{
					System.out.println("The total price is " + checkout(order) + "AED");
					System.out.println("Thank you for your order");
					return ;
				}
				else if (choice == 4)
				{
					System.out.println("The order has been canceled");
					order = new String[1];
					return ;
				}
				else
				{
					System.out.println("Sorry This Service Doesn't Exist please Try Agian !");
					return;
				}
				System.out.println("- Type <Done> without <> when you're done !");
				String userAnswer = scanner.nextLine();
				if (userAnswer.compareTo("Done") == 0)
					break ;
				else if (findPrice(userAnswer) == 0.0)
					System.out.println("---> Element not found please try again");
				else
				{
					if (choice == 1)
					{
						order = addItem(order, userAnswer);
						System.out.println("---> Element have been added successfuly");
					}
					if (choice == 2)
					{
						order = removeItem(order, userAnswer);
						System.out.println("---> Element have been removed successfuly");
					}
				}
				printOrder(order);
			}
		}
	}

	public static String[] removeItem(String []order, String element)
	{
		String [] newOrder = new String [order.length - 1];
		int i = -1;
		int j = -1;
		while (++i < order.length)
		{
			if (order[i].compareTo(element) != 0)
				newOrder[++j] = order[i];
		}
		return (newOrder);
	}

	public static double checkout(String [] items)
	{
		double total = 0.0;
		for (int i = -1; ++i < items.length;)
			total += findPrice(items[i]);
		return (total);
	}

	public static String[] addItem(String []order, String newElement)
	{
		String [] newOrder = new String [order.length + 1];
		int i = -1;
		if (order.length == 1 && order[0] == null)
		{
			order[0] = newElement;
			return (order);
		}
		while (++i < order.length)
			newOrder[i] = order[i];
		newOrder[i] = newElement;
		return (newOrder);

	}

	public static void printCategory(String category, boolean isAll){
		if (category.compareTo("Breakfast") == 0 || isAll)
		{
			for (int i = -1; ++i < breakfastItems.length;)
				System.out.println(breakfastItems[i] + " " + breakfastPrices[i] + "AED");
		}
		else if (category.compareTo("Meal") == 0 || isAll)
		{
			System.out.println("Meal Menu");
			for (int i = -1; ++i < mealItems.length;)
				System.out.println(mealItems[i] + " " + mealPrices[i] + "AED");
		}
		else if (category.compareTo("Dessert") == 0 || isAll)
		{
			System.out.println("Dessert Menu");
			for (int i = -1; ++i < dessertItems.length;)
				System.out.println(dessertItems[i] + " " + dessertPrices[i] + "AED");
		}
	}

	public static void printOrder(String [] items)
	{
	    System.out.println("");
	    if (items.length == 1 && items[0] == null)
	    {
	    	System.out.println("No order list yet");
	    	return ;
	    }
	    System.out.println("The Order now is ");
	    for (int i = -1; ++i < items.length;)
	    	System.out.println(items[i]);
	    System.out.println("");
	}

	public static void printMain() {
		System.out.println("");
		System.out.println("1. View Menu");
		System.out.println("2. Make Order");
		System.out.println("3. Exit");
		System.out.println("");
	}
	
	public static void printOperations() {
		System.out.println("");
		System.out.println("1. Add item");
		System.out.println("2. Remove item");
		System.out.println("3. Checkout");
		System.out.println("4. Cancel Order");
		System.out.print("Enter your choice: ");	
	}
}