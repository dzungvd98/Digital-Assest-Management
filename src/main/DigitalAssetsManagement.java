package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DigitalAssetsManagement {
    Set<User> users;
    Set<Drive> drives;
    Set<Folder> folders;
    Set<File> files;
    List<Permission> permissions;

    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
    public Set<Drive> getDrives() {
        return drives;
    }
    public void setDrives(Set<Drive> drives) {
        this.drives = drives;
    }
    public Set<Folder> getFolders() {
        return folders;
    }
    public void setFolders(Set<Folder> folders) {
        this.folders = folders;
    }
    public Set<File> getFiles() {
        return files;
    }
    public void setFiles(Set<File> files) {
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


    public void grandPermission(User userGrand, User userGetPermission, Drive drive, PermissionEnum permissionEnum) {
        Permission permiss = this.findPermissionByDrive(this.permissions, userGetPermission, drive);
        if(permiss != null) {
            Boolean isUserHadThisPermission = permiss.isUserHadThisPermission(permissionEnum);
            if(!isUserHadThisPermission) {
                List<PermissionEnum> listPermissEnum = permiss.getPermissions(); 
                listPermissEnum.add(permissionEnum);
                permiss.setPermissions(listPermissEnum);
            }
        }
        else {
            // Tạo một quyền mới
            Permission newPermission = new Permission();
            newPermission.setDrive(drive);
            newPermission.setUser(userGetPermission);

            // Thêm quyền mới vào danh sách quyền
            List<PermissionEnum> newPermissionsList = new ArrayList<>();
            newPermissionsList.add(permissionEnum);
            newPermission.setPermissions(newPermissionsList);

            // Thêm quyền mới vào danh sách quản lý quyền
            this.permissions.add(newPermission);
        }
        
        
    }

}
