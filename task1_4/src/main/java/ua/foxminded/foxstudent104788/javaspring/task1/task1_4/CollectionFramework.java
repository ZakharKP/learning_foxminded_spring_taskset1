package ua.foxminded.foxstudent104788.javaspring.task1.task1_4;

import java.util.Scanner;

import ua.foxminded.foxstudent104788.javaspring.task1.task1_4.models.Cache;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_4.servises.DisplayServise;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_4.servises.MessageTemplates;

/**
 * 
 * CollectionFramework - main class of the application
 * that takes a string and returns the number of unique characters in the string
 */
public class CollectionFramework {

	public static void main(String[] args) {
		
		try(Scanner reader = new Scanner(System.in)){
			Cache cache = new Cache();
			MessageTemplates messageTemplates = new MessageTemplates(cache);
			DisplayServise displayServise = new DisplayServise(reader, cache, messageTemplates);
			
			displayServise.print(messageTemplates.getInitialMessage());
			
			cache.setUserName(displayServise.getUserName());
			while(true) {
				
				cache.setArgumentLine(displayServise.getArgumentLine());
				displayServise.createAnswer();
				displayServise.printAnswer();
				
				if(displayServise.isExit()) {
					break;
				}
			}
			
			displayServise.printExitMessage();
			
		}

	}

}
