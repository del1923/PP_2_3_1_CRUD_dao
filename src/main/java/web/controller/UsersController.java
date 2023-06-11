package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;
import javax.validation.Valid;

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
        return "users/usersList";
    }
    @GetMapping("/newUser")
    public String newUser(@ModelAttribute("user") User user ) {
        return "users/newUser";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult ) {
        if ( bindingResult.hasErrors() ) {
            return "/users/newUser";
        }
        userDaoImpl.addUser( user );
        return "redirect:users";
    }

    @GetMapping("/{id}/editUser")
    public String editUser( Model model, @PathVariable ("id") int id ) {
        model.addAttribute( "user",userDaoImpl.show(id));
        return "users/editUser";
    }
    @PatchMapping("/{id}")
    public String updateUser( @ModelAttribute( "user" ) @Valid User user, BindingResult bindingResult, @PathVariable("id") int id ) {
        if ( bindingResult.hasErrors() ) {
            return "/users/editUser";
        }
        userDaoImpl.update( id , user );
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable ("id") int id ) {
        userDaoImpl.delete(id);
        return "redirect:/users";
    }

}
