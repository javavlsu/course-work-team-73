package BoardMeet.Backend.Service;

import BoardMeet.Backend.Exception.NoAccessException;

public interface ControllAccessService {
    void tryAccess(Long userId) throws NoAccessException;
    Long getIdUser();

}
