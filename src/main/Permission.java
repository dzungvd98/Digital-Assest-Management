package main;

import java.util.List;

public class Permission {
    private String id;
    private String driveName;
    private String userName;
    List<PermissionEnum> permissions;
    private String parentFolderName;
    private String folderName;
    private File file;

    
    public Permission() {
    }


    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public String getDriveName() {
        return driveName;
    }


    public void setDriveName(String driveName) {
        this.driveName = driveName;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public List<PermissionEnum> getPermissions() {
        return permissions;
    }


    public void setPermissions(List<PermissionEnum> permissions) {
        this.permissions = permissions;
    }


    public String getParentFolderName() {
        return parentFolderName;
    }


    public void setParentFolderName(String parentFolderName) {
        this.parentFolderName = parentFolderName;
    }


    public String getFolderName() {
        return folderName;
    }


    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }


    public File getFile() {
        return file;
    }



    public void setFile(File file) {
        this.file = file;
    }


    public void GrandDrivePermission(String userId, String driveId, PermissionEnum permission) {
        
    }



}
