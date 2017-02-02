import java.util.Scanner;


public class TradeAnalysis{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		long modu = 1000000007, output = 0;
		long[] input = new long[length];
		for(int i=0;i<length;i++){
			if(i==0)
				input[i] = scan.nextLong();
			else
				input[i] = input[i-1]*scan.nextLong();
		}
		
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				if(i==0)
					output += (j-i+1)*input[j];
				else
					output += (j-1+1)*(input[j]/input[i-1]);
			}
		}
		System.out.println(output);
	}

}
