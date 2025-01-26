package francisco.personal.productmicroservice.exceptions.custom;

import francisco.personal.productmicroservice.utils.Constants;

public class BadRequestException extends BaseException{

    public BadRequestException(String message) {
        super(message, Constants.badRequest);
    }
}
