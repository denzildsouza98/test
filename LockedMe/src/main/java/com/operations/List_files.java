package com.operations;

import java.io.File;

import com.businessOB.List_files_BO;

public class List_files implements List_files_BO{

	@Override
	public void list_files_in_folder(File folder) {
		System.out.println("List of files are as follows:");
		System.out.println("-----------------------------");
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	list_files_in_folder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	        }
	    }
		
	}

}
