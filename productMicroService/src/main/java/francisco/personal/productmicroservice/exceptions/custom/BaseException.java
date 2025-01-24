package francisco.personal.productmicroservice.exceptions.custom;

public abstract class BaseException extends RuntimeException{
    private final String message;
    private final int code;

    public BaseException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }


    public int getCode() {
        return code;
    }
}
