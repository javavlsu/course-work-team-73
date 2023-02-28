package BoardMeet.Backend.dto;

import BoardMeet.Backend.Model.User;

import java.sql.Date;
import java.util.List;

public class MeetChangeDTO {
    public String Name;
    public int PeopleCountMax;
    public int Duration;
    public String Link;
    public java.sql.Date Date;
    public String Location;
    public String City;
    public String Games;
    public List<User> Players;
}
