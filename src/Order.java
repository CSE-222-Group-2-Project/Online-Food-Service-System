import java.util.LinkedList;

class Order{
    private int orderID=0;
    private Customer c;
    private double coefficient=1.0;
    private double account =0.0;
     
    private LinkedList<Food> foods_in_menu= new LinkedList<Food>();
    private LinkedList<Integer> foodID = new LinkedList<Integer>();

    Order(LinkedList<Integer> food, int orderID, Customer customer, Menu menu){
        this.orderID = orderID;
        int i=0;
        while(i<food.size()){
            foodID.add(food.get(i));
            i++;
        }
        c=customer;
        foods_in_menu=menu.get_foods();
        
    }

    public Customer get_customer(){return c;}
    public int get_orderID(){return orderID;}

    public void discount_calc(){
        if(c.is_vip()){
            coefficient =0.65;
        }
            
        if(c.getJob() == "Student"){
            coefficient = 0.75;
        }
              
    }

    public double get_account(){
        discount_calc();
        for(int i=0 ; i<foodID.size(); i++){
           for(int j=0; j<foods_in_menu.size(); j++){
               
               if(foodID.get(i) == foods_in_menu.get(j).get_foodID()){
                        account += foods_in_menu.get(j).get_food_price();
               }
           }
        }
        account *= coefficient;
        return account;
    }

    public void order_print(){
        int i=0;
        System.out.println("Order id "+orderID);
        System.out.println("Ordered customer is: "+ c.getJob());
        System.out.println("Ordered foods:");

        while(i<foodID.size()){
            System.out.println(foodID.get(i));
            i++;
        }
    }
    
}