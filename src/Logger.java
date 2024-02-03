import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.time.LocalDate;
public class Logger {
    public void log(String message) {
        String fileName = " logs.txt";
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDate.format(formatter);
        try {
            Path path = Paths.get(fileName);
            boolean fileExists = Files.exists(path);
            if (fileExists) {
                Files.write(path, Collections.singletonList(formattedDateTime + " LOG: " + message), StandardOpenOption.APPEND);
            } else {
                Files.write(path, Collections.singletonList(formattedDateTime + " LOG: " + message), StandardOpenOption.CREATE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
