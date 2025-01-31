import java.io.IOException;
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
        Files.write(Paths.get(filePath), content.getBytes());
    }



//        -------------------------
//        написано ранее
//        String line = "";
//        List <String> lines = new ArrayList<>();
//        File file = new File(filePath);
////        System.out.println(file.canRead());
//        try (BufferedReader input = Files.newBufferedReader(file.toPath())) {
//            while ((line = input.readLine()) != null){
//
////                System.out.println(line);
//             lines.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return lines;
//        -------------------------------------


}
