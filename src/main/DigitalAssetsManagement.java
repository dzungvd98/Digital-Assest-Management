package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DigitalAssetsManagement {
    private Map<String, User> users;
    private Map<String, Drive> drives;
    private Map<String, Folder> folders;

    public DigitalAssetsManagement() {
        this.users = new HashMap<>();
        this.drives = new HashMap<>();
    }

    public void addUser(String username) {
        users.put(username, new User(username));
    }

    public void createDrive(String driveName, String ownerUsername) {
        User owner = users.get(ownerUsername);
        if (owner != null) {
            Drive drive = new Drive(driveName, owner);
            drives.put(driveName, drive);
        } else {
            System.out.println("Owner user not found!");
        }
    }

    public void createFolder(String userName, String driveName, String folderName) {
        Drive drive = drives.get(driveName);
        if (drive != null) {
            Folder folder = new Folder(folderName);
            drive.addRootFolder(folder);
        } else {
            System.out.println("Drive not found!");
        }
    }

    public void createFile(String driveName, String folderName, String fileName) {
        
    }

    public void grantDrivePermission(String driveName, String username, Permission permission) {
        Drive drive = drives.get(driveName);
        User user = users.get(username);
        if (drive != null && user != null) {
            drive.grantPermission(user, permission);
        } else {
            System.out.println("Drive or user not found!");
        }
    }

    public void grantFolderPermission(String driveName, String folderName, String username, Permission permission) {
        Drive drive = drives.get(driveName);
        User user = users.get(username);
        if (drive != null && user != null) {
            for (Folder folder : drive.getRootFolders()) {
                if (folder.getName().equals(folderName)) {
                    folder.grantPermission(user, permission);
                    return;
                }
            }
            System.out.println("Folder not found!");
        } else {
            System.out.println("Drive or user not found!");
        }
    }

    public void checkPermissionAndAct(String driveName, String folderName, String username, String action) {
        Drive drive = drives.get(driveName);
        User user = users.get(username);
        if (drive != null && user != null) {
            Folder targetFolder = null;
            for (Folder folder : drive.getRootFolders()) {
                if (folder.getName().equals(folderName)) {
                    targetFolder = folder;
                    break;
                }
            }

            if (targetFolder == null) {
                System.out.println("Folder not found!");
                return;
            }

            Set<Permission> permissions = targetFolder.getPermissions(user);
            if (permissions.isEmpty()) {
                System.out.println("No permissions!");
                return;
            }

            switch (action.toLowerCase()) {
                case "add":
                case "modify":
                case "delete":
                    if (permissions.contains(Permission.ADMIN) || permissions.contains(Permission.CONTRIBUTOR)) {
                        System.out.println("Action allowed!");
                    } else {
                        System.out.println("Action not allowed!");
                    }
                    break;
                case "view":
                    if (permissions.contains(Permission.READER) || permissions.contains(Permission.ADMIN) || permissions.contains(Permission.CONTRIBUTOR)) {
                        System.out.println("View allowed!");
                    } else {
                        System.out.println("Action not allowed!");
                    }
                    break;
                default:
                    System.out.println("Unknown action!");
            }
        } else {
            System.out.println("Drive or user not found!");
        }
    }
}
