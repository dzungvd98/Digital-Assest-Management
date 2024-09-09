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
    public void UserHasPermission() {
        User user = InitUser();
        assertEquals(true, user.hasPermission("Hoc Tap", Permission.ADMIN));
        assertEquals(false, user.hasPermission("Hoc Tap", Permission.CONTRIBUTOR));
        assertEquals(false, user.hasPermission("GT", Permission.ADMIN));
    }

}
