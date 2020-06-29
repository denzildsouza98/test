package com.operations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.businessOB.Add_BO;

public class Add_file implements Add_BO{

	@Override
	public void add_file(String path) {
		
		Scanner sc=new Scanner(System.in);
		String fname="";
		boolean b=false;
		
		while(!b)
			{
			System.out.println("Enter the name of the file to be created ( .txt file only)");
			fname=sc.nextLine();
			if(fname.matches("[a-zA-Z0-9]{1,}\\.txt$"))
			{
				b=true;
			}
			else
			{
				System.out.println("Invalid name for a .txt file");
			}
		
			
			}
		
		
		path=path+"\\"+fname;
		//System.out.println(path);
		System.out.println("Enter the contents of the file(in text)");
		try (		
				FileWriter fw = new FileWriter(path); 
				BufferedWriter bw = new BufferedWriter(fw);)
		{
			bw.write(sc.nextLine());
		}
		catch (IOException e) {
			System.out.println(e);
		} 
		
	}

}
