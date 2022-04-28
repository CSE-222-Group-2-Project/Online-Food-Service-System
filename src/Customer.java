public class Customer extends User {
    private String job;
    private String phoneNumber;
    private float balance;
    private int orderNumber;
    private int status; // 1 student(yaşa veya mesleğe göre) 2 vıp(ordernumberına göre) 

    Customer(String _name, int _age, String _job, int _ID, String _password, String _phoneNumber, float _balance) {
        super(_name, _age, _ID, _password);
        job = _job;
        phoneNumber = _phoneNumber;
        balance = _balance;
        orderNumber = 0;
        status = 0;
    }

    Customer() {
        super();
        job = "Teacher";
        phoneNumber = "0555555555";
        balance = 0;
        orderNumber = 0;
        status = 0;
    }

    public String getJob() {
        return job;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public float getBalance() {
        return balance;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String myOrders() {
        return "empty";
    }

    public int giveVote() {
        return 0; // 0-5 aralığı, int[] de return edilebilir 3 kişiye oy verileceğinden
    }

    public void giveOrder() { // return type Order classı herhalde

    }

    public void seeMenu() { // menu classını çağırıp printlettirme,restoran classında da oalbilir
        //restorana geçirmek de mantıklı olabilir
    }
}
