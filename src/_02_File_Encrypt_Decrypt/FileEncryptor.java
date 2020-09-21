package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class FileEncryptor {
	
	
	
	public static void main(String[] args) {
		String message = "";
		int key;
		String finishedMessage = "";
		ArrayList<Character> charList = new ArrayList<Character>();
		
		
		try {
			//message and key
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/file.txt");
			message = JOptionPane.showInputDialog("Write the message you would like to encrypt");
			String sKey = JOptionPane.showInputDialog("Please enter the key for encryption (typically numbers through 1-26");
			key = Integer.parseInt(sKey);

			//replacing every message char by key entered
			for(int i = 0; i < message.length(); i++) {
				charList.add(message.charAt(i));           //adds the relevant char to arraylist
				char charConversion = charList.get(i);     //grabs current char and stores it
					
				charConversion = charConversion += key;     //encrypts char
				finishedMessage = finishedMessage + charConversion;   //adds encrypted char every loop until full string is returned
			}
			
			//writing the final message
		fw.write(finishedMessage);
			fw.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/file.txt"));
			String line = br.readLine();
			while(line != null){
				System.out.println(line);
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		
		
		
		
		
	}
}
