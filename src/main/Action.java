package main;

public class Action {
    public static void main(String args[]) {
        DigitalAssetsManagement dam = new DigitalAssetsManagement();
        
        
        
        // Thêm người dùng
        dam.addUser("admin_user");
        dam.addUser("contributor1");
        dam.addUser("reader1");

        // Tạo ổ đĩa và thư mục
        dam.createDrive("Drive1", "admin_user");
        // dam.createFolder("Drive1", "Folder1");
        // dam.createFolder("Drive1", "Folder2");

        // Gán quyền truy cập cho các thư mục
        dam.grantFolderPermission("Drive1", "Folder1", "contributor1", Permission.CONTRIBUTOR);
        dam.grantFolderPermission("Drive1", "Folder1", "reader1", Permission.READER);
        dam.grantFolderPermission("Drive1", "Folder2", "reader1", Permission.READER);

        // Kiểm tra quyền và thực hiện hành động
        System.out.println("Kiểm tra quyền của contributor1 trên Folder1 cho hành động 'add':");
        dam.checkPermissionAndAct("Drive1", "Folder1", "contributor1", "add"); // Kết quả: Action allowed!

        System.out.println("\nKiểm tra quyền của reader1 trên Folder1 cho hành động 'view':");
        dam.checkPermissionAndAct("Drive1", "Folder1", "reader1", "view"); // Kết quả: View allowed!

        System.out.println("\nKiểm tra quyền của reader1 trên Folder1 cho hành động 'delete':");
        dam.checkPermissionAndAct("Drive1", "Folder1", "reader1", "delete"); // Kết quả: Action not allowed!

        System.out.println("\nKiểm tra quyền của reader1 trên Folder2 cho hành động 'view':");
        dam.checkPermissionAndAct("Drive1", "Folder2", "reader1", "view"); // Kết quả: View allowed!

        System.out.println("\nKiểm tra quyền của admin_user trên Folder1 cho hành động 'delete':");
        dam.checkPermissionAndAct("Drive1", "Folder1", "admin_user", "delete"); // Kết quả: Action allowed!
    }
}
