package SimplonClone.Models.User;

import SimplonClone.Models.RoleModel;

public class PersonModel {

    private int id;
    private int promoId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private RoleModel role;
    
    public PersonModel(int id, int promoId, String firstName, String lastName, String email, String password, RoleModel role) {

        this.id = id;
        this.promoId = promoId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;


    }

    public boolean verifyPassword(String password) {

        return this.password.equals(password);
    }

    // setter


    public void setId(int id) {
        this.id = id;
    }

    public boolean setPromoId(int promoId) {
        this.promoId = promoId;
        return true;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    //getter


    public int getId() {
        return id;
    }

    public int getPromoId() {
        return promoId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public RoleModel getRole() {
        return role;
    }
//    public void test(){
//        String s = "abddba";
//        String sReverse = "";
//        int j = 0;
//        for (int i = s.length()-1 ; i >= 0 ; i--, j++){
//            sReverse += s.charAt(i);
//        }
//
//        System.out.println(s.equals(sReverse));
//
//    }
}









//    @Override
//    public String toString() {
//        return "Person{" +
//                "username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }

