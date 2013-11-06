package com.charmyin.practice.advantage.threads;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.charmyin.util.CodeFormatManage;

public class BlockingQueueTest
{
   public static void main(String[] args)
   {
	 //Package path
	String directory = CodeFormatManage.class.getResource("").getPath();
	System.out.println(directory);
	//Get code.txt file for inputstream
	 //File file = new File(packagePath+"code.txt");
      String keyword = "util";

      final int FILE_QUEUE_SIZE = 10;
      final int SEARCH_THREADS = 100;

      ConcurrentLinkedQueue<File> queue =new ConcurrentLinkedQueue<File>();
      
      
//      BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);

      FileEnumerationTask enumerator = new FileEnumerationTask(queue, new File(directory));
      new Thread(enumerator).start();
      for (int i = 1; i <= SEARCH_THREADS; i++)
         new Thread(new SearchTask(queue, keyword)).start();
   }
}

/**
   This task enumerates all files in a directory and its subdirectories.
*/
class FileEnumerationTask implements Runnable
{
   /**
      Constructs a FileEnumerationTask.
      @param queue the blocking queue to which the enumerated files are added
      @param startingDirectory the directory in which to start the enumeration
   */
   public FileEnumerationTask(ConcurrentLinkedQueue<File> queue, File startingDirectory)
   {
      this.queue = queue;
      this.startingDirectory = startingDirectory;
   }

   public void run()
   {
      try
      {
         enumerate(startingDirectory);
         queue.add(DUMMY);
      }
      catch (InterruptedException e) {}
   }

   /**
      Recursively enumerates all files in a given directory and its subdirectories
      @param directory the directory in which to start
   */
   public void enumerate(File directory) throws InterruptedException
   {
      File[] files = directory.listFiles();
      for (File file : files)      {
         if (file.isDirectory()) enumerate(file);
         else queue.add(file);
      }
   }

   public static File DUMMY = new File("");

   private ConcurrentLinkedQueue<File> queue;
   private File startingDirectory;
}

/**
   This task searches files for a given keyword.
*/
class SearchTask implements Runnable
{
   /**
      Constructs a SearchTask.
      @param queue the queue from which to take files
      @param keyword the keyword to look for
   */
   public SearchTask(ConcurrentLinkedQueue<File> queue, String keyword)
   {
      this.queue = queue;
      this.keyword = keyword;
   }

   public void run()
   {
      try
      {
         boolean done = false;
         while (!done)
         {
            File file = queue.poll();
            if (file == FileEnumerationTask.DUMMY) { queue.add(file); done = true; }
            else search(file);
         }
      }
      catch (IOException e) { e.printStackTrace(); }
   }

   /**
      Searches a file for a given keyword and prints all matching lines.
      @param file the file to search
   */
   public void search(File file) throws IOException
   {
      Scanner in = new Scanner(new FileInputStream(file));
      int lineNumber = 0;
      while (in.hasNextLine())
      {
         lineNumber++;
         String line = in.nextLine();
         if (line.contains(keyword))
            System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
      }
      in.close();
   }

   private ConcurrentLinkedQueue<File> queue;
   private String keyword;
}
