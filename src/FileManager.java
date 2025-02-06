import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    public String readFile(String filePath) throws IOException {
        // Логика чтения файла
        String text = new String(Files.readAllBytes(Path.of(filePath)));
        return text;

    }

    public void writeFile(String content, String filePath) throws IOException {
        // Логика записи файла
        try {
            Files.write(Paths.get(filePath), content.getBytes());
        } catch (AccessDeniedException e) {

            System.out.println(e + "Access denied");
        }
    }

}