import java.util.UUID;

public class Account implements AccountManagement{
    private String username;
    // TODO: Passwords should hashed
    private String password;
    private UUID accountID;

    @Override
    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public String getUsername(){
        return this.username;
    }

    @Override
    public boolean isPasswordCorrect(String password){
        return this.password.equals(password);
    }
}
