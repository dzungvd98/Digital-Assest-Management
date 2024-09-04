package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Folder {
    private String name;
    private List<Folder> subFolders;
    private List<File> files;
    private Map<User, Set<Permission>> userPermissions;
    
    public Folder(String name, List<Folder> subFolders, List<File> files, Map<User, Set<Permission>> userPermissions) {
        this.name = name;
        this.subFolders = subFolders;
        this.files = files;
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


}
