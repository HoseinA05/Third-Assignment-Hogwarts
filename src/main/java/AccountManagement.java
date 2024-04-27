public interface AccountManagement {
    public static boolean isValidPassword(String enteredPassword){
        //  TODO (Future): Make Harder rules.
        if(enteredPassword.length() < 6) return false;
        return true;
    }
    public void changeUsername(String newUsername);
    public void changePassword(String newPassword);
    public String getUsername();

    public boolean isPasswordCorrect(String password);
}
