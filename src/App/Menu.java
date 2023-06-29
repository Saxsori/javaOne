import java.util.Scanner;
import java.util.Arrays;

class Menu implements Global {

	static MenuPrints out;

	/*
	 * This function is used to find the item that the user wants
	 * using the category and the price
	 */
	public static String findItem(Option category, double price)
	{
		switch (category) {
			case BREAKFAST:
				for (int i = -1; ++i < breakfastPrices.length;)
				{
					if (breakfastPrices[i] == price)
						return breakfastItems[i];
				}
				break ;
			case MEAL:
				for (int i = -1; ++i < mealPrices.length;)
				{
					if (mealPrices[i] == price)
						return mealItems[i];
				}
				break ;
			case DESSERT:
				for (int i = -1; ++i < dessertPrices.length;)
				{
					if (dessertPrices[i] == price)
						return dessertItems[i];
				}
				break ;
		}
		return "Not Found";
	}

	/*
	 * This function is used to find the price of the item
	 */
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
	/*
	 * This function used to sort the menu depending on the category and 
	 * the filter that the user wants
	 * and the sort is used here to implement the filter
	 */
	public static void sortMenu(Option category, String sort)
	{
		if (sort.compareTo("Normal") == 0)
		{
			out.printCategory(category);
			return ;
		}
		double [] copy = new double[1];
		if (category == Option.BREAKFAST)
			copy = Arrays.copyOf(breakfastPrices, breakfastPrices.length);
		else if (category == Option.MEAL)
			copy = Arrays.copyOf(mealPrices, mealPrices.length);
		else if (category == Option.DESSERT)
			copy = Arrays.copyOf(dessertPrices, dessertPrices.length);
		Arrays.sort(copy);
		System.out.println("");
		if (sort.compareTo("High/Low") == 0)
		{
			System.out.println("High/Low: ");
			for (int i = copy.length; --i >= 0;)
				System.out.println(findItem(category, copy[i]) + " " + copy[i] + "AED");
		}
		else if (sort.compareTo("Low/High") == 0)
		{
			System.out.println("Low/High: ");
			for (int i = -1; ++i < copy.length;)
				System.out.println(findItem(category, copy[i]) + " " + copy[i] + "AED");
		}
	}

	/*
	 * This function mainly used to print the main menu Depending
	 * on the filter that the user wants
	 * here where the sort function is called
	 */
	public static void sortFeatures()
	{
		Scanner scanner = new Scanner(System.in);

		out.printCategoryChoice();
		int category = scanner.nextInt();
		out.printSortChoice();
		int sort = scanner.nextInt();
		switch (category) {
			case 1:
				if (sort == 1)
					sortMenu(Option.BREAKFAST, "Normal");
				else if (sort == 2)
					sortMenu(Option.BREAKFAST, "High/Low");
				else if (sort == 3)
					sortMenu(Option.BREAKFAST, "Low/High");
				break ;
			case 2:
				if (sort == 1)
					sortMenu(Option.MEAL, "Normal");
				else if (sort == 2)
					sortMenu(Option.MEAL, "High/Low");
				else if (sort == 3)
					sortMenu(Option.MEAL, "Low/High");
				break ;
			case 3:
				if (sort == 1)
					sortMenu(Option.DESSERT, "Normal");
				else if (sort == 2)
					sortMenu(Option.DESSERT, "High/Low");
				else if (sort == 3)
					sortMenu(Option.DESSERT, "Low/High");
				break ;
			default:
				System.out.println("Sorry This Service Doesn't Exist please Try Agian !");
				break ;
		}

	}


	// Menu Operations
	/*
	 * This Function is used to make the order
	 * and to print the total price
	 * and to print the order
	 * and to remove an item from the order
	 * and to add an item to the order
	 * and to checkout
	 */
	public static void makeOrder()
	{
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
	    String order [] = new String[1];
	    while (true) {
			out.printOperations();
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
					if (order.length == 1 && order[0] == null)
					{
						System.out.println("Your Order is Empty");
						break ;
					}
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
				String userAnswer = scanner.next();
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
				out.printOrder(order);
			}
		}
	}

	/*
	 * this function is used to remove an item from the order
	 * and to return the new order
	 */				
	public static String[] removeItem(String []order, String element)
	{
		String [] newOrder = new String [order.length - 1];
		int i = -1;
		int j = -1;
		if (order.length == 1 && order[0] == null)
		{
			System.out.println("No thing to remove");
			return (order);
		}
		while (++i < order.length)
		{
			if (order[i].compareTo(element) != 0)
				newOrder[++j] = order[i];
		}
		return (newOrder);
	}

	/*
	 * This function is used to checkout and to return the total price
	 * of the order
	 */
	public static double checkout(String [] items)
	{
		double total = 0.0;
		for (int i = -1; ++i < items.length;)
			total += findPrice(items[i]);
		return (total);
	}

	/*
	 * This function is used to Add an item to the order
	 * and to return the new order based on the old order
	 */
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



}