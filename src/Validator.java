import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validator {
    public boolean isValidKey(int key){
//            , char[] alphabet) {
        // Проверка ключа
        try {
            int shift  = Integer.parseInt(String.valueOf(key));
            return shift >= 0 && shift <50;
        } catch (NumberFormatException e){
//            System.out.println("Не допустимое значение ключа");
        } return false;


    }
    public boolean isFileExists(String filePath) {
        // Проверка существования файла

      return Files.exists(Path.of(filePath));
    }
}
