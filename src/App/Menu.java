import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.TreeMap;

class Menu implements Global {

	static MenuPrints out;
	static Map<String, Double> order = new HashMap<>();

	// /*
	//  * This function is used to find the item that the user wants
	//  * using the category and the price
	//  */
    public static <K, V> K getItemByPrice(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null; // Value not found in the map
    }

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByPrice(Map<K, V> map) {
		Map<K, V> copiedMap = new HashMap<>(map);
	
		List<Map.Entry<K, V>> list = new ArrayList<>(copiedMap.entrySet());
		list.sort(Map.Entry.comparingByValue());
	
		// for (Map.Entry<K, V> entry : list) {
		// 	System.out.println("list: " + entry.getKey() + " " + entry.getValue());
		// }
		Map<K, V> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list)
            sortedMap.put(entry.getKey(), entry.getValue());
	
		return sortedMap;
	}	

	// Sort Menu
	/*
	 * This function used to sort the menu depending on the category and 
	 * the filter that the user wants
	 * and the sort is used here to implement the filter
	 */
	public static void sortMenu(Option category, String sort)
	{
		String Category = category.toString().substring(0, 1) + category.toString().substring(1).toLowerCase();
		System.out.println("\n" + Category + " Menu: ");
		Map<String, Double> sortedMenu = sortByPrice(Menu.get(category));
		if (sort.compareTo("High/Low") == 0)
		{
			List<Map.Entry<String, Double>> entries = new ArrayList<>(sortedMenu.entrySet());
			Collections.reverse(entries);
			entries.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue() + "AED"));
			return ;
		}
		for (Map.Entry<String, Double> entry :sortedMenu.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue() + "AED");
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
					out.printCategory(Option.BREAKFAST);
				else if (sort == 2)
					sortMenu(Option.BREAKFAST, "High/Low");
				else if (sort == 3)
					sortMenu(Option.BREAKFAST, "Low/High");
				break ;
			case 2:
				if (sort == 1)
					out.printCategory(Option.MEAL);
				else if (sort == 2)
					sortMenu(Option.MEAL, "High/Low");
				else if (sort == 3)
					sortMenu(Option.MEAL, "Low/High");
				break ;
			case 3:
				if (sort == 1)
					out.printCategory(Option.DESSERT);
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
		// Map <String, Double> order = new HashMap<String, Double>();
	    // String order [] = new String[1];
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
				// else if (choice == 3)
				// {
				// 	if (order.isEmpty())
				// 	{
				// 		System.out.println("Your Order is Empty");
				// 		break ;
				// 	}
				// 	System.out.println("The total price is " + checkout(order) + "AED");
				// 	System.out.println("Thank you for your order");
				// 	return ;
				// }
			// 	else if (choice == 4)
			// 	{
			// 		System.out.println("The order has been canceled");
			// 		order = new String[1];
			// 		return ;
			// 	}
			// 	else
			// 	{
			// 		System.out.println("Sorry This Service Doesn't Exist please Try Agian !");
			// 		return;
			// 	}
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
						if (order.containsKey(userAnswer))
						{
							System.out.println("---> Element already exists");
							continue ;
						}
						order.put(userAnswer, findPrice(userAnswer));
						System.out.println("---> Element have been added successfuly");
					}
					if (choice == 2)
					{
						order.remove(userAnswer);
						System.out.println("---> Element have been removed successfuly");
					}
				}
				out.printOrder(order);
			}
		}
	}

	public static double findPrice(String element)
	{
		for (Map.Entry<Option, Map<String, Double>> entry : Menu.entrySet())
		{
			for (Map.Entry<String, Double> entry2 : entry.getValue().entrySet())
			{
				if (entry2.getKey().compareTo(element) == 0)
					return entry2.getValue() ;
			}
		}
		return 0.0;
	}

	/*
	 * this function is used to remove an item from the order
	 * and to return the new order
	 */				
	// public static String[] removeItem(String []order, String element)
	// {
	// 	String [] newOrder = new String [order.length - 1];
	// 	int i = -1;
	// 	int j = -1;
	// 	if (order.length == 1 && order[0] == null)
	// 	{
	// 		System.out.println("No thing to remove");
	// 		return (order);
	// 	}
	// 	while (++i < order.length)
	// 	{
	// 		if (order[i].compareTo(element) != 0)
	// 			newOrder[++j] = order[i];
	// 	}
	// 	return (newOrder);
	// }

	/*
	 * This function is used to checkout and to return the total price
	 * of the order
	 */
	public static double checkout()
	{
		double total = 0.0;
		for (Map.Entry<String, Double> entry : order.entrySet())
			total += entry.getValue();
		return (total);
	}

	/*
	 * This function is used to Add an item to the order
	 * and to return the new order based on the old order
	 */
	// public static String[] addItem(String []order, String newElement)
	// {
	// 	String [] newOrder = new String [order.length + 1];
	// 	int i = -1;
	// 	if (order.length == 1 && order[0] == null)
	// 	{
	// 		order[0] = newElement;
	// 		return (order);
	// 	}
	// 	while (++i < order.length)
	// 		newOrder[i] = order[i];
	// 	newOrder[i] = newElement;
	// 	return (newOrder);

	// }
}