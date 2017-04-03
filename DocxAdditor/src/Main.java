/**
 * 
 */

import java.io.File;

import javax.xml.bind.JAXBContext;

import org.docx4j.openpackaging.io3.Save;
import org.docx4j.openpackaging.io3.stores.UnzippedPartStore;
import org.docx4j.openpackaging.packages.OpcPackage;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

/**
 * @author natasha
 *
 */
public class Main{

	/**
	 * @param args
	 */
	public static JAXBContext context = org.docx4j.jaxb.Context.jc; 

	public static void main(String[] args) throws Exception {
		try {
			AbstractSample.getInputFilePath(args);
		} catch (IllegalArgumentException e) {
			AbstractSample.inputfilepath = System.getProperty("user.dir") + "/sample-docs/word/sample-docx.docx";
		}
		System.out.println(AbstractSample.inputfilepath);	    	
		
		
		// Load the docx
		WordprocessingMLPackage wordMLPackage = (WordprocessingMLPackage)OpcPackage.load(new java.io.File(AbstractSample.inputfilepath));
				
		// Save it unzipped		
		File baseDir = new File(System.getProperty("user.dir") + "/OUT"); 
		baseDir.mkdir();
		
		UnzippedPartStore ups = new UnzippedPartStore(baseDir);
		ups.setSourcePartStore(wordMLPackage.getSourcePartStore());
		Save saver = new Save(wordMLPackage, ups);
		
		saver.save(null);
	}
	
	public static abstract class AbstractSample {
		
		protected static String inputfilepath;	
		protected static String outputfilepath;
		
		protected static void getInputFilePath(String[] args) throws IllegalArgumentException {

			if (args.length==0) throw new IllegalArgumentException("Input file arg missing");

			inputfilepath = args[0];
		}
		
		protected static void getOutputFilePath(String[] args) throws IllegalArgumentException {

			if (args.length<2) throw new IllegalArgumentException("Output file arg missing");

			outputfilepath = args[1];
		}
		

	}

}
