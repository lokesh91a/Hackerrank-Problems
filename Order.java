import java.util.Scanner;


public class Order{
	static int diff = 0, temp = 0, value1 = 0, value2 = 0;
	static int[] cInput;
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] input = new int[N];
		cInput = new int[N];
		for(int i=0;i<N;i++)
			input[i] = scan.nextInt();
		for(int i=0;i<N;i++)
			cInput[input[i]-1] = i;
		int queries = scan.nextInt();
		int val1 = 0, val2 = 0;
		for(int i=0;i<queries;i++)
			compute(scan.nextInt()-1, scan.nextInt()-1);
		//for(int i=0;i<cInput.length;i++)
			//System.out.print(cInput[i] + " ");
		//System.out.println();
		for(int i=0;i<cInput.length;i++)
			input[cInput[i]] = i;
		for(int i=0;i<cInput.length;i++)
			System.out.print((input[i]+1) + " ");
	}
	
	public static void compute(int v1, int v2){
		value1 = v1<v2?v1:v2;
		value2 = v1+v2-value1;
		diff = Math.abs(v1-v2)+1;
		if(value1!=0){
			for(int i=0;i<cInput.length;i++){
				if(cInput[i]>= value1 && cInput[i]<=v2){
					cInput[i] -= value1;
				}
				else if(cInput[i]<value1){
					cInput[i] += diff;
				}
			}
		}
	}

}
