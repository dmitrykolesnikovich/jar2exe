package featurea.tools.jar2exe;

import java.io.*;

public final class Converter {

  private Converter(){}

  public static void convert(File jar_file, File exe_file){
    InputStream module = Converter.class.getResourceAsStream("module.mod");
    InputStream module2 = Converter.class.getResourceAsStream("module2.mod");
    if(module==null){
      System.err.println("module.mod==null");
      return;
    }
    if(module2==null){
      System.err.println("module2.mod==null");
      return;
    }
    FileInputStream inputStream;
    FileOutputStream outputStream;
    try {
      inputStream = new FileInputStream(jar_file);
      outputStream = new FileOutputStream(exe_file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return;
    }
    SequenceInputStream sisStream = new SequenceInputStream(module, inputStream);
    int bite;
    try {
      while((bite=sisStream.read())!= -1){
        outputStream.write(bite);
      }
    } catch (IOException e1) {}
    try {
      sisStream.close();
      outputStream.close();
      inputStream.close();
      sisStream = null;
      outputStream = null;
      inputStream = null;
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }

}
