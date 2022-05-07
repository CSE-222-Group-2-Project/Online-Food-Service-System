package src;

import java.util.LinkedList;

public class Menu {

  private static LinkedList<Food> menu = new LinkedList<Food>();
  int id;

  public Menu() {
    menu = Authentication.getMenuFromDatabase();
  }

  public Menu(LinkedList<Food> otherMenu) {
    this.menu = otherMenu;
  }

  LinkedList<Food> get_foods() {
    return menu;
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
    for (Food food : menu) {
      stringBuilder.append(food + "\n");
    }
    System.out.print(stringBuilder);
  }

  @Override
  public String toString() {
    StringBuilder menuInfo = new StringBuilder();
    for (Food food : menu) {
      menuInfo.append(food + "\n");
    }
    return menuInfo.toString();
  }
}
