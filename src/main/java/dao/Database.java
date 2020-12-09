package dao;

import encryption.AES;
import entity.User;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

//Dependency Injection is used in testing only.
@Component
public class Database implements UserDAO {

    private final EntityManagerFactory emf;
    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    public Database(){
        emf = Persistence.createEntityManagerFactory("loginForm");
        entityManager = emf.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    //-C. Gets user from parameters and adds it to the database
    public void addUser(User user){

        //Get year of birth based on age
        //user.setAge(Calendar.getInstance().get(Calendar.YEAR)-user.getAge());

        try{
            user.setUserPassword(AES.encrypt(user.getUserPassword()));
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("AN ERROR OCCURRED WHILE ADDING THE USER TO DATABASE");
        }finally{
            System.out.println("STREAMS NOT CLOSED");
            //entityManager.close();
            //emf.close();
        }
    }

    //-R. Returns user by email
    public User getUserByEmail(String email){

        User user = null;

        try{
            transaction.begin();

            String query = "SELECT U FROM User U WHERE U.email = "+"'"+email.trim()+"'";

            TypedQuery<User> typedQuery = entityManager.createQuery(query,User.class);

            user = typedQuery.getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("AN ERROR OCCURRED WHILE RETRIEVING USER FROM DATABASE");
        }

        return user;

    }

    public User getUserByID(int id){
        User user = null;
        try{
           user = entityManager.find(User.class,id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("No such ID for USER");
        }

        return user;
    }

    @Transactional
    public List<User> getAllUsers(){

       try{
           List<User> users;

           TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u ORDER BY u.firstName",User.class);

           return users = typedQuery.getResultList();

       }catch (Exception e){
           e.printStackTrace();
           System.out.println("Error while geting ALL USERS");
       }finally {
           entityManager.close();
           emf.close();
       }

        return null;
    }

    //-U. This method is used to update the user
    public void updateUser(User modelUser){

        //This user object is used to copy the changed values from modelUser (in the parameters)
        User user = new User();

        try{

            //Here we use the find method to get a specific user from the database using its id
            user = entityManager.find(User.class, modelUser.getId());

            /*
            * Check if fields from modelUser have values that are not null.
            * If a field has not been changed then it won't be update, only the fields that
            * have been changed will be written to the database.
            * */
            if(modelUser.getFirstName() != null) user.setFirstName(modelUser.getFirstName());
            if(modelUser.getLastName() != null) user.setLastName(modelUser.getLastName());
            if(modelUser.getCountry()!=null) user.setCountry(modelUser.getCountry());
            if(modelUser.getLanguages()!=null) user.setLanguages(modelUser.getLanguages());
            if(modelUser.getEmail()!=null) user.setEmail(modelUser.getEmail());
            if(modelUser.getAge()!=0) user.setAge(modelUser.getAge());
            if(Character.isLetter(modelUser.getGender())) user.setGender(modelUser.getGender());


            //Add user to the database
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();

        }catch (Exception e){
            System.out.println("ERROR WHILE UPDATING THE USER");
            e.printStackTrace();
        }
    }

    //-D. DELETE USER
    public void deleteUser(User modelUser){

        User user = new User();

        try{
            user = entityManager.find(User.class,modelUser.getId());
            transaction.begin();
            entityManager.remove(user);
            transaction.commit();
        }catch (Exception e){
            System.out.println("ERROR WHILE DELETING USER");

            e.printStackTrace();
        }finally {
            //emf.close();
            //entityManager.close();
            System.out.println("SOURCES NOT CLOSED IN \"DELETE USER\"");
        }

    }

    public void deleteUserById(int id){
        try{
            User user = entityManager.find(User.class, id);
            transaction.begin();
            entityManager.remove(user);
            transaction.commit();
        }catch (Exception e){
            System.out.println("ERROR WHILE DELETING USER (BY ID)");

            e.printStackTrace();
        }finally {
            //closeStreams();
        }
    }

    public void verify(int id){

        User user;

        try{
            user = entityManager.find(User.class, id);
            user.setVerified(true);
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR WHILE SETTING 'VERIFIED  = TRUE'");
        }

    }

    /*I use this way of closing streams only in one case where I need to invoke database.methods multiple time.
    * in this case (UPDATE)
    * Closing the streams inside the method or in the finally{cose} statement prevends us from reusing any CRUD
    * operating using that object.
    * */
    public void closeStreams(){
        emf.close();
        entityManager.close();
    }

}