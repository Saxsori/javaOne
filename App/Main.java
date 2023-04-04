import java.util.Scanner;

class Main {
  static String[] breakfastItems = {"Omelette", "Pancakes", "Waffles", "French Toast"};
  static double[] breakfastPrices = {7.99, 6.99, 6.99, 5.99};
  static String[] mealItems = {"Burger", "Pizza", "Fries", "Salad", "Soup", "Sandwich", "Pasta"};
  static double[] mealPrices = {3.99, 7.99, 2.99, 5.99, 4.99, 6.99, 8.99};
  static String[] dessertItems = {"Ice Cream", "Cake", "Brownie", "Cheesecake"};
  static double[] dessertPrices = {4.99, 6.99, 3.99, 7.99};
  public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		System.out.println("kjk");
		while (true) {
			if (choice == 3)
			break;
			printOptions();
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
      switch (choice){
        case 1:
          System.out.println("view menue");
          break ;
        case 2:
          viewAllmenu();
          makeOrder();
          break ;
        case 3:
          System.out.println("Bye !");
        default:
          System.out.println("Sorry This Service Doesn't Exist please Try Agian !");
      }
		}
  }
  public static void makeOrder()
  {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
    String order [] = new String[1];
    
    System.out.println("1. Add item");
    System.out.println("2. Cancel item");
    System.out.println("3. Checkout");
    System.out.println("3. Cancel Order");
		System.out.print("Enter your choice: ");
    choice = scanner.nextInt();
    switch (choice) {
        case 1:
          while (true)
          {
            System.out.println("- What is the name of the Food you want to Add ?");
            System.out.println("- Type <Done> without <> when you're done !");
            String userAnswer = scanner.nextLine();
            if (userAnswer.compareTo("Done") == 0)
              break ;
            else if (findPrice(userAnswer) == 0.0)
              System.out.println("---> Element not found please try again");
            else
            {
              order = addItem(order, userAnswer);
              System.out.println("---> Element have been added successfuly");
            }
            printOrder(order);
          }
          break;
        
    }
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
// Item #1 pizza 10AED
  public static void viewAllmenu()
  {
      System.out.println("");
    for (int i = -1; ++i < breakfastItems.length;)
      System.out.println("#" + i + " " + breakfastItems[i] + " " + breakfastPrices[i] +  "AED");
    for (int i = -1; ++i < mealItems.length;)
      System.out.println("#" + (i+breakfastItems.length) + " " + mealItems[i] + " " + mealPrices[i] +  "AED");
    for (int i = -1; ++i < dessertItems.length;)
      System.out.println("#" + (i+mealItems.length+breakfastItems.length) + " " + dessertItems[i] + " " + dessertPrices[i] +  "AED");
      System.out.println("");
  }

  public static void printOrder(String [] items)
  {
    double total = 0.0;
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
  
  public static void printOptions() {
      System.out.println("");
      System.out.println("1. View Menu");
      System.out.println("2. Make Order");
      System.out.println("3. Exit");
      System.out.println("");
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
}