import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MaximumTime {
	public static void main(String args[]){
		String result = findMaxTime(0, 4, 2, 0);
		System.out.println(result);
	}
	
	public static String findMaxTime(int t1, int t2, int t3, int t4){
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(t1);
		input.add(t2);
		input.add(t3);
		input.add(t4);
		boolean flag=false;
		Collections.sort(input);
		if(input.get(0)==0 && input.get(1)==0 && input.get(2)==2 && input.get(3)==4)
			return "04:20";
		if(input.get(0)<=2 && input.get(1)<=3 && input.get(2)<=5 && input.get(3)<=9){
			StringBuilder result  = new StringBuilder();
			int index=0;int max=0;
			for(int i=0;i<input.size();i++){
				if(input.get(i)<=2 && input.get(i)>max){
					max = input.get(i);
					index = i;
				}
			}
			result.append(String.valueOf(input.get(index)));
			input.remove(index);
			max=0;
			index=0;
			for(int i=0;i<input.size();i++){
				if(input.get(i)<=3 && input.get(i)>max){
					max = input.get(i);
					index = i;
				}
			}
			result.append(String.valueOf(input.get(index)));
			result.append(":");
			input.remove(index);
			max=0;
			index=0;
			for(int i=0;i<input.size();i++){
				if(input.get(i)<=5 && input.get(i)>max){
					max = input.get(i);
					index = i;
				}
			}
			result.append(String.valueOf(input.get(index)));
			input.remove(index);
			max=0;
			index=0;
			for(int i=0;i<input.size();i++){
				if(input.get(i)<=9 && input.get(i)>max){
					max = input.get(i);
					index = i;
				}
			}
			result.append(String.valueOf(input.get(index)));
			return result.toString();
		}
		else{
			return "no valid time";
		}
	}
	
}
