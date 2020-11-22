package ctrls;

import database.Database;
import encryption.AES;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserController {

    private User generalUser = null;

    //Fires when clicked "LOGIN" in INDEX
    //Use the users email to get the specific newUser from the database
    //TODO: RETURN MESSAGE IF USER DOES NOT EXIST - DECRYPT PASSWORD AND COMPARE THE PASSWORDS - ADD RESET PASSWORD
    @RequestMapping("login")
    public String login(HttpServletRequest request, User user, Model model){

        //Create database object in order to use it's crud methods
        Database database = new Database();

        String password = null;

        try{
            //In the login page the user is asked to enter the email, which is used to find the user in the database.
            user = database.getUserByEmail(request.getParameter("email"));

            //Get password from webpage
            password = request.getParameter("psswd");

            //I initialize this user object to be able to use in this session.
            generalUser = user;

            //Add the user object to the model
            model.addAttribute("dbUser",user);
        }catch (Exception e){

            System.out.println("AN ERROR OCCURRED");
            e.printStackTrace();
        }

        //If we get a user that opens the user interface with all the available user data
        if(user != null && AES.decrypt(user.getUserPassword()).equals(password)) return "userInterface";

        //If that user does not exist in the database then the user will be redirected in this page (for now)
        else return "index";
    }

    //Fires when clicked "CREATE ACCOUNT" in INDEX
    //Add new USER object  to the model and open the registration page
    @RequestMapping("createAccount")
    public String register(Model model){

        /*Creates a user object pass it via the model to the registration form
        * so that it can be initialized with valida data
        * */
        model.addAttribute("newUser",new User());

        //Return the JSP page name
        return "register";
    }

    /*Fires when clicked "ADD USER" in Register Page
    * Add all data to the newUser object and add the newUser to the database
    * TODO: ENCRYPT THE PASSWORD BEFORE PERSISTING THE USER TO THE DATABASE
    * */
    @RequestMapping("signUp")
    public String signUp(@Valid @ModelAttribute("newUser") User user,
                         BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()) return "register";

        else{
            Database database = new Database();

            database.addUser(user);

            generalUser = user;

            model.addAttribute("dbUser",user);

            return "userInterface";
        }
    }

    //Fires when clicked "EDIT PROFILE" in User Interface
    @RequestMapping("editPage")
    public String editPage(User user, Model model){

        user = generalUser;

       model.addAttribute("editUser",user);

     return "editProfile";
    }

    //Fires when clicked "UPDATE INFO" in Edit Profile
    /**
     *A user object will be sent via Model(editUser) that will contain all the available
     * changes to the user; the problem is that the ID can not be copied so we make use of
     * the generalUser object to add the id to the user object that is passed by the model.
     * */
    @RequestMapping("updateUser")
    public String updateUser(@ModelAttribute("editUser") User user, Model model){

        user.setId(generalUser.getId());

        Database database = new Database();

        database.updateUser(user);

        user = database.getUserByEmail(user.getEmail());

        model.addAttribute("dbUser",user);

        database.closeStreams();

        return "userInterface";

    }

    //DeleteUser
    @RequestMapping("deleteUser")
    public String deleteUser(){

        Database database = new Database();

        database.deleteUser(generalUser);

        return "index";
    }

    @RequestMapping("adminPage")
    public String adminMode(){
        return "admin";
    }

}