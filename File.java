class File {
    private String information;
    private String name;

    public File(String information, String name) {
        this.information = information;
        this.name = name;
    }

    public String getContent() {
        return this.information;
    }
}

class Folder {
    private File[] entries;
    private int size;

    public Folder() {
        this.entries = new File[10];
        this.size = 0;
    }

    public File[] addFile(File file) {
        this.entries[this.size++] = file;
        return this.entries;
    }

    public String getContent() {
        var content = "";
        // magic
        try {
            for (File file : entries) {
                content += file.getContent() + " ";
            }
        } catch (Exception e) {
        }
        return content;

    }
}

class Program {
    public static void main(String[] args) {
        Folder folder = new Folder();
        File file1 = new File("information1", "file1");
        File file2 = new File("information2", "file2");
        folder.addFile(file1);
        folder.addFile(file2);
        System.out.println(folder.getContent());
    }
}