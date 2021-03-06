package ctrls;

import dao.Database;
import encryption.AES;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import verification.EmailUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.concurrent.ThreadLocalRandom;


@Controller
public class UserController {

    private User sessionUser = null;

    int code = 0;


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
            sessionUser = user;

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

            sessionUser = user;

            model.addAttribute("dbUser",user);

            return "userInterface";
        }
    }


    //Fires when clicked "EDIT PROFILE" in User Interface
    @RequestMapping("editPage")
    public String editPage(@ModelAttribute("dbUser") User user, Model model){

        user = sessionUser;

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

        user.setId(sessionUser.getId());

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

        database.deleteUser(sessionUser);

        return "index";
    }


    @RequestMapping("enterCode")
    public String enterCode(@ModelAttribute("dbUser") User user, Model model){

        model.addAttribute("verifyUser", sessionUser);

        code = ThreadLocalRandom.current().nextInt(100000, 900000 + 1);

        EmailUtil.sendEmail(sessionUser.getEmail(), String.valueOf(code));

        System.out.println("CODE: "+code+" ATTEMPTED TO BE SENT TO : "+ sessionUser.getEmail());

        return "verification-form";
    }


    @RequestMapping("checkVerification")
    public String checkVerification(HttpServletRequest request, @ModelAttribute("dbUser") User user, Model model){


        String code = request.getParameter("verificationCode").trim();

        Database database = new Database();

        sessionUser = database.getUserByID(sessionUser.getId());

        if (String.valueOf(this.code).equals(code)){

            database.verify(sessionUser.getId());

            model.addAttribute("dbUser", sessionUser);

            System.out.println("Verification successful ["+this.code+" = "+code+"]");

        }
        else{
            System.out.println("Verification failed ["+this.code+" ≠ "+code+"]");
        }



        return "userInterface";
    }


    @RequestMapping("updateFromAdmin")
    public String updateUser(@RequestParam("userId") int id, Model model){

        Database database = new Database();

        sessionUser = database.getUserByID(id);

        model.addAttribute("editUser", sessionUser);

        return "editProfile";
    }





}