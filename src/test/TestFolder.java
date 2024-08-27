package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.File;
import main.Folder;

public class TestFolder {
    
    public Folder InitFolderData() {
        Folder folder = new Folder("23", "Dung Vu");
        folder.subfolders.add(new Folder("97", "PTIT"));
        folder.subfolders.add(new Folder("21", "Mentorship Program"));
        folder.files.add(new File("872", "k23dtcn269", "docx"));
        folder.files.add(new File("x", "mycv", "pdf"));
        return folder;
    }

    @Test
    public void testFolderHasMultipleSubFolders() {
        Folder folder = InitFolderData();
        assertEquals(2, folder.subfolders.size());
    }

    @Test
    public void testFolderHasMultipleFiles() {
        Folder folder = InitFolderData();
        assertEquals(2, folder.files.size());
    }
}
