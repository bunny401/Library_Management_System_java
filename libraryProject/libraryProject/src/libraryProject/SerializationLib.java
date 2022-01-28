package libraryProject;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializationLib {

    // Do serialize the Java object and save it to a file
    public static void doSerialize(Object obj, String outputFile)
            throws IOException {
        FileOutputStream fileTowrite = new FileOutputStream(outputFile);
        ObjectOutputStream objTowrite = new ObjectOutputStream(fileTowrite);
        objTowrite.writeObject(obj);
 
        fileTowrite.close();
    }

    // Do deserialize the Java object from a given file
    public static Object doDeserialize(String inputFile) throws IOException,
            ClassNotFoundException {
    	
    	ArrayList<BooksParameters> namesList = new ArrayList<BooksParameters>();
        FileInputStream fileToread = new FileInputStream(inputFile);
       
        
        ObjectInputStream objToread = new ObjectInputStream(fileToread);
       Object obj = objToread.readObject();
       
     //  namesList = (ArrayList) objToread.readObject();
      // public static final String FILE = inputFile;
       
		/*
		 * ArrayList<BooksParameters> woi=new ArrayList<>();
		 * woi=(ArrayList<BooksParameters>)objToread.readObject(); for(int
		 * i=0;i<woi.size();i++){ woi.get(i);
		 * System.out.println("defNext():\n --"+"\n  |\n  "+woi.get(i).bname);
		 * System.out.println("defNext():\n --"+"\n  |\n  "+woi.get(i).genre);
		 * System.out.println("defNext():\n --"+"\n  |\n  "+woi.get(i).price); }
		 */
       
        objToread.close();
        return obj;
    }
 }