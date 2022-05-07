package src;

import java.util.LinkedList;

public class Menu {

  static LinkedList<Food> menu = new LinkedList<Food>();
  int id;

  public Menu() { // Default Menu
    menu = Authentication.getMenuFromDatabase();
  }

  public Menu(LinkedList<Food> menu) {
    this.f = menu;
  }

  LinkedList<Food> get_foods() {
    return f;
  } // linked list array ? Her yemek çeşiti için ayrı link list ?

  // parametre food olabilir mi?*/
  /*  void insert_food(String name, double price,String type) {
    Food temp = new Food(id, name, price,type);
    f.add(temp);
    id++;
  }



  void delete_food(int id) {
    f.remove(id);
    for (int i = id + 1; i < f.size(); i++) {
      f.get(i).setID(i - 1);
    }
    id--;
  }
*/
  public static void seeMenu() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Food food : f) {
      stringBuilder.append(food + "\n");
    }
    System.out.print(stringBuilder);
  }
}
