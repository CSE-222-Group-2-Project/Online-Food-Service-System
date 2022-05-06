package src;

public class Food {

  private int foodID;
  private String food_name;
  private double food_price;

  private String food_type;

  /*
  private static String MainCOURSE =" mainCourse";
  private static String DESSERT =" dessert";
  private static String SOUP =" soup";
  private static String BEVERAGE =" beverage";

  private  String footType;*/


  Food(int id, String name, double price,String type) { // type is added for extra
    foodID = id;
    food_name = name;
    food_price = price;
    food_type = type;
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

  public String getFood_type(){
    return food_type;
  }
  public  void setFood_type(String type){
    this.food_type = type;
  }
  public String toString() {
    StringBuilder stb = new StringBuilder();

    stb.append(Integer.toString(foodID)+" "+food_name+" "+Double.toString(get_food_price()));

    return stb.toString();
  }
}
