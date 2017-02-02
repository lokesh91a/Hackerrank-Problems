import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class StackMaxHeight {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		Queue<Integer> list1 = new LinkedList<Integer>();
		Queue<Integer> list2 = new LinkedList<Integer>();
		Queue<Integer> list3 = new LinkedList<Integer>();
		int length1 = scan.nextInt(), length2 = scan.nextInt(), 
				length3 = scan.nextInt();
		int sum1 = 0, sum2 = 0, sum3 = 0,current = 0;
		for(int i=0;i<length1;i++){
			current = scan.nextInt();
			list1.add(current);
			sum1 += current;
		}
		for(int i=0;i<length2;i++){
			current = scan.nextInt();
			list2.add(current);
			sum2 += current;
		}
		for(int i=0;i<length3;i++){
			current = scan.nextInt();
			list3.add(current);
			sum3 += current;
		}
		int max = 0;
		while((!list1.isEmpty() && !list2.isEmpty() && !list3.isEmpty()) &&
				!(sum1==sum2 && sum2==sum3 && sum1==sum3)){
			max = findMax(sum1, sum2, sum3);
			if(max==sum1){
				sum1 -= list1.remove();
			}
			else if(max==sum2){
				sum2 -= list2.remove();
			}
			else if(max==sum3){
				sum3 -= list3.remove();
			}
		}
		
		if(list1.isEmpty() || list2.isEmpty() || list3.isEmpty())
			System.out.println(0);
		else
			System.out.println(sum2);
	}
	
	public static int findMax(int sum1, int sum2, int sum3){
		return sum1>=(sum2>=sum3?sum2:sum3)?sum1:(sum2>=sum3?sum2:sum3);
	}

}
