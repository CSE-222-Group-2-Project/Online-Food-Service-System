public class User {
    private String name;
    private int age;

    User(String _name, int _age) {
        name = _name;
        age = _age;
    }

    User() {
        name = "Mustafa";
        age = 24;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }
    
    public void login(){

    }

}
