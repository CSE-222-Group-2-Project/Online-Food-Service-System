import java.util.LinkedList;

import src.*;

public class Driver {

  public static void main(String[] args) {
    Restaurant kebelekCafe = new Restaurant();
    Admin administrator = new Admin(
        kebelekCafe,
        "Fatih Erdogan",
        40,
        "gtu1234",
        "1234");
    
    
    Customer Mehmet_Burak = kebelekCafe.getRandomCustomer();
    //Mehmet_Burak.seeMenu();
    //LinkedList<Food> testFoods = kebelekCafe.createRandomFoods();
    //Order anOrder = new Order(7,Mehmet_Burak,testFoods);
    //Mehmet_Burak.giveOrder(kebelekCafe,anOrder);
    //System.out.println(anOrder.toString());
    //System.out.println("\n\n\n************************************");
    // 20 tane sipariş falan oluşturmak lazım
    //Chef Danilo = kebelekCafe.chooseChef(anOrder);
    //System.out.println(Danilo.toString());
    //System.out.println("\n\n\n************************************");
    //Danilo.prepareOrder();
    //Danilo.prepareOrder();
    //Danilo.prepareOrder();
    Courier Azizcan = null;
    for(int i=0;i<4;i++) {
      LinkedList<Food> testFoods = kebelekCafe.createRandomFoods();
      Order anOrder = new Order(i,Mehmet_Burak,testFoods);
      Order testOrder = Mehmet_Burak.giveOrder(kebelekCafe, anOrder);
      Chef Danilo = kebelekCafe.chooseChef(testOrder);
      if(testOrder!= null)
        Danilo.prepareOrder();

      System.out.println("i: "+i);
      Azizcan = kebelekCafe.chooseCourier(testOrder);
    }
  
    System.out.println(Azizcan.toString());
    //System.out.println(anOrder.toString());
    //System.out.println("\n\n\n************************************");
    //Courier Azizcan = kebelekCafe.chooseCourier(anOrder);
    //System.out.println(Azizcan.toString());
    //System.out.println("\n\n\n************************************");
    //Azizcan.deliverOrderToCustomer(anOrder);
    //Azizcan.deliverOrderToCustomer(order);
    //System.out.println(anOrder.toString());
    System.out.println("\n\n\n************************************");
    //give vote unutma
  }

}
