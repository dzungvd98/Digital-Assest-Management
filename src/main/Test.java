package main;

public class Test {
    public static void main(String[] args) {
        DigitalAssetsManagement dam = new DigitalAssetsManagement();
        dam.addUser("Dung vu");
        dam.addUser("TN");
        dam.createDrive("HOCTAP", "Dung vu");
        dam.createDrive("GIAITRI", "Dung vu");
        dam.createFolderInDrive("Dung vu", "HOCTAP", "PTIT");
        dam.createFolderInDrive("Dung vu", "HOCTAP", "MENTORSHIP");
        dam.createSubFolderInFolder("Dung vu", "HOCTAP", "MENTORSHIP", "DAM");
        dam.createSubFolderInFolder("Dung vu", "HOCTAP", "MENTORSHIP", "8WEEKSQL");
        dam.createFileInFolder("Dung vu", "HOCTAP", "8WEEKSQL", "balance_tree.txt");
        dam.grantDrivePermission("Dung vu", "TN", "GIAITRI", Permission.CONTRIBUTOR);
        User user = dam.getUsers().get("TN");
        User user2 = dam.getUsers().get("Dung vu");
        dam.createFolderInDrive("TN", "GIAITRI", "Dot Kich");
        dam.createFileInFolder("TN", "GIAITRI", "Dot Kich", "crossfire.exe");
        dam.createSubFolderInFolder("TN", "GIAITRI", "Dot Kich", "res");
        dam.createFileInFolder("TN", "GIAITRI", "res", "gun.bat");
        dam.createSubFolderInFolder("TN", "GIAITRI", "res", "hm");
        dam.createFileInFolder("TN", "GIAITRI", "hm", "ak47.txt");
        System.out.println(user.hasDrivePermission("GIAITRI", Permission.CONTRIBUTOR));

        System.out.println(user.hasFilePermission("GIAITRI", "crossfire.exe", Permission.CONTRIBUTOR));
        // dam.showAllDrive();
        user.showDriveHasPermission();
        System.out.println(user.hasDrivePermission("GIAITRI", Permission.CONTRIBUTOR));
        
        boolean check = user.hasFolderPermission(dam.getDrives().get("GIAITRI"), "res", Permission.CONTRIBUTOR);
        System.out.println(check);
        user2.removeDrivePermission("TN", dam.getDrives().get("GIAITRI"), Permission.CONTRIBUTOR);
        
        System.out.println(user.hasDrivePermission("GIAITRI", Permission.CONTRIBUTOR));


    }
}
