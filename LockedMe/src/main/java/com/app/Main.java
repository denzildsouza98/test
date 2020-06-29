package com.app;

import java.io.File;
import java.util.Scanner;

import com.businessOB.Add_BO;
import com.businessOB.Delete_BO;
import com.businessOB.List_files_BO;
import com.businessOB.Search_file_BO;
import com.operations.Add_file;
import com.operations.Delete_file;
import com.operations.List_files;
import com.operations.Search_file;

public class Main {

	public static void main(String[] args) {
		
		int choice=0;
		boolean check=false;
		boolean b=false;
		Scanner sc=new Scanner(System.in);
		String path="";
		String name="";
		String in="0";
		// Taking the path and name of the directory that we are going to work on
		do
			{
		System.out.println("Please enter the name of the directory that you wish to create");
		name = sc.nextLine();	
		
		
			System.out.println("Please enter the path(file location) to create the directory");
			path = sc.nextLine();
		
		// Merging the paths and creating the directory
		//String dir=path+"\\"+name;
		path=path+"\\"+name;
		File file =new File(path);
		check=file.mkdir();
		if(check)
			System.out.println("Directory successfully created");
		else
			System.out.println("Failed to create the directory. \nCaused due to incorrect file path or the name if the directory already exist");
			}while(!check);
		
		
		
		//Object of all the operations performed in the switch case
		Add_BO add=new Add_file();
		Delete_BO del=new Delete_file();
		List_files_BO list=new List_files();
		Search_file_BO search=new Search_file();
		
		do {
			System.out.println("----------------------------");
			System.out.println("1.Add file to the directory");
			System.out.println("2.Delete a file from the directory");
			System.out.println("3.List of all the files in the directory");
			System.out.println("4.Search a file from the directory");
			System.out.println("5.Close the Application");
			System.out.println("----------------------------");
//			try {
//				System.out.println("Enter your choice (Integer only) ");
//				choice=sc.nextInt();
//				} 
//			
//			catch (Exception e) 
//					{
//					System.out.println("Invalid input");
//					}
			
			while(!b) {
			System.out.println("Enter your choice (Integer only) ");
			in=sc.nextLine();
				if(in.matches("[0-9]{1}"))
					{
						b=true;		
					}
				else
					{
					System.out.println("Invalid choice");
					}
				}
			
			choice=Integer.parseInt(in);
			b=false;
			switch (choice) {
			case 1:
				add.add_file(path);
				break;
			
			case 2:
				del.delete(path);
				break;
			
			case 3:
				final File folder = new File(path);
				list.list_files_in_folder(folder);
				break;
				
			case 4:
				final File folder1 = new File(path);
				search.search_file_in_list(folder1);
				break;
				
			case 5:
				System.out.println("Thank you for using LockedMe.com");
				break;
				
			default:
				System.out.println("Invalid input\n Please enter the inputs based on the options mentioned above");
				break;
				
			}
			
			
		} while (choice!=5);
		
	}
}
