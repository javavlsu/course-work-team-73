package BoardMeet.Backend.Exception;

public class NotFoundBoardGameException extends  Exception{
    public NotFoundBoardGameException(String errorMessange){
        super(errorMessange);
    }
}
