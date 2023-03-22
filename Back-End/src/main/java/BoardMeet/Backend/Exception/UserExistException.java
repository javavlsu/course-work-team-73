package BoardMeet.Backend.Exception;

public class UserExistException extends Exception{
    public UserExistException(String username){super("User by username : " + username + " existS");}
}
