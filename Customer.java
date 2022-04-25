public class Customer extends User {
    private String job;

    Customer(String _name, int _age, String _job) {
        super(_name, _age);
        job = _job;
    }

    Customer() {
        super();
        job = "Teacher";
    }

    public String getJob() {
        return job;
    }

    public void myOrders() {

    }

    public void giveVote() {

    }

    public void giveOrder() {

    }

    public void seeMenu() {

    }
}
