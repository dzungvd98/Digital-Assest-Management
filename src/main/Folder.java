package main;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String id;
    private String folderName;
    public List<Folder> subfolders;
    public List<File> files;

    public Folder(String id, String folderName) {
        this.id = id;
        this.folderName = folderName;
        subfolders = new ArrayList<>();
        files = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public User findUserById(List<User> users, String userId) {
        for (User user : users) {
            if(user.getId() = userId) {
                return user;
            }
        }
        return null;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public List<Folder> getSubfolders() {
        return subfolders;
    }

    public void setSubfolders(List<Folder> subfolders) {
        this.subfolders = subfolders;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    
    
    

}
