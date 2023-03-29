package apiNew;

public class DeleteUser {
    private static String message = "User not found";

    public DeleteUser(String message) {
        this.message = message;
    }

    public static String getMessage() {
        return message;
    }
}
