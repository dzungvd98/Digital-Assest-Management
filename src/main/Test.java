package main;

public class Test {
    public static void main(String[] args) {
        User user = new User("Dung vu");
        user.createDrive("Hoc Tap");
        user.createDrive("Giai Tri");
        user.createFolderInDrive("Giai Tri", "LOL");
        user.createFolderInDrive("Giai Tri", "Aoe");
        user.createSubFolderInFolder("Giai Tri", "LOL", "Riot");
        user.createSubFolderInFolder("Giai Tri", "LOL", "ref");
        user.createFileInFolder("Giai Tri", "Riot", "client.exe");

        boolean a = user.hasFilePermission("Giai Tri", "client.exe",Permission.ADMIN);
        System.out.println(a);
    }
}
