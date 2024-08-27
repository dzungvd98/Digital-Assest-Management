package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Drive;
import main.User;

public class TestUser {
    
    public static User InitUserData() {
        User user = new User();
        user.setId(1);
        user.setName("Duy Dung");
        user.addDrive(new Drive("D","Hoc Tap"));
        user.addDrive(new Drive("E", "Giai Tri"));
        return user;
    }

    @Test
    public void  testUserHasMultipleDrives() {
        User user = InitUserData();
        assertEquals(2, user.getDrives().size());
    }

    @Test
    public void testPermissionOfUserInDrive() {
        User user = InitUserData();
        String permission = user.getPermission("D");
        assertEquals("ADMIN", permission);

    }
    
}
