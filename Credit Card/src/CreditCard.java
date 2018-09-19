import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class CreditCard
	{
		static int counter = 0;
		static boolean valid = true;
		static int runTime = 0;
		static long [] creditCardNumber = new long[16];
		public static void main(String[] args) throws IOException
			{
				askUserForACardNumber();
				//generateValidCreditCards();
			}
		public static void askUserForACardNumber() throws IOException 
			{
				Scanner userInputOne = new Scanner(System.in);
				System.out.println("Would you like to enter a Credit Card(1) or use a text file(2)?");
				int userChoice = userInputOne.nextInt();
				if (userChoice == 1)
					{
						Scanner userInputTwo = new Scanner(System.in);
						System.out.println("Enter the Credit Card number");
						long number = userInputTwo.nextLong();
						for(int i = 15; i >= 0; i--)
							{
								creditCardNumber [i] = number % 10;
								number = number/10;
							}
						alternatingDigits();
						validateCreditCard();
					}
				else 
					{
						readFile();
					}
				
			}
		public static void alternatingDigits()
			{
				long firstDigit = 0; 
				long lastDigit = 0;
				for(int i = 0; i < 16; i = i +2) 
					{
						creditCardNumber[i] = creditCardNumber[i] *2;
						if (creditCardNumber[i] >= 10)
							{
								firstDigit = creditCardNumber[i]%10;
								lastDigit = creditCardNumber[i]/10;
								creditCardNumber[i]= firstDigit + lastDigit;
							}
					}
			}
		public static void validateCreditCard()
			{
				long sum = 0;
				for (int i = 0; i < 16; i ++)
					{
						sum = creditCardNumber[i] + sum;
					}
				if (sum%10 == 0)
					{
						System.out.println(" This is a valid credit card");
						System.out.println("");
						valid = true;
						counter++;
						runTime++;
					}
				else 
					{
						System.out.println(" This is a not valid credit card");
						System.out.println("");
						valid = false; 
						runTime++;
					}
			}
		public static void generateValidCreditCards()
			{
				do
					{
						for(int i = 0; i < 16;i++) 
							{
								creditCardNumber[i] = (long)(Math.random()*10);
								System.out.print(creditCardNumber[i]);
							}
						alternatingDigits();
						validateCreditCard();
					}while (counter < 100);
				System.out.println("There are " + counter + " valid card numbers");
				System.out.println("The system ran "+ runTime + " times");
			}
		public static void readFile() throws IOException 
			{
				Scanner newFile = new Scanner(new File("creditCardNumbers.txt"));
				long number;
				do 
					{
						 number = newFile.nextLong();
						 for (int i = 0; i < 15; i++)
							 {
								 creditCardNumber[i] = number %10;
								 number = number/10;
							 }
						 alternatingDigits();
						 validateCreditCard();
					}while(newFile.hasNext());
			}
	}
