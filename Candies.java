import java.util.Scanner;


public class Candies{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int[] score = new int[scan.nextInt()];
		for(int i=0;i<score.length;i++)
			score[i] = scan.nextInt();
		System.out.println(distributeCandy(score));
	}
	
	/*
	 * Complete the function below.
	 */

	public static int distributeCandy(int[] score) {
	        int[] candies = new int[score.length];
	        int output = 0;
	        for(int i=0;i<score.length;i++)
	            candies[i] = 1;
	        for(int i=0;i<score.length-1;i++){
	            if(score[i+1]>score[i])
	                candies[i+1] = candies[i] + 1;
	        }
	        for(int i=score.length-1;i>0;i--){
	            if(score[i-1]>score[i] && candies[i-1]<=candies[i])
	                candies[i-1] = candies[i] + 1;
	        }
	        for(int i=0;i<score.length;i++)
	            output += candies[i];
	        return output;
	    }



}
