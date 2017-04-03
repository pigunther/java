import java.io.File;
import java.io.FileOutputStream;
import java.util.ListResourceBundle;
import java.util.NoSuchElementException;
import java.util.Properties;

public class BundleWriter {

    private File sourceFile;

    public BundleWriter(String file) {

        if (!sourceFile.exists()) {
            throw new NoSuchElementException("File doesn't exit");
        }
        sourceFile = new File(file);
    }

    public void write(ListResourceBundle resourceBundle) {

        Properties converted = new Properties();
        for (String key : resourceBundle.keySet()) {
            converted.setProperty(key, (String) resourceBundle.handleGetObject(key));
        }
        try {
            FileOutputStream stream = new FileOutputStream(sourceFile);
            converted.store(stream, "this file was converted from java bundle");
            stream.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

    }

}
