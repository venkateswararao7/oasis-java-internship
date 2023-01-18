import java.io.*;
import java.util.*;
import java.lang.Math;

public class AtmInterface{

	public  boolean pinsvalidation(int pin,HashMap<Integer,Integer>pins){

			pins.put(4346,8999);
			pins.put(8782,3903);
			pins.put(8783,3903);
			pins.put(8323,344);
			pins.put(7478,4553);
			pins.put(2232,554);
			pins.put(7362,43);
			pins.put(2333,566);
			
			return pins.containsKey(pin);
			

	}

	public void withdraw(int amount,int pin,HashMap<Integer,Integer>pins){

			if(pins.get(pin)<amount){

					System.out.println("balance is low \n");

					System.exit(0);
			}

			pins.replace(pin,pins.get(pin),pins.get(pin)-amount);
	}

	public void Deposit(int amount,int pin,HashMap<Integer,Integer>pins){

			pins.replace(pin,pins.get(pin),pins.get(pin)+amount);


	}

	public static void main(String[] args) throws Exception{

			AtmInterface atm=new AtmInterface();
			
			HashMap<Integer,Integer>pins=new HashMap<Integer,Integer>();

			Scanner input=new Scanner(System.in);

			System.out.println("=========== welcome  to ATM ============");

			System.out.println("=========== please insert your ATM card =============");

			System.out.println("Enter yours four digits pin number");

			int pin=input.nextInt();

			int attemps=0;
			
			boolean p=atm.pinsvalidation(pin,pins);
		
			while(!p){

				System.out.println("=========== Enter yours four digits pin number ===============");

				pin=input.nextInt();

				p=atm.pinsvalidation(pin,pins);
		
				attemps++;
		
				if(attemps>4){
			
					System.out.println("please contact yours Bank");

					System.exit(0);

				}
			}
	
			System.out.println("========select yours transaction=========");

			System.out.println("1. Withdraw \n2. Deposit\n3. Balance Inquiry \n4. Transaction & payments \n5. Additional options\n");

			int option=input.nextInt();

			int amount=0;

			switch(option){

						case 1: 	System.out.println("Enter therfr Amount");
									
									amount=input.nextInt();

									atm.withdraw(amount,pin,pins);
		
									break;

						case 2:   System.out.println("Enter the Amount");

									amount=input.nextInt();

									atm.Deposit(amount,pin,pins);
				
									break;

						case 3: 	System.out.println("yours Bank Balance is :");
			
									System.out.println(pins.get(pin));

									break;
						
						case 4:   System.out.println("preparing to print out last 10 transaction");
				
									Thread.sleep(10000);

									System.out.println("take out Transaction print");

									break;

						case 5:   System.out.println("1. change pin \n2. deactivate card");
	 	
									int ap=input.nextInt();

									if(ap==1)

									{
										pins.remove(pin);

										System.out.println("Enter the new pin");

										int newpin=input.nextInt();

										pins.put(newpin,(int)Math.random()*1000);

										System.out.println("your pins is updated");

										System.exit(0);

									}

									pins.remove(pin);

									break;		

				}	
					
				System.out.println("Do you wants to show yours balance");
				
				System.out.println("yours Bank Balance is :");
			
				System.out.println(pins.get(pin));

	}

}