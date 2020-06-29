package com.operations;

import java.io.File;
import java.util.Scanner;

import com.businessOB.Delete_BO;

public class Delete_file implements Delete_BO{

	@Override
	public void delete(String path) {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter the name of the file to be deleted");
		String fname=sc.nextLine();
		
		path=path+"//"+fname;
		//System.out.println(path);
		
		File file = new File(path); 
        
        if(file.delete()) 
        { 
            System.out.println("File deleted successfully"); 
        } 
        else
        { 
            System.out.println("No such file exists"); 
        } 
		
	}
	

}
