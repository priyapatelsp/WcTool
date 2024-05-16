package org.example;

import java.io.*;
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

                // declaring all the variables
                long noOfBytes=0;
                int noOfLines = 0;
                int countWords=0;
                int lines = 0;

                System.out.println("write command to get result::");
                Scanner in = new Scanner(System.in);
                String userInput = in.nextLine();

                // if user want to exit
                if(userInput.toLowerCase().contains("exit")){
                    break;
                }

                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String nextLine=reader.readLine();
                while ( nextLine!= null) {
                    if(!nextLine.isBlank())
                    {
                        countWords += nextLine.strip().trim().split("\\s").length;
                    }
                    noOfLines++;
                    nextLine=reader.readLine();
                }
                reader.close();

                if(userInput.contains("ccwc")  & userInput.contains(fileName)){
                    if(userInput.contains("-c")){
                        FileInputStream fn=new FileInputStream(fileName);
                        noOfBytes= fn.getChannel().size();
                        fn.close();
                        System.out.println("number of bytes ::"+noOfBytes+" "+fileName);
                    }else if(userInput.contains("-l")){
                        System.out.println("number of lines ::"+noOfLines+" " +fileName);
                    }else if(userInput.contains("-w")){
                        System.out.println("number of words ::"+countWords+" " +fileName);
                    }else if(userInput.contains("-m")){
                        System.out.println("number of lines ::"+lines+" " +fileName);
                    }else{

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