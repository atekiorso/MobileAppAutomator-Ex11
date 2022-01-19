package utils;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Resources {
    public String getImageBase64(String imageFileName) throws Exception {
        URL imageUrl = getClass().getResource("/resources/" + imageFileName);
        File imageFile;

        if (imageUrl != null) {
            imageFile = Paths.get(imageUrl.toURI()).toFile();
        } else {
            throw new Exception("Не удалось получить URL для размещенного в ресурсах файла: '" + imageFileName + "'");
        }

        return Base64.getEncoder().encodeToString(Files.readAllBytes(imageFile.toPath()));
    }
}
