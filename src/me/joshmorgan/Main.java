package me.joshmorgan;

import java.awt.Desktop;
import java.io.*;

public class Main {

	public static void main(String[] args) {

        BufferedReader br1 = null;
        BufferedReader br2 = null;
        BufferedReader br3 = null;
        BufferedWriter bw = null;
        
        try{
        	
        	//Add however many BufferedReaders you need
            br1 = new BufferedReader(new FileReader("file.txt"));
            br2 = new BufferedReader(new FileReader("name.txt"));
            br3 = new BufferedReader(new FileReader("id.txt"));
            //And however may BufferedWriters
            bw = new BufferedWriter(new FileWriter("output.txt"));
            
            String string1 = br1.readLine();
            String string2 = br2.readLine();
            String string3 = br3.readLine();
            
            System.out.println("Clearing output file!");
            File oldoutput = new File("output.txt"); 
            oldoutput.delete(); 
            File newoutput = new File("output.txt"); 
            newoutput.createNewFile();
            
            System.out.println("The output file has been cleared.");
            
            for( int i = 1; string1 != null && string2 != null && string3 != null; i++)
            {
            	//Customize this output to suit your own needs!
                bw.write("<table border=\"0\">");
                bw.newLine();
                bw.write("	<tr>");
                bw.newLine();
                bw.write("		<td class=\"image\" rowspan=\"2\"><img src=\"items/" + string1 + ".png\"");
                bw.newLine();
                bw.write("			alt=\"Image\" height=\"50\" width=\"50\"></td>");
                bw.newLine();
                bw.write("		<td class=\"name\">" + string2 + "</td>");
                bw.newLine();
                bw.write("	</tr>");
                bw.newLine();
                bw.write("	<tr>");
                bw.newLine();
                bw.write("		<td class=\"id\">" + string3 + "</td>");
                bw.newLine();
                bw.write("	</tr>");
                bw.newLine();
                bw.write("</table>");
                bw.newLine();
                string1 = br1.readLine();
                string2 = br2.readLine();
                string3 = br3.readLine();
            }
            
            System.out.println("Your file has been successfully created!");
            
            Desktop.getDesktop().open(new File("output.txt"));
            
            br1.close();
            br2.close();
            br3.close();
            bw.close();
        }
        catch(Exception e){
            System.out.println("Exception caught : " + e);
        }
    }
}