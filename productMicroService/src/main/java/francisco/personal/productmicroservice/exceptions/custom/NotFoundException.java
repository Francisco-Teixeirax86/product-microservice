package francisco.personal.productmicroservice.exceptions.custom;

import francisco.personal.productmicroservice.utils.Constants;

public class NotFoundException extends BaseException{
    public NotFoundException(String message) {
        super(message, Constants.badRequest);
    }
}
