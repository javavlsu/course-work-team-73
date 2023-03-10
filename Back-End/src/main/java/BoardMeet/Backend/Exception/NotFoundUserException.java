package BoardMeet.Backend.Exception;

public class NotFoundUserException extends  Exception{
    public NotFoundUserException (String errorMessange){
        super(errorMessange);
    }
}
