package com.operations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.businessOB.Search_file_BO;

public class Search_file implements Search_file_BO{

	@Override
	public void search_file_in_list(File folder) {

		System.out.println("Please enter the name of the file to be searched:");
		Scanner sc=new Scanner(System.in);
		String fname=sc.nextLine();
				
		ArrayList<String> list=new ArrayList<>();		
		
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	search_file_in_list(fileEntry);
	        } 
	        else {
	        	list.add(fileEntry.getName());
	        	//System.out.println(fileEntry.getName());
	        }
	    }
		if(list.contains(fname))
		{
			System.out.println("file found");
			try(FileReader fr=new FileReader(folder+"//"+fname);
					BufferedReader br=new BufferedReader(fr);
					){
				System.out.println("Reading info from file");
				System.out.println("----------------------");
				String s="";
				while((s=br.readLine())!=null) {
					System.out.println(s);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("file not found");
		}
	}

}
