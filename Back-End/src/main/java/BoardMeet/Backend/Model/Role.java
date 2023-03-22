package BoardMeet.Backend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Column(name = "name")
    private String name;

    @ManyToMany
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id: " + super.getClass() + ", " +
                "name: " + name + "}";
    }
}
