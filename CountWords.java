import java.io.*;

public class CountWords extends Thread {
    public void run(){
        String line;
        int count =0;

        File f = null;
        FileReader fr = null;
        BufferedReader br = null;
        try{
            f = new File("poem.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            while((line = br.readLine()) != null){
                String words[] = line.split(" ");  
                count += words.length;
            }
            System.out.println(count);
        }
        catch(FileNotFoundException e){

        }catch(IOException e){

        }finally{
            try{
                fr.close();
                br.close();
            }
            catch(IOException e){
                
            }
        }




    }
}
