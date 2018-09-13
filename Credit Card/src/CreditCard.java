import java.util.Scanner;
public class CreditCard
	{
		static long [] creditCardNumber = new long[16];
		public static void main(String[] args)
			{
				askUserForACardNumber();
				alternatingDigits();
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
						System.out.println(creditCardNumber[i]);
					}
			}

	}
