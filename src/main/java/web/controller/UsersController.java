package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;

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
    public String addUser(@ModelAttribute("user") User user) {
        userDaoImpl.addUser( user );
        return "redirect:users";
    }
//    @GetMapping("/{id}")
//    public String showUser(@PathVariable ("id") int id, Model model) {
//        model.addAttribute( "user",userDaoImpl.show(id));
//        System.out.println("пришли в show");
//        return "users/showUser";
//    }

    @GetMapping("/{id}/editUser")
    public String editUser( Model model, @PathVariable ("id") int id ) {
        model.addAttribute( "user",userDaoImpl.show(id));
        return "users/editUser";
    }
    @PatchMapping("/{id}")
    public String updateUser( @ModelAttribute( "user" ) User user, @PathVariable("id") int id ) {
        userDaoImpl.update( id , user );
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable ("id") int id ) {
        userDaoImpl.delete(id);
        return "redirect:/users";
    }

}
