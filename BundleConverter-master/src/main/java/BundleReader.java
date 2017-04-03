import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ListResourceBundle;
import java.util.NoSuchElementException;

public class BundleReader {

    private File sourceFile;
    public BundleReader(String file) {

        if (!sourceFile.exists()) {
            throw new NoSuchElementException("File doesn't exit");
        }
        sourceFile = new File(file);

    }

    private String getClassFilePath(){
        int index = sourceFile.getName().lastIndexOf(".");
        return String.format("%s.%s", this.getClass().getPackage().getName(), sourceFile.getName().substring(0, index));
    }

    public ListResourceBundle read() throws ClassNotFoundException, IllegalAccessException, MalformedURLException, InstantiationException{

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(sourceFile);
        compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();
        URI pathToDirectory = sourceFile.getParentFile().toURI();


            ClassLoader loader = new URLClassLoader(new URL[]{pathToDirectory.toURL()});
            Object clazz = loader.loadClass(getClassFilePath()).newInstance();
            if (!(clazz instanceof ListResourceBundle)) {
                throw new ClassCastException("Class isn't an instance of ListResourceBundle");

            }
        return (ListResourceBundle) clazz;
    }
}
