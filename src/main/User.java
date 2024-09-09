package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class User {

    private String username;
    private Map<Drive, Set<Permission>> drivePermissions;

    public User(String username) {
        this.username = username;
        this.drivePermissions = new HashMap<>();
    }

    public String getUserName() {
        return username;
    }

    public void grantPermission(String userName, String driveName, Permission permission) {
        if(hasPermission(driveName, Permission.ADMIN)) {
            Drive drive = Drive.findDriveByName(driveName, drivePermissions.keySet());
            User user = findUserByUserName(userName, drive.getUserPermission().keySet());
            
        } else {
            System.out.println("You don't have permission to do this!");
        }
    }

    public Set<Permission> getPermissions(Drive drive) {
        return drivePermissions.getOrDefault(drive, new HashSet<>());
    }

    public boolean hasPermission(String driveName, Permission permission) {
        for(Drive drive : drivePermissions.keySet()) {
            if(drive.getName().equals(driveName)) {
                return drivePermissions.get(drive).contains(permission);
            }
        }

        return false;
    }

    public void createDrive(String driveName) {
        boolean driveExists = drivePermissions.keySet()
                .stream()
                .anyMatch(existingDrive -> existingDrive.getName().equals(driveName));
        if (driveExists) {
            System.out.println("Drive already exists.");
        } else {
            // Tạo Drive mới với tên truyền vào
            Drive newDrive = new Drive(driveName, this);
            Set<Permission> permission = new HashSet<>();
            permission.add(Permission.ADMIN);
            drivePermissions.put(newDrive, permission);
            System.out.println("Drive created successfully.");
        }
    }

    

    public Map<Drive, Set<Permission>> getDrivePermissions() {
        return drivePermissions;
    }


    public void createFolderInDrive(String driveName, String folderName) {
        Drive drive = Drive.findDriveByName(driveName, drivePermissions.keySet());
        if(drive != null) {
            
        } else {
            System.out.println("Drive not found!");
        }
    }

    public void createFile(String driveName, String folderName, String fileName) {

    }

    public static User findUserByUserName(String userName, Set<User> users) {
        for(User user : users) {
            if(user.getUserName().equals(userName)) {
                return user;
            }
        }

        return null;
    }
    
}
