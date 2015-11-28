import java.util.HashMap;

/**
 * Created by Dmytro.Palets on 14.11.2015.
 */
public class User {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private HashMap<String, String> userCredentials;

       boolean isSet;

    public User(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        userCredentials = new HashMap<>();
    }

    public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getLogin() {
                return login;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public HashMap<String, String> getUserCredentials() {
                return userCredentials;
            }



    public void saveUserCredentials (){

        if (firstName != null &&
                lastName != null &&
                login!= null &&
                password != null) isSet = true;

        else isSet = false;

        if(isSet)
        {userCredentials.put("FirstName", firstName);
            userCredentials.put("LastName", lastName);
            userCredentials.put("login", login);
            userCredentials.put("password", password);}
    }


    }
