package main;

import java.util.List;

public class DigitalAssetsManagement {
    List<User> users;
    List<Drive> drives;
    List<Folder> folders;
    List<File> files;
    List<Permission> permissions;

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<Drive> getDrives() {
        return drives;
    }
    public void setDrives(List<Drive> drives) {
        this.drives = drives;
    }
    public List<Folder> getFolders() {
        return folders;
    }
    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
    public List<File> getFiles() {
        return files;
    }
    public void setFiles(List<File> files) {
        this.files = files;
    }
    public List<Permission> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Permission findPermissionByDrive(List<Permission> permissions, User user, Drive drive) {
        if(permissions != null) {
            for (Permission permission : permissions) {
                if(permission.getUser().equals(user) && permission.getDrive().equals(drive)) {
                    return permission;
                }
            }
        }
        return null;
    }

    public Boolean isUserHasAdminPermissionAtDrive(User user, Drive drive) {
        Permission permission = findPermissionByDrive(permissions, user, drive);
        if(permission != null && permission.getPermissions() != null) {
            for (PermissionEnum permiss : permission.getPermissions()) {
                if(permiss == PermissionEnum.ADMIN) {
                    return true;
                }
            }
        }
        return false;
    }
    

}
