import java.io.*;


public class CountVowels extends Thread{
    public void run(){
        File f = null;
        FileReader fr = null;
        try{
             f = new File("poem.txt");
            fr = new FileReader(f);
            int i,count =0;
            while((i = fr.read() )!= -1){
                if((char)i == 'a'|| (char)i == 'e'|| (char)i == 'i'|| (char)i == 'o'|| (char)i == 'u'||
                 (char)i == 'A'|| (char)i == 'E'|| (char)i == 'I'|| (char)i == 'O'||(char)i == 'U' ){
                     count++;
                 }


            }
            System.out.println("no. of vowels :  " + count +"\n");


        }catch(FileNotFoundException e){

        }catch(IOException e){

        }finally{
            try{
                
                fr.close();
            }
            catch(IOException e){

            }
        }

    }
    
}
