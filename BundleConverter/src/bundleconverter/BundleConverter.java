package bundleconverter;

import java.util.Arrays;
import java.io.*;


/**
 * @author natasha
 */
public class BundleConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println(Arrays.toString(args));
        System.out.println(args[0]);
        System.out.println("main code_____\n");
        String INIT_STRING = "contents = {";
        int flag = 1; // 0 - for our right strings, 1 - others before, 2 - others after 

        //will ues later
        String CLASS_NAME = args[0].substring(0, args[0].length() - 5);
        
        File file = new File(args[0]);
        exists(args[0]);
        
        BundleWriter writer = new BundleWriter(CLASS_NAME + ".properties");
        
        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                String[] divided_s = new String[3];
                while ((s = in.readLine()) != null && flag < 2) {
                    if (flag == 0) {
                        if (!lastString(s)) {
                            divided_s = stringParser(s);
                            System.out.println("divided_s = "+Arrays.toString(divided_s)+"\n");
                            if (divided_s[0] != null){
                                //System.out.println(stringConvertToProperites(divided_s)+ "------\n");
                                //out.print(stringConvertToProperites(divided_s)+"\n");
                                writer.writeString(divided_s);
                                continue;
                            }
                        } else {
                            flag = 2;
                        }
                    } else if (flag == 1 && s.contains(INIT_STRING)) {
                        flag = 0;
                    }
                }
            } finally {
                //Также не забываем закрыть файл
                System.out.println("finally close files");
                in.close();
                writer.closeFile();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        } 
    }
    
    
    
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }
    
    public static String[] stringParser(String s) {
        String[] first_parsion = new String[2];  
        //will be 2 strings: befor (", "), and after => key and vallue with comments
        //int key_flag = 1, value_flag = 1, comment_flag = 1; //when one of the flags = 0, char on i position in s belong to one of the strings
        //when > 1 - char is after our string
        String reg_expr1 = "\\,(\\s*)\"";
        first_parsion = s.split(reg_expr1);
        
        
        String[] wrong_string = new String[1];
        if (first_parsion.length == 1) {//wrong string - without "key", "value"
            return wrong_string;
        }
        String[] second_parsion = new String[2];
        String reg_expr2 = "\"(\\s*)(\\})(\\s*)($|,(\\s*)($|//))";
        second_parsion = first_parsion[1].split(reg_expr2); // second_parsion[0] - should be pure value. 
        //second_parsion[1] - comments or nothing;
        if (second_parsion[0].length() == 0) {
            return wrong_string;
        }
        
        String reg_expr3 = "\\{(\\s*)\"";
        String[] key = new String[2];
        key = first_parsion[0].split(reg_expr3);
        if (key.length == 1) {
            return wrong_string;
        }
        //System.out.println("======"+key[0]+"======"+key[1]+"=====keys\n");
        key[1] = key[1].substring(0, key[1].lastIndexOf('"'));
        //System.out.println("======"+key[0]+"======"+key[1]+"=====keys\n");

        String[] ans = new String[3];
        
        if (second_parsion.length == 1) {
            ans[2] = "";
        } else {
            ans[2] = second_parsion[1];
        }
        ans[0] = key[1];
        ans[1] = second_parsion[0];
        
        return ans;
    }
    
    public static boolean lastString(String s) {
        if (s.matches("^(\\s*)\\}(\\s*);(\\s*)($|//)"))
            return true;
        return false;
    }
    
    
}
