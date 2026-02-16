package imbutModels;

public class UserModel {
    private String email;
    private String password;

    // Constructor gol (important pentru JSON)
    public UserModel(){
    }

    // Constructor complet
    public UserModel(String email, String password){
        this.email = email;
        this.password = password;
    }

    // Getters & Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
