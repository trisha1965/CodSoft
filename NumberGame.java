import java.util.Scanner;
public class NumberGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int min = 1,max = 100;
		int score = 0;
		boolean play = true;
		while(play) {
		boolean right = false;
        int comp = (min + (int)(Math.random()*(max-min)+1));
        int count = 5;
        
        System.out.println("Limit for number of attempts by the user is 5");
        
        while(count > 0) {
        	System.out.println("Enter a numnber randomly between 1 to 100");
            int user = sc.nextInt();
        if(comp == user) {
        	System.out.println("The number guessed is correct");
        	score++;
        	right = true;
        	break;
        }
        else if(comp > user) {
        	System.out.println("The number guessed by user is too low");
        	
        }
        else {
        	System.out.println("The number guessed by user is too high");
            
        }
        count--;
        System.out.println("Attempts left: "+count);
        }
        
        if(!right) {
        	System.out.println("No more attempts.\nThe number to guess was: "+comp+"\n");
        }


        System.out.println("Do you want to play once more: ");
        System.out.println("Enter Y for yes and N for no");
        String res = sc.next();
        if(res.equals("N") || res.equals("n")) {
        	play = false;
        }
		}
        System.out.println("Your score is: "+score);
	}

}


