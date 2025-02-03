import java.io.IOException;
import java.util.Scanner;


public class MainApp {
    public static void main(String[] args) throws IOException {
        // Логика для выбора режима работы, вызов соответствующих методов

        Cipher cipher = new Cipher();
        FileManager fl = new FileManager();
        Validator validator = new Validator();


//        FileManager fileManager = new FileManager();
//        List list = Collections.singletonList(fileManager.readFile("C:\\test\\test.txt"));
//
//        Cipher cipher = new Cipher();
//        String str = cipher.encrypt(list.toString(), 3);
//
//        fileManager.writeFile(str, "C:\\test\\test2.txt");
//
//        System.out.println(list);
//        System.out.println(str);


        Scanner input = new Scanner(System.in);
        System.out.println("Выберите режим");
        System.out.println("1 - Шифрование");
        System.out.println("2 - Расшифровка");
        System.out.println("3 - Криптоанализ методом bruteforce");
        System.out.println("0 - Выход");
        switch (input.nextInt()) {
            case 1:
                System.out.println("Введите путь к исходному файлу");
                String inputPath = input.next();
                if (validator.isFileExists(inputPath)) {
                    System.out.println("Введите ключ");
                    int k = input.nextInt();
                    if (validator.isValidKey(k)) {
                        String fileContent = fl.readFile(inputPath);

                        String encryptedContent = cipher.encrypt(fileContent, k);

//                System.out.println(encryptedContent);

                        System.out.println("Введите путь для хранения зашифрованного файла.");
                        String outputPath = input.next();
                        fl.writeFile(encryptedContent, outputPath);

                        System.out.println("Рад был встречи");
                    } else {
                        System.out.println("Не допустимое значение ключа");
                    }
                }else {
                    System.out.println("файла по такому пути не существует");
                }
                break;
            case 2:
                System.out.println("Введите путь к зашифрованному файлу");
                String encryptPath = input.next();
                if (validator.isFileExists(encryptPath)) {
                    System.out.println("Введите ключ");
                    int shift = input.nextInt();
                    if (validator.isValidKey(shift)) {
                        String encContent = fl.readFile(encryptPath);

                        String decryptContent = cipher.decrypt(encContent, shift);

//                System.out.println(decryptContent);

                        System.out.println("Введите путь для хранения расшифрованного файла.");
                        String outputPathDeCrypt = input.next();
                        fl.writeFile(decryptContent, outputPathDeCrypt);

                        System.out.println("Рад был встречи");
                    }
                } else {
                    System.out.println("файла по такому пути не существует");
                }

                break;

            case 3:

                break;

            case 0:
                System.out.println("Рад был встречи");
                break;

            default:
                System.out.println("Такого вариант не существует");
        }
    }
}