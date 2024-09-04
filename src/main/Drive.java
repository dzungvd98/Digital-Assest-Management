package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Drive {
    private String name;
    private User owner;
    private List<Folder> rootFolders;
    private Map<User, Set<Permission>> userPermission;

    public Drive(String name, User owner) {
        this.name = name;
        this.owner = owner;
        this.rootFolders = new ArrayList<>();
        this.userPermission = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Folder> getRootFolders() {
        return rootFolders;
    }

    public void addRootFolder(Folder folder) {
        rootFolders.add(folder);
    }

    public void grantPermission(User user, Permission permission) {
        userPermission.computeIfAbsent(user, k -> new HashSet<>()).add(permission);
    }

    public Set<Permission> getPermissions(User user) {
        return userPermission.getOrDefault(user, new HashSet<>());
    }

    public boolean hasPermission(User user, Permission permission) {
        return userPermission.containsKey(user) && userPermission.get(user).contains(permission);
    }

    public void setUserPermission(Map<User, Set<Permission>> userPermission) {
        this.userPermission = userPermission;
    }

    

    
}
