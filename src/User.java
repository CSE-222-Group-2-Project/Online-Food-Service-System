public class User implements Comparable<User> {
    private String name;
    private int age;
    private int ID;
    private String password;

    User(String _name, int _age,int _ID,String _password) {
        name = _name;
        age = _age;
        ID = _ID;
        password = _password;
    }

    User() {
        name = "Mustafa";
        age = 24;
        ID = 1234;
        password = "1234";
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public void changeID(int _ID){
        ID = _ID;
    }

    public void changePassword(String _password){
        password = _password;
    }
    
    public boolean login(){
        return false;
    }

    public void logout(){ //??

    }

    public int compareTo(User other){
        return -1;
    }

}
