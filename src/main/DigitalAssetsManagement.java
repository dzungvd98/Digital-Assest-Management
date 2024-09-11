package main;

import java.util.HashMap;
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

    public Map<String, Drive> getDrives() {
        return drives;
    }



    public void addUser(String username) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username));
        }
    }



    public void createDrive(String driveName, String ownerUsername) {
        User owner = users.get(ownerUsername);
        if (owner != null) {
            boolean driveExist = drives.containsKey(driveName);
            if (!driveExist) {
                Drive newDrive = new Drive(driveName, owner);
                owner.setUpCreateDrive(newDrive);
                drives.put(driveName, newDrive);
                addUser(ownerUsername);
            } else {
                System.out.println("Drive already exist!");
            }

        } else {
            System.out.println("Owner user not found!");
        }
    }

    public void createFolderInDrive(String userName, String driveName, String folderName) {
        Drive drive = drives.get(driveName);
        if (drive != null) {
            User user = users.get(userName);
            if (user.hasDrivePermission(driveName, Permission.CONTRIBUTOR)
                    || user.hasDrivePermission(driveName, Permission.ADMIN)) {
                user.createFolderInDrive(drive, folderName);
            } else {
                System.out.println("User has not given permission!");
            }

        } else {
            System.out.println("Drive not found!");
        }
    }

    public void createSubFolderInFolder(String userName, String driveName, String parentFolderName,
            String newFolderName) {
        Drive drive = drives.get(driveName);
        if (drive != null) {
            User user = users.get(userName);
            if (user.hasFolderPermission(drive, parentFolderName, Permission.CONTRIBUTOR)
                    || user.hasFolderPermission(drive, parentFolderName, Permission.ADMIN)) {
                user.createSubFolderInFolder(drive, parentFolderName, newFolderName);
            } else {
                System.out.println("User has not given permission!");
            }

        } else {
            System.out.println("Drive not found!");
        }
    }

    public void createFileInFolder(String userName, String driveName, String folderName, String newFile) {
        Drive drive = drives.get(driveName);
        if (drive != null) {
            User user = users.get(userName);
            if (user.hasFolderPermission(drive, folderName, Permission.CONTRIBUTOR)
                    || user.hasFolderPermission(drive, folderName, Permission.ADMIN)) {
                user.createFileInFolder(drive, folderName, newFile);
            } else {
                System.out.println("User has not given permission!");
            }

        } else {
            System.out.println("Drive not found!");
        }
    }

    public void grantDrivePermission(String userGrantName, String userReceiveName, String driveName, Permission permission) {
        User userGrant = users.get(userGrantName);
        boolean isUserCanGrantPermission = userGrant.hasDrivePermission(driveName, Permission.ADMIN);
        if (isUserCanGrantPermission) {
            Drive drive = drives.get(driveName);
            User userReceive = users.get(userReceiveName);
            if (drive != null && userReceive != null) {
                drive.grantPermission(userReceive, permission);
                userReceive.addPermission(drive, permission);
            } else {
                System.out.println("Drive or user not found!");
            }
        } else {
            System.out.println("User not given permission!");
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
                    if (permissions.contains(Permission.READER) || permissions.contains(Permission.ADMIN)
                            || permissions.contains(Permission.CONTRIBUTOR)) {
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
