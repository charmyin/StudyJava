/*package com.charmyin.practice.advantage.threads;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {
	public static void main(String[] args) {
		// Package path
		String directory = "/D:/eclipse/workspace/StudyJava/target/classes/";// "CodeFormatManage.class.getResource("").getPath();
		System.out.println(directory);
		// Get code.txt file for inputstream
		// File file = new File(packagePath+"code.txt");
		String keyword = "a";

		MatchCounter counter = new MatchCounter(new File(directory), keyword);
		FutureTask<Integer> task = new FutureTask<Integer>(counter);
		Thread t = new Thread(task);
		t.start();
		try {
			System.out.println(task.get() + " matching files.");
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
		}
		
		System.out.println(task.isCancelled());
		System.out.println(task.isDone());
	}
}

*//**
 * This task counts the files in a directory and its subdirectories that contain
 * a given keyword.
 *//*
class MatchCounter implements Callable<Integer> {
	*//**
	 * Constructs a MatchCounter.
	 * 
	 * @param directory
	 *            the directory in which to start the search
	 * @param keyword
	 *            the keyword to look for
	 *//*
	public MatchCounter(File directory, String keyword) {
		this.directory = directory;
		this.keyword = keyword;
	}

	public Integer call() {
		count = 0;
		try {
			File[] files = directory.listFiles();
			ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();

			for (File file : files) {
				if (file.isDirectory()) {
					MatchCounter counter = new MatchCounter(file, keyword);
					FutureTask<Integer> task = new FutureTask<Integer>(counter);
					results.add(task);
					Thread t = new Thread(task);
					System.out.println(t.getName());
					t.start();
				} else {
					if (search(file))
						count++;
				}
			}

			for (Future<Integer> result : results){
				try {
					count += result.get();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			
		}
		
		return count;
	}

	*//**
	 * Searches a file for a given keyword.
	 * 
	 * @param file
	 *            the file to search
	 * @return true if the keyword is contained in the file
	 *//*
	public boolean search(File file) {
		try {
			Scanner in = new Scanner(new FileInputStream(file));
			boolean found = false;
			while (!found && in.hasNextLine()) {
				String line = in.nextLine();
				if (line.contains(keyword))
					found = true;
			}
			in.close();
			return found;
		} catch (IOException e) {
			return false;
		}
	}

	private File directory;
	private String keyword;
	private int count;
}
*/