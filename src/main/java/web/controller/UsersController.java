package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDaoImpl;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserDaoImpl userDaoImpl;
    @Autowired
    public UsersController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }
    @GetMapping
    public String usersList ( Model model ) {
        model.addAttribute( "usersList", userDaoImpl.getUserList());
        return "usersList";
    }

}
