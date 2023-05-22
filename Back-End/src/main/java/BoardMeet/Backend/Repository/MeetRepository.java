package BoardMeet.Backend.Repository;

import BoardMeet.Backend.Model.Meet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MeetRepository extends JpaRepository<Meet,Long> {

    List<Meet> findByCityContains(String filter);
    @Query(value = "SELECT m FROM Meet m WHERE m.state = 'RECRUITING' OR m.state = 'STARTOPEN'")
    Page<Meet> findAllOpen(Pageable page);
}
