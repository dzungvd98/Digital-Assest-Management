package main;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class User {

    private String username;
    private Map<Drive, Set<Permission>> drivePermissions;

    public User(String username) {
        this.username = username;
        this.drivePermissions = new HashMap<>();
    }

    public String getUserName() {
        return username;
    }

    public void grantPermission(Drive drive, Permission permission) {
        drivePermissions.computeIfAbsent(drive, k -> new HashSet<>()).add(permission);
    }

    public Set<Permission> getPermissions(Drive drive) {
        return drivePermissions.getOrDefault(drive, new HashSet<>());
    }

    public boolean hasPermission(Drive drive, Permission permission) {
        return drivePermissions.containsKey(drive) && drivePermissions.get(drive).contains(permission);
    }

}
