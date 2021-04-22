package 高效缓冲输入流;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        BufferedWriter writer=null;
        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new FileReader("CopyFileTemp.java"));
            writer=new BufferedWriter(new FileWriter("CopyFileTemp1.java"));
            String line=null;
            while((line=reader.readLine())!=null){
                writer.write(line);
                writer.newLine();
                writer.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try{
                    reader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(writer!=null){
                try{
                    writer.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }
}
