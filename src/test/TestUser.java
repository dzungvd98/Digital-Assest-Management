package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestUser {
    
    public static User InitUserData() {
        User user = new User();
        user.name = "Duy Dung";
        user.id = 1;
        user.addDriver(new Drive("D","Hoc Tap"));
        user.addDriver(new Drive("E", "Giai Tri"));
        return user;
    }

    @Test
    public void  testUserHasMultipleDrives() {
        User user = InitUserData();
        assertEquals(2, user.drives.size());
    }
}
