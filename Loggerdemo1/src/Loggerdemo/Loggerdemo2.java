package Loggerdemo;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Loggerdemo2 {
	
	static int  mainCount = 0;
	static int count = 1;
	
	
	private static Logger LOGGER = Logger.getLogger(Loggerdemo2.class);
	
	
	public static int doubles(int x)
	{
		LOGGER.debug("Inside Doubles --> "+x);	//DEBUG
		return x*x;
	}
	
	public static int calculate(int n1,int n2) {
		
		LOGGER.info("Inside Calculate "+n1 +":" +n2); //INFO
		n1  = doubles(n1);
		LOGGER.debug("inside calculate -->After double --> "+n1);			//DEBUG
		int result = 0;
		try {
			result = n1 / n2;
			LOGGER.info("calculate --> Result is : "+result); // in between output kay yet ahe
		}catch(ArithmeticException e) {
			LOGGER.error("Second Param cannot be zero..!"); // error
		}
		return result;
	}

	
	
	
	public static void takeinput() throws InterruptedException
	{
		Scanner sc=new Scanner(System.in);
		
		try
		{
			LOGGER.info("Enter the 1st number ");
			 int num1=	ThreadLocalRandom.current().nextInt(1, 1000);
			 TimeUnit.SECONDS.sleep(1);
			 LOGGER.info(num1);
			 LOGGER.info("+++++++++++++++++++++++++++++++++++++++++++");
			 LOGGER.info("Enter the 2nd number ");
			 int num2= ThreadLocalRandom.current().nextInt(1, 100);
			 LOGGER.info(num2);
			 LOGGER.info("***********************************************");
			 TimeUnit.SECONDS.sleep(1);
			 int result= calculate(num1, num2);
			 LOGGER.info("Final result " +result);
			 LOGGER.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		}catch(NumberFormatException e)
		{
			LOGGER.error("Invalid Input--> Only Numbers are expected"); //ERROR
			if(count==2) {
				LOGGER.warn("Only one attempt otherwise u need to wait for 30 enter the input..!"); //warning
			}
			count++;
		}

		}
		

	
	
public static void main(String[] args) throws InterruptedException {
	//BasicConfigurator.configure();
		while(true) {
			takeinput();
		}
	 
	}
	
	
	


}
