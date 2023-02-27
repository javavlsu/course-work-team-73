package BoardMeet.Backend.Repository;

import BoardMeet.Backend.Model.Meet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetRepository extends JpaRepository<Meet,Long> {
}
