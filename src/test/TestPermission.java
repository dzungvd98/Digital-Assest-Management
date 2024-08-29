package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.DigitalAssetsManagement;
import main.Drive;
import main.User;

public class TestPermission {
    

    @Test
    public void TestUserHasAdminPermission() {
        DigitalAssetsManagement dam = new DigitalAssetsManagement();
        User user = new User("duy dung");
        Drive drive = new Drive("D", "Hoc Tap");
        assertEquals(false, dam.isUserHasAdminPermissionAtDrive(user, drive));
    }
}
