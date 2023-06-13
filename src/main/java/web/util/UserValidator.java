package web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import web.dao.UserDaoImpl;
import web.model.User;

@Component
public class UserValidator implements Validator {

    private final UserDaoImpl userDaoImpl;
    @Autowired
    public UserValidator(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target; //даункастим к Юзеру

    }
}
