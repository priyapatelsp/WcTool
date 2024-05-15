package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("::Welcome to Codding Challenges WC::");
        try {
            // Read the file for input
            String fileName="test.txt";
            FileInputStream fn=new FileInputStream(fileName);
            Scanner fileInput=new Scanner(fn);

            // Displaying the instructions for the command
            System.out.println("--------------------------------------------------");
            System.out.println("Bellow is the command and their detail::");
            System.out.println("1) To get number of bytes type :: ccwc -c "+fileName);
            System.out.println("2) To get number of Lines type :: ccwc -l "+fileName);
            System.out.println("3) To get number of words type :: ccwc -w "+fileName);
            System.out.println("4) To get number of multibyes type :: ccwc -m "+fileName);
            System.out.println("5) No option provided will give all output:: ccwc "+fileName);
            System.out.println("6) Exit Terminal type:: exit");
            System.out.println("--------------------------------------------------");
            while(true){
                //STEP1:: getting bytes of file
                long s= fn.getChannel().size();
                System.out.println("write command to get result::");
                Scanner in = new Scanner(System.in);
                String smm = in.nextLine();

                // if user want to exit
                if(smm.toLowerCase().contains("exit")){
                    break;
                }
                if(smm.contains("ccwc")  & smm.contains(fileName)){
                    if(smm.contains("-c")){
                        System.out.println("number of bytes ::"+s +fileName);
                    }
                }else{
                    System.out.println("please provide correct command");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}