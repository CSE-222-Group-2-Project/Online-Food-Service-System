package src;

public class Food {

  private int foodID;
  private String foodName;
  private double foodPrice;
  private String foodType;

  /*
  private  String MainCOURSE =" mainCourse";
  private String DESSERT =" dessert";
  private  String SOUP =" soup";
  private  String BEVERAGE =" beverage";

  private  String footType;*/

  Food(int food_id, String food_name, double food_price, String food_type) { // type is added for extra
    foodID = food_id;
    foodName = food_name;
    foodPrice = food_price;
    foodType = food_type;
  }

  public Food() {}

  void setFoodID(int id) {
    foodID = id;
  }

  void setFoodName(String food_name) {
    foodName = food_name;
  }

  void setFoodPrice(double price) {
    foodPrice = price;
  }

  public void setFoodType(String type) {
    foodType = type;
  }

  int getFoodID() {
    return foodID;
  }

  double getFoodPrice() {
    return foodPrice;
  }

  public String getFoodType() {
    return foodType;
  }

  @Override
  public String toString() {
    StringBuilder foodInfo = new StringBuilder();
    foodInfo.append("Food : ");
    foodInfo.append("\nFood ID : " + foodID + "\n");
    foodInfo.append("Food Name : " + foodName + "\n");
    foodInfo.append("Food Price : " + foodPrice + "\n");
    foodInfo.append("Food Type : " + foodType + "\n");
    return foodInfo.toString();
  }
}
