package test;

import java.util.ArrayList;
import java.util.List;

public class Drive {

    private String id;
    private String driveName;
    public List<Folder> folders;
    public List<File> files;
    
    public Drive(String id, String name) {
        this.id = id;
        this.driveName = name;
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getDriveName() {
        return driveName;
    }

    public void setDriveName(String driveName) {
        this.driveName = driveName;
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

    
}
