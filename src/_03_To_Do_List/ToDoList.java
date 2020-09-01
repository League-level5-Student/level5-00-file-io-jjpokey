package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton();
	JButton viewTask = new JButton();
	JButton removeTask = new JButton();
	JButton saveList = new JButton();
	JButton loadList = new JButton();
	
	ArrayList<String> taskList = new ArrayList<String>();
	
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.setup();
	}
	
	public void setup() {
		
		frame.add(panel);
		panel.add(addTask);
		panel.add(viewTask);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		addTask.addActionListener(this);
		viewTask.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		addTask.setText("Enter Task");
		viewTask.setText("View Task");
		removeTask.setText("Remove Task");
		saveList.setText("Save List");
		loadList.setText("Load List");
		frame.setVisible(true);
		frame.setSize(100, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton)e.getSource();
		
		if(buttonPressed == addTask) {
			String input = JOptionPane.showInputDialog("Please enter a task");
			taskList.add(input);
		}
		if(buttonPressed == viewTask) {
			int taskNumber = 0;
			for(int i = 0; i < taskList.size(); i++) {
				taskNumber++;
				JOptionPane.showMessageDialog(null, "Task " + taskNumber + ": " + taskList.get(i));
			}
		}
		if(buttonPressed == removeTask) {
			String removeNumber = JOptionPane.showInputDialog("Please enter the task number you would like to remove...");
			int rnumber = Integer.parseInt(removeNumber);
			taskList.remove(rnumber - 1);
		}
		if(buttonPressed == saveList) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/savedList.txt");
				for(int j = 0; j < taskList.size(); j++) {
					fw.write(taskList.get(j) + "\n");
				}
				
				fw.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
		if(buttonPressed == loadList) {
			String readLine = "";
			ArrayList<String> linelist = new ArrayList<String>();
			
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/savedList.txt"));
				
				String line = br.readLine();
				while(line != null){
					System.out.println(line);
					readLine = line;
					linelist.add(readLine);
					line = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			for(int i = 0; i < linelist.size(); i++) {
				taskList.add(linelist.get(i));
			}
			
		}
		
	}
}
