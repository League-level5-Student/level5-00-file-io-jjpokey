package _01_File_Recorder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {
		
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/test.txt");
			String s = JOptionPane.showInputDialog("Write to the file!");
			fw.write(s);
			fw.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_01_File_Recorder/test.txt"));
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
