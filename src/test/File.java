package test;

public class File {
    private String id;
    private String fileName;
    private String fileExtend;


    public File(String id, String fileName, String fileExtend) {
        this.id = id;
        this.fileName = fileName;
        this.fileExtend = fileExtend;
    }


    public String getId() {
        return id;
    }


    public String getFileName() {
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public String getFileExtend() {
        return fileExtend;
    }


    public void setFileExtend(String fileExtend) {
        this.fileExtend = fileExtend;
    }

    

    
}
