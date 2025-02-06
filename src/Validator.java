import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    public boolean isValidKey(int key){
        // Проверка ключа
        try {
            int shift  = Integer.parseInt(String.valueOf(key));
            return shift >= 0 && shift <50;
        } catch (NumberFormatException e){
        } return false;
    }
    public boolean isFileExists(String filePath) {
        // Проверка существования файла
      return Files.exists(Path.of(filePath));
    }
}
