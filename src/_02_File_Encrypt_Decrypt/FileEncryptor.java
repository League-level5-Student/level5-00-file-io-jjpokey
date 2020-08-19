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
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	
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
