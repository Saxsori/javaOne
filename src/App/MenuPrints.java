public class MenuPrints {

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
}