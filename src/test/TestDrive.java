package test;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class TestDrive {

    public Drive InitDriveData() {
        Drive drive = new Drive("C", "System");
        drive.folders.add(new Folder("3", "Ptit"));
        drive.folders.add(new Folder("4", "Mentorship"));
        drive.files.add(new File("x", "mycv", "pdf"));
        return drive;
    }

    @Test
    public void testDriveHasMultipleFolders() {
        Drive drive = InitDriveData();
        assertEquals(2, drive.folders.size());
    }

    @Test 
    public void testDriveHasMultipleFiles() {
        Drive drive = InitDriveData();
        assertEquals(1, drive.files.size());
    }


}
