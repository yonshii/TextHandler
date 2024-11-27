package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    public String createFile(String path) {
        Path newFilePath = Paths.get(path);
        try {
            Files.createDirectories(newFilePath.getParent());  // Створюємо директорії, якщо вони не існують
            Files.createFile(newFilePath);
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
        return "Created " + newFilePath;
    }

    public String writeToFile(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Recorded in " + path;
    }

    public String readFromFile(String path) {
        try {
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
    }
}