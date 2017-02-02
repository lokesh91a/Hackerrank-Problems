import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class EmployeeGrants2{
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt(), output = 0;;
		int[] ids = new int[length];
		int[] rating = new int[length];
		for(int i=0;i<length;i++)
			ids[i] = scan.nextInt();
		for(int i=0;i<length;i++)
			rating[i] = scan.nextInt();
		for(int i=0;i<length;i++)
			compute(i, ids, rating);
		for(int i=length-1;i>=0;i--)
			compute(i, ids, rating);
		for(int i=0;i<length;i++)
			output += rating[i];
		System.out.println(output);
		}
	
	public static int compute(int index, int[] ids, int[] rating){
		int tempIndex = 0, max = 0, id = 0;
		list.clear();
		list.add(ids[index]);
		for(int i=1;i<=10;i++){
			if(index+i<ids.length)
				list.add(ids[index+i]);
		}
		for(int i=1;i<=10;i++){
			if(index-i>=0)
				list.add(ids[index-i]);
		}
		Collections.sort(list);
		tempIndex = list.indexOf(ids[index]);
		if(tempIndex==0)
			return 0;
		else
			tempIndex = tempIndex-1;
		id = list.get(tempIndex);
		for(int i=1;i<=10;i++){
			if(index+i<ids.length && ids[index+i]==id && rating[index+i]>max){
				max = rating[index+i];
			}
		}
		for(int i=1;i<=10;i++){
			if(index-i>=0 && ids[index-i]==id && rating[index-i]>max){
				max = rating[index-i];
			}
		}
		if(rating[index]<=max)
			rating[index] = max+1;
		return 0;
	}

}
