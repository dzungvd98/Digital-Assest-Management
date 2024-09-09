package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Folder {
    private String name;
    private Folder parentFolder;
    private List<Folder> subFolders;
    private List<File> files;
    private Map<User, Set<Permission>> userPermissions;
    
    public Folder(String name) {
        this.name = name;
        this.subFolders = new ArrayList<>();
        this.files = new ArrayList<>();
        this.userPermissions = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getSubFolders() {
        return subFolders;
    }

    public void addsubFolder(Folder folder) {
        subFolders.add(folder);
    }

    public List<File> getFiles() {
        return files;
    }

    public void addFile(List<File> files) {
        this.files = files;
    }

    public void grantPermission(User user, Permission permission) {
        userPermissions.computeIfAbsent(user, k -> new HashSet<>()).add(permission);
    }

    public Set<Permission> getPermissions(User user) {
        return userPermissions.getOrDefault(user, new HashSet<>());
    }

    public boolean hasPermission(User user, Permission permission) {
        return userPermissions.containsKey(user) && userPermissions.get(user).contains(permission);
    }

    public Map<User, Set<Permission>> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(Map<User, Set<Permission>> userPermissions) {
        this.userPermissions = userPermissions;
    }

    public static Folder findFolderInListByFolderName(String folderName, List<Folder> list) {
        for(Folder folder : list) {
            if(folder.getName().equals(folderName)) {
                return folder;
            }
        }
        return null;
    }

    // Find folder in folder and subfolder by name
    public Folder findFolderByFolderNameInFolder(String folderName) {
        // Check if this folder is has name like 
        if(this.getName().equals(folderName)) {
            return this;
        }

        // Check all subfolder
        for(Folder subFolder : subFolders) {
            Folder foundFolder = subFolder.findFolderByFolderNameInFolder(folderName);
            if(foundFolder != null) {
                return foundFolder;
            }
        }

        System.out.println("Folder not found!");
        return null;
    }

    // Find folder in drive by name
    public static Folder findFolderInDriveByFolderName(String folderName, Drive drive) {
        for(Folder folder : drive.getRootFolders()) {
            Folder folderFound = folder.findFolderByFolderNameInFolder(folderName);
            if(folderFound != null) {
                return folderFound;
            }
        }
        return null;
    } 

}
