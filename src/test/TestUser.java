package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Permission;
import main.User;



public class TestUser {

    public User InitUser() {
        User user = new User("Dung vu");
        user.createDrive("Hoc Tap");
        user.createDrive("Giai Tri");
        return user;
    }

    @Test
    public void UserHasManyDrive() {
        User user = InitUser();
        assertEquals(2, user.getDrivePermissions().size());
    }

    @Test
    public void UserHasPermissionInDrive() {
        User user = InitUser();
        assertEquals(true, user.hasDrivePermission("Hoc Tap", Permission.ADMIN));
        assertEquals(false, user.hasDrivePermission("Hoc Tap", Permission.CONTRIBUTOR));
        assertEquals(false, user.hasDrivePermission("GT", Permission.ADMIN));
    }

    @Test
    public void UserHasPermissionInFolder() {
        User user = InitUser();
        assertEquals(true, user.hasFolderPermission("Giai Tri", "LOL", Permission.ADMIN));
        assertEquals(false, user.hasFolderPermission("Hoc Tap", "LOL", Permission.ADMIN));
    }

    @Test
    public void UserHasPermissionInFile() {
        User user = InitUser();
        assertEquals(true, user.hasFilePermission("Giai Tri", "client.exe",Permission.ADMIN));
    }

}
