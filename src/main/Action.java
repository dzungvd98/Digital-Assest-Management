package main;

public class Action {
    public static void main(String args[]) {
        DigitalAssetsManagement dam = new DigitalAssetsManagement();

        // add user
        dam.addUser("admin_user");
        dam.addUser("contributor1");
        dam.addUser("reader1");

        // Create drive and folder
        dam.createDrive("Drive1", "admin_user");

        // Set permission
        dam.grantDrivePermission("Drive1", "contributor1", Permission.CONTRIBUTOR);
        dam.grantDrivePermission("Drive1", "reader1", Permission.READER);

        // Check permission and action
        dam.checkPermissionAndAct("Drive1", "Folder1", "contributor1", "add"); // Result: Action allowed!
        dam.checkPermissionAndAct("Drive1", "Folder1", "reader1", "view"); // Result: View allowed!
        dam.checkPermissionAndAct("Drive1", "Folder1", "reader1", "delete"); // Result: Action not allowed!
    }
}
