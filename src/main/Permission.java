package main;

import java.util.List;

public class Permission {
    private String id;
    private Drive drive;
    private User user;
    List<PermissionEnum> permissions;
    private Folder parentFolder;
    private Folder folderName;
    private File file;

    
    public Permission() {
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public Drive getDrive() {
        return drive;
    }


    public void setDrive(Drive drive) {
        this.drive = drive;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public List<PermissionEnum> getPermissions() {
        return permissions;
    }


    public void setPermissions(List<PermissionEnum> permissions) {
        this.permissions = permissions;
    }


    public Folder getParentFolder() {
        return parentFolder;
    }


    public void setParentFolder(Folder parentFolder) {
        this.parentFolder = parentFolder;
    }


    public Folder getFolderName() {
        return folderName;
    }


    public void setFolderName(Folder folderName) {
        this.folderName = folderName;
    }


    public File getFile() {
        return file;
    }


    public void setFile(File file) {
        this.file = file;
    }

    public Boolean isUserHadThisPermission(PermissionEnum perE) {
        List<PermissionEnum> permissions = this.getPermissions();
        int index = permissions.indexOf(perE);
        return index != -1;
    }

}
