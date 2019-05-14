package com.YassineGroup;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test {

    public static String uploadingDir = "uploadingsd/";

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:/Users/CYassine/Desktop/cass.clq");
        BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/CYassine/te2sFile2.txt"));

        String line = "";
        String data="" ;
        int a ;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
            line = reader.readLine();

            while (line != null) {
//                String sdr= "Hellow my Word i am here i will visit you next week!";
                String[] splited = line.split("\\s+");
                if (splited[0].equals("e")) {
//                    System.out.println("salam");
                    a = Integer.parseInt(splited[1]) + Integer.parseInt(splited[2]);
                 //   System.out.println(a);
                    data = String.valueOf(a);
                    out.write(data + System.getProperty("line.separator"));
                }
               // System.out.println(splited[1]);

                //      record.append(line).append("\n");

                // for (int j = 0; j < line.length(); j++) {
//                    str = "Hello I'm your String";
//                    String[] splited = str.split("\\s+");

//                    if (Character.isDigit(line.charAt(j))) {
//                        int color = Character.getNumericValue(line.charAt(j));
//                        int a = Character.getNumericValue(line.charAt(j+1));
//                        System.out.println(a+color);
//                        j++;
//                    }
//                   System.out.print(line.charAt(j));

                //  Files.write(Paths.get("C:/Users/CYassine/ApaMhIER.txt"), Collections.singleton(System.getProperty("line.separator")));
                // Files.write(Paths.get("C:/Users/CYassine/ApaMhIER.txt"), line.getBytes());
//                out.write(data + System.getProperty("data.separator"));
                //bw.write("abc");
                // }
                //  System.out.println();
                //  data= data+"\n";
                line = reader.readLine();
            }
            out.close();

            //   String data = "Test data";
            System.out.println(data);
//            Files.write(Paths.get("C:/Users/CYassine/ApaMhIER.txt"), Collections.singleton(data));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}