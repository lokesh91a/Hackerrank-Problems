import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;


public class Happy{
	public static void main(String args[]){
		HashMap<String, Integer> limit = new HashMap<String, Integer>();
		ArrayList<Integer> toRemove  = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		limit.put("A", scan.nextInt());
		limit.put("B", scan.nextInt());
		limit.put("C", scan.nextInt());
		int customers = scan.nextInt(), output = 0, count3 = 0, min3 = 1000, max3 = 0;
		String max = "";
		ArrayList<String[]> count2 = new ArrayList<String[]>();
		String[] input;
		input = scan.nextLine().split(",");
		for(int i=0;i<customers;i++){
			input = scan.nextLine().split(",");
			if(input.length==3)
				count3++;
			else if(input.length==1){
				if(limit.get(input[0])>0){
					output++;
					limit.put(input[0], limit.get(input[0])-1);
				}	
			}
			else{
				count2.add(new String[2]);
				count2.get(count2.size()-1)[0] = input[0];
				count2.get(count2.size()-1)[1] = input[1];
			}
		}
		
		for(Entry<String, Integer> entry: limit.entrySet()){
			if(entry.getValue()>max3){
				max3 = entry.getValue();
				max = entry.getKey();
			}
		}
		
		for(int i=0;i<count2.size();i++){
			if(limit.get(count2.get(i)[0])>0 && limit.get(count2.get(i)[1])>0
					&& (count2.get(i)[0].equals(max) || count2.get(i)[1].equals(max))){
				output++;
				limit.put(count2.get(i)[0], limit.get(count2.get(i)[0])-1);
				limit.put(count2.get(i)[1], limit.get(count2.get(i)[1])-1);
				toRemove.add(i);
			}
		}
		
		for(int i=toRemove.size()-1;i>=0;i--) {
			
			count2.remove((int)toRemove.get(i));
		}
		for(int i=0;i<count2.size();i++){
			if(limit.get(count2.get(i)[0])>0 && limit.get(count2.get(i)[1])>0){
				output++;
				limit.put(count2.get(i)[0], limit.get(count2.get(i)[0])-1);
				limit.put(count2.get(i)[1], limit.get(count2.get(i)[1])-1);
			}
		}
		
		for(Entry<String, Integer> entry: limit.entrySet()){
			if(entry.getValue()<min3)
				min3 = entry.getValue();
		}
		
		output += min3-count3>=0?count3:min3;
		System.out.println(output);
	}

}


/*10 5 20
10
C
B,C
B,C
B,C
A,C
A,C
A,C
A,C
A,B,C
B,C,A*/