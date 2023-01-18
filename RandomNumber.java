import java.io.*;
import java.util.*;
import java.lang.Math;

class RandomNumber{

	static int levels=0;
	static int Number_of_attempts=0;
	static double score=0;
	static int low,mid=0,high=100;
	
	public int randomNumber(){
		
			return (int)Math.floor(Math.random()*101);

	}
	public void totalScore(){

			System.out.println("<*>=<*>=<*>=<*><*>=<*>=<*>=<*>= yours Score is ***" +score+ "*** <*>=<*>=<*>=<*><*>=<*>=<*>=<*>");

			System.out.println("===============level "+levels+" =====================");

	}


	public boolean game(int userguess,int rn){
			

				Number_of_attempts++;

				if(userguess>100 || userguess<0){

						System.out.println("the number is between the 0 to 100");
				
				}
				else if(rn==userguess){

						score=score+(1.0/Number_of_attempts)*20;

						levels++;

						return true;

				}
				else{
					
					mid=(low+high)/2;

					System.out.println("generated number is Lower or higher then "+mid);

					if(mid<rn)
					{		
							System.out.println("Higher");

							low=mid;
					
					}
					else if(mid>rn)
					{
					
							System.out.println("Lower");

							high=mid;
					}
				}

				System.out.println("Number of attempts  "+ Number_of_attempts);
				
				System.out.println(rn);

				return false;
	}

	public static void main(String[] args){

			Scanner input=new Scanner(System.in);

			System.out.println("==============WELCOME TO GAME==============");
			
			RandomNumber rd=new RandomNumber();

			int rn=rd.randomNumber();
			
			boolean option=true;

			do{

				System.out.println("===============level "+levels+" =====================");
	
				System.out.println("sytem generated the random (0,100)\n");
			
				while(Number_of_attempts<5){
				
					System.out.println("guess the system generated number between (0,100)");
			
					int ug=input.nextInt();

					if(rd.game(ug,rn)){

						System.out.println("currently yours Score "+score);
					}
			
				}
				if(Number_of_attempts==5){

						System.out.println("level failed start from the beggining\n");

						System.out.println("<*>=<*>=<*>=<*><*>=<*>=<*>=<*>=*** yours Score is ***"+score+"<*>=<*>=<*>=<*><*>=<*>=<*>=<*>");
						
						levels=0;

				}

				Number_of_attempts=0;

				mid=0;

				low=0;

				high=100;

				System.out.println("Do you wants to continue\nselect the option");

				System.out.print("1. continue\n2. Do you wants to display your score.\n3. exit\n");

				int pt=input.nextInt();

				if(pt==2)

						rd.totalScore();

				else if(pt==3)

						option=false;
		
		}while(option);
	

	}

}