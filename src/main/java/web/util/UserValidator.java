package web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import web.model.User;
import web.service.UserServices;

@Component
public class UserValidator implements Validator {

    private final UserServices userServices;
    @Autowired
    public UserValidator(UserServices userServices) {
        this.userServices = userServices;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target; //даункастим к Юзеру
        System.out.println( userServices.showByEMail( user.getEMail() ) );
        if (userServices.showByEMail(user.getEMail()).isPresent()) {
            errors.rejectValue( "eMail", "", "e-mail уже используется");
       }
    }
}
