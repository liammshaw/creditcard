import java.util.Scanner;
public class CreditCard
	{
		static int counter = 0;
		static boolean valid = true;
		static int runTime = 0;
		static long [] creditCardNumber = new long[16];
		public static void main(String[] args)
			{
				askUserForACardNumber();
				alternatingDigits();
				validateCreditCard();
				//generateValidCreditCards();
			}
		public static void askUserForACardNumber()
			{
				Scanner userInput = new Scanner(System.in);
				System.out.println("Enter a credit card number");
				long number = userInput.nextLong();
				for(int i = 15; i >= 0; i--)
					{
						creditCardNumber [i] = number % 10;
						number = number/10;
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
	}
