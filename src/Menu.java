package src;

import java.util.LinkedList;

public class Menu {

  LinkedList<Food> f = new LinkedList<Food>();
  int id;

  LinkedList<Food> get_foods() {
    return f;
  }

  void insert_food(String name, double price) {
    Food temp = new Food(id, name, price);
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
}
