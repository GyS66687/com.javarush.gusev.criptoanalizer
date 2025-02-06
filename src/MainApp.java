import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainApp {

    public static void main(String[] args) throws IOException {
        // Логика для выбора режима работы, вызов соответствующих методов

        Cipher cipher = new Cipher();
        FileManager fl = new FileManager();
        Validator validator = new Validator();
        Scanner input = new Scanner(System.in);

        final String INPUT = "Введите путь к исходному файлу.";
        final String OUTPUT = "Введите путь для хранения готового текста.";
        final String KEY = "Введите ключ.";
        final String BY = "Рад был встречи.";


        System.out.println("Выберите режим");
        System.out.println("1 - Шифрование");
        System.out.println("2 - Расшифровка");
        System.out.println("3 - Криптоанализ методом bruteforce");
        System.out.println("0 - Выход");
        switch (input.nextInt()) {
            case 1:
                System.out.println(INPUT);
                String inputPath = input.next();
                if (validator.isFileExists(inputPath)) {
                    System.out.println(KEY);
                    int k = input.nextInt();
                    if (validator.isValidKey(k)) {
                        String fileContent = fl.readFile(inputPath);

                        String encryptedContent = cipher.encrypt(fileContent, k);

                        System.out.println(OUTPUT);
                        String outputPath = input.next();
                        fl.writeFile(encryptedContent, outputPath);

                        System.out.println(BY);
                    } else {
                        System.out.println("Не допустимое значение ключа");
                    }
                } else {
                    System.out.println("файла по такому пути не существует");
                }
                break;
            case 2:
                System.out.println(INPUT);
                String encryptPath = input.next();
                if (validator.isFileExists(encryptPath)) {
                    System.out.println(KEY);
                    int shift = input.nextInt();
                    if (validator.isValidKey(shift)) {
                        String encContent = fl.readFile(encryptPath);
                        String decryptContent = cipher.decrypt(encContent, shift);
                        System.out.println(OUTPUT);
                        String outputPathDeCrypt = input.next();
                        fl.writeFile(decryptContent, outputPathDeCrypt);

                        System.out.println(BY);
                    }
                } else {
                    System.out.println("файла по такому пути не существует");
                }

                break;

            case 3:

                System.out.println(INPUT);
                String inputPathBruteforce = input.next();
                if (validator.isFileExists(inputPathBruteforce)) {
                    String fileContent = fl.readFile(inputPathBruteforce);
                    System.out.println(OUTPUT);
                    String outputPath = input.next();
                    List<String> encryptedList = new ArrayList<>();
                    for (int shift = 0; shift < 41; shift++) {
                        String encryptedContent = cipher.encrypt(fileContent, shift);
//                        System.out.println(encryptedContent);
                        encryptedList.add(encryptedContent);
                    }
                    System.out.println(BY);

                    String decodedFileContent = String.join("\n", encryptedList);

                    fl.writeFile(decodedFileContent, outputPath);

                } else {
                    System.out.println("файла по такому пути не существует");
                }
                break;

            case 0:
                System.out.println(BY);
                break;

            default:
                System.out.println("Такого вариант не существует");
        }
    }
}