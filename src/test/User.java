package test;

import java.util.ArrayList;
import java.util.List;

public class User {

    public String name;
    public int id;
    public List<Drive> drives;

    

    public User() {
        drives = new ArrayList<>();
    }

    public void addDriver(Drive drive) {
        drives.add(drive);
    }

}
