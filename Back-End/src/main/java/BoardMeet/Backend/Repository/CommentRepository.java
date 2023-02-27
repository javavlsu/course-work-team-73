package BoardMeet.Backend.Repository;

import BoardMeet.Backend.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
