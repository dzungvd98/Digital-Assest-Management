package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DigitalAssetsManagement {
    private Map<String, User> users;
    private Map<String, Drive> drives;
    
    public DigitalAssetsManagement() {
        this.users = new HashMap<>();
        this.drives = new HashMap<>();
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void addUser(String username) {
        users.put(username, new User(username));
    }

    public void createDrive(String driveName, String ownerUserName) {
        User owner = users.get(ownerUserName);
        if(owner != null) {
            Drive drive = new Drive(driveName, owner);
            drives.put(driveName, drive);
            owner.grantPermission(drive, Permission.ADMIN);
        }
    }

    

}
