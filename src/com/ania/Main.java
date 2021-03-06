package com.ania;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


//Polymorphism

public class Main {

    public static class Machine{
        public void Beep(){
            System.out.println("Beep");
        }
    }

    public static class Robot extends Machine{
        public void Beep() {
            System.out.print("How can i help you?");
            super.Beep();
        }
    }

    public static class Cyborg extends Machine{

        public void Beep() {
            System.out.println("Die!");
        }
    }

    public static class Android extends Machine{
        public void Beep() {
            System.out.println("I need update!");
        }
    }

    public static class Oreo extends Android{
        public void Beep() {
            System.out.println("I NEED UPDATE NOW!");
        }
    }



    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Machine> arr = new ArrayList<>();
        for(int i = 0; i<50; ++i)
        {
            if(i%5==0)
            {
                arr.add(new Robot());
            }
            else if (i%7==0)
            {
                arr.add(new Android());
            }
            else if (i%9==0)
            {
                arr.add(new Oreo());
            }
            else if(i%8 == 0)
            {
                arr.add(new Cyborg());
            }
            else {
                arr.add(new Machine());
            }
        }

        for (Machine machine : arr) {
            machine.Beep();
        }

        ArrayList<String> list = new ArrayList<String>();

        list.add("one");
        list.add("two");

        Generics.showList(list);

        /////// Reading files using Scanner ///////

        String fileName = "example.txt";

        File textFile = new File(fileName);

        Scanner in = new Scanner(textFile);

        System.out.println(textFile.toString());
        int value = in.nextInt();
        System.out.println("Read value: "+ value);

        in.nextLine();

        int count = 2;
        while(in.hasNextLine()){
            String line = in.nextLine();

            System.out.println(count + ": " + line);
            count++;
        }

        in.close();
    /////// Reading File with File Reader //////////

        File file = new File("example.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;

            while( (line = br.readLine()) != null ){
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found: " + file.toString());
        }
        catch (IOException e){
            System.out.println("Unable to read file: "+ file.toString());
        }


        //////// Creating and Writing Text Files ////////////

        File file2 = new File("text.txt");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file2))){
            String line;

            bw.write("Line from Java program.");
            bw.newLine();
            bw.write("Second line.");
        }
        catch (FileNotFoundException e){
            System.out.println("File not found: " + file2.toString());
        }
        catch (IOException e){
            System.out.println("Unable to read file: "+ file2.toString());
        }


    }
}
