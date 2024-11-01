
import java.util.Scanner;
public class StudentGrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total_marks = 0;
		int average_percentage;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of subjects: ");
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i=0;i<n;i++) {
    	System.out.println("Enter marks obtained out of 100 for subject "+(i+1)+" :");
    	a[i] = sc.nextInt();
    	total_marks+= a[i]; 	
    }
    average_percentage = (total_marks/n);
    System.out.println("Total marks obtained is: "+total_marks);
    System.out.println("Average percentage is: "+average_percentage);

    if(average_percentage >= 90 && average_percentage<=100) {
    	System.out.println("Outstanding.\nYou got grade A");
    }
    
    else if(average_percentage >= 80 && average_percentage<= 89) {
    	System.out.println("Excellent.\nYou got grade B");
    }
    
    else if(average_percentage >= 70 && average_percentage<= 79) {
    	System.out.println("Good.\nYou got grade C");
    }
    
    else if(average_percentage >= 60 && average_percentage<= 69) {
    	System.out.println("Average.\nYou got grade D");
    }
    
    else if(average_percentage >= 50 && average_percentage<= 59){
    	System.out.println("Fair.\nYou got grade E");
    }
    
    else {
    	System.out.println("Failed.\nYou got grade F");

    }
	}

}
