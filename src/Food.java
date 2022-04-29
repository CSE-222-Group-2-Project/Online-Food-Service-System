package src;

public class Food {

  private int foodID;
  private String food_name;
  private double food_price;

  Food(int id, String name, double price) {
    foodID = id;
    food_name = name;
    food_price = price;
  }

  void setID(int id) {
    foodID = id;
  }

  void set_food_price(double price) {
    food_price = price;
  }

  int get_foodID() {
    return foodID;
  }

  double get_food_price() {
    return food_price;
  }
}
