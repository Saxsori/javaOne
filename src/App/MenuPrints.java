import java.util.Map;

public class MenuPrints implements Global {

	public static void printMain() {
		System.out.println("\n1. View Menu");
		System.out.println("2. Make Order");
		System.out.println("3. Exit\n");
	}

	public static void printOperations() {
		System.out.println("\n1. Add item");
		System.out.println("2. Remove item");
		System.out.println("3. Checkout");
		System.out.println("4. Cancel Order");
		System.out.print("\nEnter your choice: ");	
	}

	public static void printCategoryChoice() {
		System.out.println("\n1. Breakfast");
		System.out.println("2. Meal");
		System.out.println("3. Dessert");
		System.out.print("\nEnter your choice: ");	
	}

	public static void printSortChoice() {
		System.out.println("\n1. Show Normal");
		System.out.println("2. Show High/Low Price");
		System.out.println("3. Show Low/High Price");
		System.out.print("\nEnter your choice: ");
	}

	/*
	 * This function is used to print the order
	 */
	public static void printOrder(Map<String, Double> order)
	{
	    System.out.println("");
	    if (order.isEmpty())
	    {
	    	System.out.println("No order list yet");
	    	return ;
	    }
	    System.out.println("The Order now is ");
		for (Map.Entry<String, Double> entry : order.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue() + " AED");
	    System.out.println("");
	}


	/*
	 * This function is used to print the order based 
	 * on the category 
	 */
	public static void printCategory(Option category){
		System.out.println("");
		if (category == Option.ALL)
		{
			for (Map.Entry<Option, Map<String, Double>> entry : Menu.entrySet())
			{
				System.out.println("\n" + entry.getKey().toString().substring(0, 1) + entry.getKey().toString().substring(1).toLowerCase() + " Menu: ");
				for (Map.Entry<String, Double> entry2 : entry.getValue().entrySet())
					System.out.println(entry2.getKey() + " " + entry2.getValue() + " AED");
			}
			return ;
		}
		System.out.println(category.toString().substring(0, 1) + category.toString().substring(1).toLowerCase() + " Menu1: ");
		for (Map.Entry<String, Double> entry : Menu.get(category).entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue() + "AED");
	}
}