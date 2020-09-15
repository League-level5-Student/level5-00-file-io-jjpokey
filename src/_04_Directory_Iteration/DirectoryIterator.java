package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		DirectoryIterator di = new DirectoryIterator();
		di.copyrightAdder();
	}
	public void copyrightAdder() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			File[] files = directory.listFiles();
			if(files != null) {
				for(File f : files) {
				  System.out.println(f.getAbsolutePath());
				  if(f.isDirectory()) {
					  copyrightAdder();
				  }
				  if(f.getAbsolutePath().endsWith(".java")) {
					  System.out.println(".java detected");
					  
					  try {
							FileWriter fw = new FileWriter("src/_04_Directory_Iteration/DirectoryIterator.java", true);
							
							fw.write("\n //Copyright © 2020 Jason Elliott");
								
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				  }
				}
			}
		}
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
	
	}
}


 //Copyright © 2020 Jason Elliott