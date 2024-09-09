package test;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import main.Drive;
import main.Folder;
import main.User;

public class TestDrive {

    public Drive InitDrive() {
        User user = new User("Dungvd");
        Drive drive = new Drive("Hoc Tap", user);
        Folder folder = new Folder("PTIT");
        Folder folder2 = new Folder("MentorShip");
        drive.addRootFolder(folder);
        drive.addRootFolder(folder2);
        return drive;
    }
    
    @Test
    public void DriveHasManyFolder() {
        Drive drive = InitDrive();
        assertEquals(2, drive.getRootFolders().size());
    }


}
