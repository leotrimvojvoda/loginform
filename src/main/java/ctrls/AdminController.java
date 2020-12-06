package ctrls;

import dao.Database;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.util.List;

@RequestMapping("admin")
@Controller
public class AdminController {

    @RequestMapping("adminPage")
    public String adminMode(Model model){

        Database db = new Database();

        List<User> users = db.getAllUsers();

        model.addAttribute("users",users);

        return "admin";
    }

    @RequestMapping("initUpdate")
    public String initUpdate(@RequestParam("userId") int id, Model model){

        Database database = new Database();

        model.addAttribute("newUser", database.getUserByID(id));

        return "update";
    }

    @RequestMapping("update")
    public String update(@ModelAttribute("newUser") User user, Model model){

        Database database = new Database();

        database.updateUser(user);

        List<User> users = database.getAllUsers();

        model.addAttribute("users",users);


        return "admin";
    }

    @RequestMapping("deleteUser")
    public String deleteFromAdmin(@RequestParam("userId") int id, Model model){

        Database db = new Database();

        db.deleteUserById(id);

        List<User> users = db.getAllUsers();

        model.addAttribute("users",users);

        return "admin";

    }

}
