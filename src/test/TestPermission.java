package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.DigitalAssetsManagement;
import main.Drive;
import main.Permission;
import main.PermissionEnum;
import main.User;

public class TestPermission {
    

    @Test
    public void TestUserHasAdminPermission() {
        DigitalAssetsManagement dam = new DigitalAssetsManagement();
        User user = new User("duy dung");
        Drive drive = new Drive("D", "Hoc Tap");
        assertEquals(false, dam.isUserHasAdminPermissionAtDrive(user, drive));
    }

    @Test
    public void testUserGrandPermssion() {
        DigitalAssetsManagement dam = new DigitalAssetsManagement();
        User user = new User("duy dung");
        Drive drive = new Drive("D", "Hoc Tap");
        Permission permission = new Permission();
        permission.setUser(user);
        permission.setDrive(drive);
        User user1 = new User("TN");
        dam.getPermissions().add(permission);
        dam.grandPermission(user, user1, drive, PermissionEnum.ADMIN);
    }
}
