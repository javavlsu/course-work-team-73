package BoardMeet.Backend.Repository;

import BoardMeet.Backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);
    boolean existsByUsername(String name);

}
