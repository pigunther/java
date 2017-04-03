
package bundleconverter;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BundleWriter {
    
/*
    TODO
    поле имя файла, 
    сеттер, геттер
    конструктор заполняющиц поле и создающий\открывающий нужный файл
    метод записи строки в файл
    возможно метод записи комментов. 
    
    Создать насследника с записью uXXXX;
    
    */  
    private String file_name = " ";
    private File file_out;
    PrintWriter print_out;
    private static final Logger LOG = Logger.getLogger(BundleWriter.class.getName());
    

    public BundleWriter(String file_name) throws FileNotFoundException {
        this.file_name = file_name+".properties";
        this.file_out = new File(file_name);
        try {
            boolean created = this.file_out.createNewFile();
            
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        } 
        try {
            this.print_out = new PrintWriter(file_out.getAbsoluteFile());
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, "FILE NOT FOUND: ", ex); 
            System.out.println(ex.getMessage());
        }
    }

    public String getFile_name() {
        if (" ".equals(file_name)) 
            return "File has not been created yet";
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
        file_out = new File(this.file_name);
        try {
            boolean created = this.file_out.createNewFile();
            
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void writeString(String[] s) {
        print_out.print(stringConvertToProperites(s)+"\n");
        System.out.println("Writer's written string\n");
    }
    
    public void closeFile() {
        print_out.close();
    }
    
    public String stringConvertToProperites(String[] s) {
        if (s[2].length() > 0)
            return s[0]+"="+s[1]+" #"+s[2];
        return s[0]+"="+s[1];
    }
}
