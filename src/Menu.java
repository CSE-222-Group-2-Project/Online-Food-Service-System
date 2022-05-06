package src;

import java.util.LinkedList;

public class Menu {

  LinkedList<Food> f = new LinkedList<Food>();
   int id; // static olabilir

  public Menu(){ // Default Menu
    // create default menu
  }
  LinkedList<Food> get_foods() {
    return f;
  } // linked list array ? Her yemek çeşiti için ayrı link list ?


  void insert_food(String name, double price,String type) {
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

  @Override
  public String toString(){
    StringBuilder stringBuilder = new StringBuilder();
    /*for (LinkedList<Food> foodByType:
         f) {
      stringBuilder.append(foodByType.get(0).getFood_type());
      for (Food food:
           foodByType) {
        stringBuilder.append(food+"\n");
      }
      stringBuilder.append("\n*****************************"+"\n");
    }*/
    return stringBuilder.toString();

  }
}
