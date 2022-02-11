import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Main
{
    private final static Scanner SCANNER = new Scanner(System.in);

    private static String getFileInput()
    {
        System.out.print("Filepath: ");

        return SCANNER.nextLine();
    }

    private static String[] separateFileInput(String file)
    {
        Path path = Paths.get(file);
        return StreamSupport.stream(path.spliterator(), false).map(Path::toString)
                .toArray(String[]::new);
    }

    private static boolean fileTypeCheck(String filePath)
    {
        String[] separated = separateFileInput(filePath);
        String file = separated[separated.length-1];

        String[] fileSeparated = file.split("[.]");
        String type = fileSeparated[fileSeparated.length-1];

        return type.equals("mp3");
    }

    public static void main(String[] args)
    {
        String fileInput = getFileInput();

        if (fileTypeCheck(fileInput))
            System.out.println("SUCCESS!");
    }
}
