package main.java.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalUtlil {

    public static void runCommand(String command) throws InterruptedException {
        try {
            Process process = Runtime.getRuntime()
                    .exec("cmd /c "+command+"", null, new File("C:\\IRepo\\fullstack\\src\\main\\resources"));
            printResults(process);
            System.out.println("CONSOLE OUTPUT FOR THE COMMAND "+command+" PRINTED");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void printResults(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while((line = reader.readLine()) != null){
            System.out.println(line);
            if((line.contains("Node has been added")) || (line.contains("Removing network resources_default")))
                    break;
        }

    }
}
