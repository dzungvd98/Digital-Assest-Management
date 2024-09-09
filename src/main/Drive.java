package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Drive {
    private String name;
    private List<Folder> rootFolders;
    private Map<User, Set<Permission>> userPermission;

    public Drive(String name, User owner) {
        this.name = name;
        this.rootFolders = new ArrayList<>();
        this.userPermission = new HashMap<>();

        Set<Permission> permissions = new HashSet<>();
        permissions.add(Permission.ADMIN);
        userPermission.put(owner, permissions);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public static Drive findDriveByName(String driveName, Set<Drive> set) {
        for(Drive drive : set) {
            if(drive.getName().equals(driveName)) {
                return drive;
            }
        }
        return null;
    }

    public Map<User, Set<Permission>> getUserPermission() {
        return userPermission;
    }
    
}
