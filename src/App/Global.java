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
    enum MsgTag {
        PROMPT_ADD_FOOD,
        PROMPT_REMOVE_FOOD,
        MESSAGE_CHECKOUT,
        MESSAGE_CANCEL_ORDER,
        MESSAGE_INVALID_CHOICE,
        MESSAGE_EMPTY_ORDER,
        MESSAGE_TYPE_DONE,
        MESSAGE_ELEMENT_NOTFOUND,
        MESSAGE_ELEMENT_LISTEXIST,
        MESSAGE_ELEMENT_NOT_LISTEXIST
    }
    Map<MsgTag, String> messages = Map.of(
        MsgTag.PROMPT_ADD_FOOD, "- Enter the name of the Food to add:",
        MsgTag.PROMPT_REMOVE_FOOD, "- Enter the name of the Food to remove:",
        MsgTag.MESSAGE_CHECKOUT, "Thank you for ordering from us !",
        MsgTag.MESSAGE_CANCEL_ORDER, "The order has been canceled",
        MsgTag.MESSAGE_EMPTY_ORDER, "Your Order is Empty",
        MsgTag.MESSAGE_INVALID_CHOICE, "Sorry This Service Doesn't Exist please Try Agian !",
        MsgTag.MESSAGE_TYPE_DONE, "- Type <Done> without <> when you're done !",
        MsgTag.MESSAGE_ELEMENT_NOTFOUND, "---> Element not found please try again",
        MsgTag.MESSAGE_ELEMENT_LISTEXIST, "---> Element already exists in your list",
        MsgTag.MESSAGE_ELEMENT_NOT_LISTEXIST, "---> Element not found in your list"
    );


}
