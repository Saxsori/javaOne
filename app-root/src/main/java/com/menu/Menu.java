package com.menu;
import com.menu.*;

import java.util.*;

public class Menu implements Global {

	public static MenuPrints out;
	static Map<String, Double> order = new HashMap<>();

    public static <K, V> K getItemByPrice(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet())
            if (value.equals(entry.getValue()))
                return entry.getKey();
        return null;
    }

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByPrice(Map<K, V> map) {
		Map<K, V> copiedMap = new HashMap<>(map);
	
		List<Map.Entry<K, V>> list = new ArrayList<>(copiedMap.entrySet());
		list.sort(Map.Entry.comparingByValue());
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
	    while (true) {
			out.printOperations();
		    choice = scanner.nextInt();
			while (true)
			{
				System.out.println(choice == 3 ? "" : "\n" + messages.get(MsgTag.values()[choice > 4 || choice < 1 ? 4 : choice - 1]));
				if (choice > 2 || choice < 1)
				{
					System.out.println(choice);
					if (choice == 3)
					{
						if (order.isEmpty())
							System.out.println("\n" + messages.get(MsgTag.MESSAGE_EMPTY_ORDER));
						else
							System.out.println("The total price is " + checkout() + "AED");
					}
					order.clear();
					return;
				}
				System.out.println(messages.get(MsgTag.MESSAGE_TYPE_DONE));
				String userAnswer = scanner.next();
				if (userAnswer.compareTo("Done") == 0)
					break ;
				else if (findPrice(userAnswer) == 0.0)
					System.out.println("\n" + messages.get(MsgTag.MESSAGE_ELEMENT_NOTFOUND));
				else
					if (! modifyOrder(choice, userAnswer))
						continue ;
				out.printOrder(order);
			}
		}
	}

	public static boolean modifyOrder(int choice, String userAnswer)
	{
		String modify = choice == 1 ? "add" : "remove";
		if (modify == "add")
		{
			if (order.containsKey(userAnswer))
			{
				System.out.println("\n" + messages.get(MsgTag.MESSAGE_ELEMENT_LISTEXIST));
				return false ;
			}
			order.put(userAnswer, findPrice(userAnswer));
		}
		if (modify == "remove")
		{
			if (!order.containsKey(userAnswer))
			{
				System.out.println("\n" + messages.get(MsgTag.MESSAGE_ELEMENT_NOT_LISTEXIST));
				return false ;
			}
			order.remove(userAnswer);
		}
		System.out.println("\n---> Element have been " + modify + "ed successfuly");
		return true;
	}

	public static double findPrice(String element)
	{
		for (Map.Entry<Option, Map<String, Double>> entry : Menu.entrySet())
			for (Map.Entry<String, Double> entry2 : entry.getValue().entrySet())
				if (entry2.getKey().compareTo(element) == 0)
					return entry2.getValue() ;
		return 0.0;
	}

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
}