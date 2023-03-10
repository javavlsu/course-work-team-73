package BoardMeet.Backend.Repository;

import BoardMeet.Backend.Model.Meet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MeetRepository extends JpaRepository<Meet,Long> {
    List<Meet> findByNameContains(String filter);
}
