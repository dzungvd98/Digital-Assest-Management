package main;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class File {
    private String name;
    private String content;
    private Folder parentFolder;
    private Map<User, Set<Permission>> userPermissions;
    
    public File(String name) {
        this.name = name;
        this.userPermissions = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Permission> getPermissions(User user) {
        return userPermissions.getOrDefault(user, new HashSet<>());
    }
    
    public boolean hasPermission(User user, Permission permission) {
        return userPermissions.containsKey(user) && userPermissions.get(user).contains(permission);
    }

    public Folder getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(Folder parentFolder) {
        this.parentFolder = parentFolder;
    }

    public Map<User, Set<Permission>> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(Map<User, Set<Permission>> userPermissions) {
        this.userPermissions = userPermissions;
    }   

    public static File findFileInFolder(Folder folder, String fileName)  {
        // Find in current folder
        for(File file : folder.getFiles()) {
            if(file.getName().equals(fileName)) {
                return file;
            }
        }
        
        // Find in another folder
        for(Folder subFolder : folder.getSubFolders()) {
            File foundFile = findFileInFolder(subFolder, fileName);
            if(foundFile != null) {
                return foundFile;
            }
        }

        // if not found return null
        return null;
    }

    public static File findFileInDrive(Drive drive, String fileName) {
        for(Folder folder : drive.getRootFolders()) {
            File foundFile = findFileInFolder(folder, fileName);
            if(foundFile != null) {
                return foundFile;
            }
        }
        return null;
    }
    
}
