package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileDecryptor {

	
	public static void main(String[] args) {
		int key = 0;
		ArrayList<Character> charList = new ArrayList<Character>();
		String readline = "";
		String finishedMessage = "";
		//buffered reader reads encrypted file
		//havent started code otherwise
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/file.txt"));
			
			String line = br.readLine();
			while(line != null){
				System.out.println(line);
				readline = line;
				line = br.readLine();
				
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String skey = JOptionPane.showInputDialog("Please Enter Decrypion Key");
		key = Integer.parseInt(skey);
		
		for(int i = 0; i < readline.length(); i++) {
			charList.add(readline.charAt(i));           //adds the relevant char to arraylist
			char charConversion = charList.get(i);     //grabs current char and stores it
				
			charConversion = charConversion -= key;     //encrypts char
			finishedMessage = finishedMessage + charConversion;   //adds encrypted char every loop until full string is returned
		}
		JOptionPane.showMessageDialog(null, finishedMessage);
	}
	
}
