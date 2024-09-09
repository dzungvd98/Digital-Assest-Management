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


    public Set<Permission> getPermissions(Drive drive) {
        return drivePermissions.getOrDefault(drive, new HashSet<>());
    }

    public boolean hasDrivePermission(String driveName, Permission permission) {
        for (Drive drive : drivePermissions.keySet()) {
            if (drive.getName().equals(driveName)) {
                return drivePermissions.get(drive).contains(permission);
            }
        }

        return false;
    }

    public boolean hasFolderPermission(String driveName, String folderName, Permission permission) {
        Drive driveFound = Drive.findDriveByName(driveName, drivePermissions.keySet());
        if(driveFound != null) {
            Folder folder = Folder.findFolderInDriveByFolderName(folderName, driveFound);
            if(folder != null && folder.getUserPermissions().get(this).contains(permission)) {
                return true;
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

        // Ensure the Drive exists
        if (drive != null) {
            // Check if the folder already exists in the drive
            Folder folder = Folder.findFolderInListByFolderName(folderName, drive.getRootFolders());
            if (folder == null) {
                // Folder does not exist, so create a new one
                folder = new Folder(folderName);
                Set<Permission> drivePermiss = getPermissions(drive);
                // Set permission of folder like drive of it
                Map<User, Set<Permission>> userFolderPermission = new HashMap<>();
                userFolderPermission.put(this, drivePermiss);
                folder.setUserPermissions(userFolderPermission);
                
                drive.addRootFolder(folder);
                System.out.println("Folder created successfully in drive: " + driveName);
            } else {
                System.out.println("Folder with the name '" + folderName + "' already exists in drive: " + driveName);
            }
        } else {
            System.out.println("Drive with the name '" + driveName + "' does not exist.");
        }
    }

    public void createFile(String driveName, String folderName, String fileName) {

    }

    public static User findUserByUserName(String userName, Set<User> users) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }

        return null;
    }

}
