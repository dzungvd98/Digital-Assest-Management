package main;

import java.security.Permissions;
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

    public void grantDrivePermission(String driveName, String username, Permission permission) {
        Drive drive = drives.get(driveName);
        User user = users.get(username);
        if(drive != null && user != null) {
            drive.grantPermission(user, permission);
        } else {
            System.out.println("Drive or user not found!");
        }
    }

    public void grantFolderPermission(String driveName, String folderName, String username, Permission permission) {
        Drive drive = drives.get(driveName);
        User user = users.get(username);
        if(drive != null && user != null) {
            for(Folder folder : drive.getRootFolders()) {
                if(folder.getName().equals(folderName)) {
                    folder.grantPermission(user, permission);
                    return;
                }
            }
            System.out.println("Folder not found!");
        }
    }

    public void checkPermissionAndAct(String driveName, String folderName, String username, String action) {
        Drive drive = drives.get(driveName);
        User user = users.get(username);
        if(drive != null && user != null) {
            for(Folder folder : drive.getRootFolders()) {
                if(folder.getName().equals(folderName)) {
                    Set<Permission> permission = folder.getPermissions(user);
                    if(permission.isEmpty()) {
                        System.out.println("No permissions");
                        return;
                    }

                    if (action.equals("add") && (permission.contains(Permission.ADMIN) || permission.contains(Permission.CONTRIBUTOR))) {
                        System.out.println("Action allowed!");
                    } else if (action.equals("view") && (permission.contains(Permission.READER) || permission.contains(Permission.ADMIN) || permission.contains(Permission.CONTRIBUTOR))) {
                        System.out.println("View allowed!");
                    } else {
                        System.out.println("Action not allowed!");
                    }
                    return;
                }
            }
            System.out.println("Folder not found!");
        }
    }

    

}
