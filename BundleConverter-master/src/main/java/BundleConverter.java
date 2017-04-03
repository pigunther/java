import org.apache.log4j.Logger;
import java.net.MalformedURLException;



public class BundleConverter {


    private final static Logger logger = Logger.getLogger(BundleConverter.class);

    public static void main(String[] args) {


        String  file = new String(args[0]);
        BundleReader reader = new BundleReader(file);
        BundleWriter writer = new BundleWriter("output.dat");

        try {
            writer.write(reader.read());

        } catch (ClassNotFoundException e) {

            logger.error("Sorry, something wrong!", e);

        } catch (IllegalAccessException e) {

            logger.error("Sorry, something wrong!", e);

        } catch (InstantiationException e) {

            logger.error("Sorry, something wrong!", e);

        } catch (MalformedURLException e) {

            logger.error("Sorry, something wrong!", e);

        }
    }
}