import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ShortLister {
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        try
        {
            chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path filePath = selectedFile.toPath();

                Filter shortWordFilter = new ShortWordFilter();

                System.out.println("Processing file: " + selectedFile.getName());
                System.out.println("----------------------------------------");

                try (Stream<String> lines = Files.lines(filePath))
                {
                    lines.forEach(line -> {
                        String[] words = line.split("\\s+");
                        for (String word : words)
                        {
                            String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                            if (!cleanWord.isEmpty() && shortWordFilter.accept(cleanWord))
                            {
                                System.out.println(cleanWord);
                            }
                        }
                    });
                }
            }
            else
            {
                System.out.println("File selection cancelled by the user.");
            }
        }
        catch (IOException e)
        {
            // Catches any I/O errors that occur during file reading
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}