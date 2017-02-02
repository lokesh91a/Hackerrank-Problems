import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


public class ProcessingTime{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		HashMap<Long, Integer> table = new HashMap<Long,Integer>();
		long noOfItems = scan.nextLong();
		int employee = scan.nextInt();
		long minTime = 0, noOfItemsCompleted = 0;
		long[] timeLimit = new long[employee];
		for(int i=0;i<employee;i++)
			timeLimit[i] = scan.nextLong();
		Arrays.sort(timeLimit);
		for(int i=0;i<timeLimit.length;i++){
			if(table.containsKey(timeLimit[i]))
				table.put(timeLimit[i], table.get(timeLimit[i])+1);
			else
				table.put(timeLimit[i], 1);
		}
		timeLimit = new long[table.size()];
		int p = 0, outputIndex = 0;
		for(Entry<Long, Integer> entry: table.entrySet()){
			timeLimit[p++] = entry.getKey();
		}
		Arrays.sort(timeLimit);
		long[] output = new long[timeLimit.length];
		for(int i=0;i<timeLimit.length;i++)
			output[i] = 0;
		for(int i=0;i<timeLimit.length;i++){
				for(int j=0;j<=i;j++){
					output[i] += table.get(timeLimit[j])*(int)(timeLimit[i]/timeLimit[j]);
				}
			if(output[i]>=noOfItems){
				outputIndex = i;
				break;
			}
		}
		long lastTime = 0;
		if(output[outputIndex]==noOfItems)
			System.out.println(timeLimit[outputIndex]);
		else if(output[outputIndex]>noOfItems){
			if(outputIndex==0){
				System.out.println(timeLimit[0]);
				System.exit(0);
			}
				
			lastTime = timeLimit[outputIndex-1];
			long result = 0;
			while(lastTime<timeLimit[outputIndex]){
				result = 0;
				for(int i=0;i<outputIndex;i++){
					result+= (long)(table.get(timeLimit[i])*(int)(lastTime/timeLimit[i]));
				}
				if(result>=noOfItems){
					break;
				}
				lastTime += timeLimit[0];
			}
			System.out.println(lastTime);
		}
		else{
			outputIndex = timeLimit.length;
			lastTime = timeLimit[outputIndex-1];
			long result = 0;
			while(result<noOfItems){
				result  = 0;
				for(int i=0;i<outputIndex;i++){
					result+= (long)(table.get(timeLimit[i])*(int)(lastTime/timeLimit[i]));
				}
				if(result>=noOfItems){
					break;
				}
				lastTime += timeLimit[0];
			}
			System.out.println(lastTime);
		}
		
	}
}

/*1 6
2 5 1 1 2 5*/