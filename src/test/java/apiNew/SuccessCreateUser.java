package apiNew;

public class SuccessCreateUser {
    public Integer code;
    public String type;
    public String message;

    public SuccessCreateUser(Integer code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
