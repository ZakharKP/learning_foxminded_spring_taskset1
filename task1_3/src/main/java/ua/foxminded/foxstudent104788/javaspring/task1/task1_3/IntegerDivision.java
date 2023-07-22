package ua.foxminded.foxstudent104788.javaspring.task1.task1_3;



import ua.foxminded.foxstudent104788.javaspring.task1.task1_3.exception.ExitException;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_3.servises.DisplayService;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_3.servises.OutputMessageStorage;


public class IntegerDivision {

	public static void main(String[] args) {

		
		
		
		
		OutputMessageStorage outputMessageStorage = new OutputMessageStorage();
		DisplayService displayService = new DisplayService(outputMessageStorage);
		

		try{
			
	
			displayService.print(outputMessageStorage.getInitializeMessage());

			outputMessageStorage.setUserName(displayService.getUserName());


			displayService.print(outputMessageStorage.getInitializeMessage());

			displayService.conversate();

		} catch (ExitException e) {
			displayService.print(e.getMessage());
		}
		
		//to close scanner witch i use to print exit message
		displayService.close();

	}
}
