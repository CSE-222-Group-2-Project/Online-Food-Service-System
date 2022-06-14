package src.util;

import java.util.ArrayList;
import src.restaurant.Food;
import src.user.Admin;
import src.user.Chef;
import src.user.Courier;
import src.user.Customer;
import src.user.User;

class LineParsers {

  /**
   * It takes a line of text from the food.txt file, splits it into tokens, and then creates a Food
   * object with the tokens
   *
   * @param lineText The line of text that we're parsing.
   * @return A Food object
   */
  static Food parseFoodLine(String lineText) {
    String[] tokens = lineText.split(" ");
    StringBuilder foodName = new StringBuilder();
    Food food = new Food();

    food.setFoodID(Integer.parseInt(tokens[0]));

    if(tokens.length > 4){
      foodName.append(tokens[1]);
      foodName.append(" ");
      foodName.append(tokens[2]);
    }else{
      foodName.append(tokens[1]);
    }
    food.setFoodName(foodName.toString().trim());
    food.setFoodPrice(Integer.parseInt(tokens[tokens.length - 2]));
    food.setFoodType(tokens[tokens.length - 1]);

    return food;
  }

  /**
   * It takes a line of text, splits it into tokens, and then uses the first token to determine which
   * type of user to create
   *
   * @param lineText The line of text that we're parsing.
   * @return A User object.
   */
  static User parseUserLine(String lineText) {
    String[] tokens = lineText.split(" ");
    String userType = tokens[0];

    if (userType.equals("admin")) {
      return new Admin(
        null,
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4]
      );
    } else if (userType.equals("chef")) {
      return new Chef(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4],
        Integer.parseInt(tokens[5]),
        Integer.parseInt(tokens[6])
      );
    } else if (userType.equals("courier")) {
      return new Courier(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4],
        tokens[5],
        Integer.parseInt(tokens[6])
      );
    } else if (userType.equals("customer")) {
      ArrayList<String> allergies = new ArrayList<>();
      if (tokens.length > 8) {
        allergies.add(tokens[8]);
      }
      return new Customer(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4],
        tokens[5],
        tokens[6],
        Double.parseDouble(tokens[7]),
        allergies
      );
    } else {
      return null;
    }
  }
}
