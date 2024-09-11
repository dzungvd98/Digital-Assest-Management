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
    }
}
