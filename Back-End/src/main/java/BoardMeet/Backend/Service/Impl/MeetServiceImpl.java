package BoardMeet.Backend.Service.Impl;

import BoardMeet.Backend.Model.Meet;
import BoardMeet.Backend.Service.MeetService;
import BoardMeet.Backend.dto.MeetChangeDTO;
import BoardMeet.Backend.dto.MeetCreateDTO;

import java.util.List;

public class MeetServiceImpl implements MeetService {
    @Override
    public List<Meet> getAll() {
        return null;
    }

    @Override
    public Meet get(Long Id) {
        return null;
    }

    @Override
    public Meet create(MeetCreateDTO meet) {
        return null;
    }

    @Override
    public Meet change(MeetChangeDTO meet) {
        return null;
    }

    @Override
    public boolean delete(Long Id) {
        return false;
    }

    @Override
    public boolean exit(Long meetId, Long userId) {
        return false;
    }

    @Override
    public boolean lock(Long Id) {
        return false;
    }

    @Override
    public boolean open(Long Id) {
        return false;
    }

    @Override
    public List<Meet> search(String searchVal) {
        return null;
    }
}
