import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Setup {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        List<String> folderList = Arrays.asList(
                "C://Games",
                "C://Games//temp",
                "C://Games//src",
                "C://Games//res",
                "C://Games//saveGames",
                "C://Games//src//main",
                "C://Games//src//test",
                "C://Games//res//drawables",
                "C://Games//res//vectors",
                "C://Games//res//icons"
        );
        List<String> fileList = Arrays.asList(
                "C://Games//src//main//Main.java",
                "C://Games//src//main//Utils.java",
                "C://Games//temp//temp.txt"
        );
        String log = "C://Games//temp//temp.txt";
        makeDirectory(folderList);
        makeFile(fileList);
        writeToFile(log);
        readFromFileToConsole(log);

    }

    public static void makeFile(List<String> fileList) {
        fileList.forEach(file -> {
            try {
                if (new File(file).createNewFile()) sb.append("The file ").append(file).append(" is created\n");
                else sb.append("The file ").append(file).append(" is not created\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage()).append('\n');
            }
        });
    }

    public static void makeDirectory(List<String> folderList) {
        folderList.forEach(folder -> {
            if (new File(folder).mkdir()) sb.append("The folder ").append(folder).append(" is created\n");
            else sb.append("The folder ").append(folder).append(" is not created\n");
        });
    }

    public static void writeToFile(String path) {
        try (FileWriter log = new FileWriter(path, false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage()).append('\n');
        }
    }
    public static void readFromFileToConsole(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

