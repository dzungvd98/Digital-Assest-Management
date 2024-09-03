package main;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private List<Drive> drives;

    public User() {
        drives = new ArrayList<>();
    }

    

    public User(String userName) {
        this.name = userName;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public List<Drive> getDrives() {
        return drives;
    }



    public void setDrives(List<Drive> drives) {
        this.drives = drives;
    }



    public void addDrive(Drive drive) {
        drives.add(drive);
    }

    public static User findUserByName(List<User> users, String userName) {
        for (User user : users) {
            if(user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }




}
