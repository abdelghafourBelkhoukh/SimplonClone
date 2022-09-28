package SimplonClone;

public class Person {

    private int id;
    private int promoId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

    public Person(int id, int promoId, String firstName, String lastName, String email, String password, Role role) {

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

    public void setRole(Role role) {
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

    public Role getRole() {
        return role;
    }
}







//    @Override
//    public String toString() {
//        return "Person{" +
//                "username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }

