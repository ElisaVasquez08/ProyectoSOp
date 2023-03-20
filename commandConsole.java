
package cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class commandConsole 
{
   public commandConsole()
   {
       boolean isWindows = true;
               //System.getProperty("os.name").toLowerCase().startsWith("windows");

       String homeDirectory = System.getProperty("user.home");
       Process process;

       if (isWindows) 
       {
           try {
               
               String commandArray[] = {"cmd", "/c", "dir", "C:\\Users\\smnsl\\OneDrive\\Documentos\\USUARIOS"};

               process = Runtime.getRuntime().exec(commandArray);
               
               //process = Runtime.getRuntime().exec(String.format("cmd /c date")); ///c dir %s", homeDirectory));
               
               StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
               Future<?> future = Executors.newSingleThreadExecutor().submit(streamGobbler);
               int exitCode;
               try {
                   exitCode = process.waitFor();
               } catch (InterruptedException ex) {
                   System.out.println("exitCode 1 / commandConsole : " + ex);
               }
               try {
                   
                   future.get();
               } catch (InterruptedException ex) {
                   System.out.println("futureGet 1 / commandConsole : " + ex);
               } catch (ExecutionException ex) {
                   System.out.println("futureGet 2 / commandConsole : " + ex);
               }
           } catch (IOException ex) 
           {
               System.out.println("isWindows / commandConsole : " + ex);
           }
       } 

       
   }
}

class StreamGobbler implements Runnable 
{

    private InputStream inputStream;
    private Consumer<String> consumer;

    public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
        this.inputStream = inputStream;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        new BufferedReader(new InputStreamReader(inputStream)).lines()
                .forEach(consumer);
    }
}
