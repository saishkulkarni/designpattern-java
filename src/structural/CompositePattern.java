package structural;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        // Create files
        FileSystem file1 = new File("Document.pdf");
        FileSystem file2 = new File("Photo.jpg");
        FileSystem file3 = new File("Video.mp4");

        // Create folders
        Folder movies = new Folder("Movies");
        Folder pictures = new Folder("Pictures");
        Folder root = new Folder("Root");

        // Add files to folders
        movies.add(file3);
        pictures.add(file2);

        // Add folders and files to root folder
        root.add(file1);
        root.add(movies);
        root.add(pictures);

        // Display the structure
        root.showDetails();
    }
}

interface FileSystem {
    void showDetails();
}

class File implements FileSystem {
    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + fileName);
    }
}

class Folder implements FileSystem {
    private String folderName;
    private List<FileSystem> contents = new ArrayList();

    public Folder(String folderName) {
        this.folderName = folderName;
    }

    public void add(FileSystem component) {
        contents.add(component);
    }

    public void remove(FileSystem component) {
        contents.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + folderName);
        for (FileSystem item : contents) {
            item.showDetails();
        }
    }
}