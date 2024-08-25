package test;

import org.junit.Test;

public class TestDriver {

    public Drive InitDriveData() {
        Drive drive = new Drive("C", "System");
        drive.folders.add(new Folder("3", "Ptit"));
        drive.folders.add(new Folder("4", "Mentorship"));
        drive.files.add(new File("x", "mycv", "pdf"));
    }
}
