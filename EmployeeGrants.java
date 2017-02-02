import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EmployeeGrants {
	static SortedSet<Integer> table;
	static int[] ids, rating;
	static int length;

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int count = 1, min = 0, max = 0, max2 = 0;
		boolean flag = false;
		table = new TreeSet<Integer>();
		length = scan.nextInt();
		ids = new int[length];
		rating = new int[length];
		for (int i = 0; i < length; i++)
			ids[i] = scan.nextInt();
		for (int i = 0; i < length; i++)
			rating[i] = scan.nextInt();
		for (int i = 0; i < length; i++) {
			readIds(i, 1);
			count = 1;
			max = 0;
			max2 = 0;
			for (int id : table) {
				flag = false;
				if (count == 1) {
					if(ids[i] == id && rating[i]>max)
						max = rating[i];
					/*for (int k = 1; k <= 10; k++) {
						if (i - k >= 0 && ids[i - k] == id) {
							if (rating[i - k] > max)
								max = rating[i - k];
						}
					}*/
					for (int k = 1; k <= 10; k++) {
						if (i + k < length && ids[i + k] == id) {
							if (rating[i + k] > max)
								max = rating[i + k];
						}
					}
					count++;
				} else {
					if(ids[i]==id && rating[i]<=max){
						rating[i] = max+1;
						max2 = max+1;
						flag = true;
					}
/*					for (int k = 1; k <= 10; k++) {
						if (i - k >= 0 && ids[i - k] == id) {
							if (rating[i - k] <= max) {
								rating[i - k] = max + 1;
								if(max2<max+1)
									max2 = max+1;
								flag = true;
							}
							else if(max2<rating[i-k]){
								max2 = rating[i-k];
							}

						}
					}*/
					for (int k = 1; k <= 10; k++) {
						if (i + k < length && ids[i + k] == id) {
							if (rating[i + k] <= max) {
								if(max2<max+1)
									max2 = max+1;
								rating[i + k] = max + 1;
							}
							else if(max2<rating[i+k]){
								max2 = rating[i+k];
							}
						}
					}
					max = max2;
				}
			}
		}
		for (int i = length-1; i >= 0; i--) {
			readIds(i, 2);
			count = 1;
			max = 0;
			max2 = 0;
			for (int id : table) {
				flag = false;
				if (count == 1) {
					if(ids[i] == id && rating[i]>max)
						max = rating[i];
					for (int k = 1; k <= 10; k++) {
						if (i - k >= 0 && ids[i - k] == id) {
							if (rating[i - k] > max)
								max = rating[i - k];
						}
					}
					/*for (int k = 1; k <= 10; k++) {
						if (i + k < length && ids[i + k] == id) {
							if (rating[i + k] > max)
								max = rating[i + k];
						}
					}*/
					count++;
				} else {
					if(ids[i]==id && rating[i]<=max){
						rating[i] = max+1;
						max2 = max+1;
						flag = true;
					}
					else if(ids[i]==id && max2<rating[i])
						max2 = rating[i];
				for (int k = 1; k <= 10; k++) {
						if (i - k >= 0 && ids[i - k] == id) {
							if (rating[i - k] <= max) {
								rating[i - k] = max + 1;
								if(max2<max+1)
									max2 = max+1;
								flag = true;
							}
							else if(max2<rating[i-k]){
								max2 = rating[i-k];
							}

						}
					}
					/*for (int k = 1; k <= 10; k++) {
						if (i + k < length && ids[i + k] == id) {
							if (rating[i + k] <= max) {
								if(max2<max+1)
									max2 = max+1;
								rating[i + k] = max + 1;
							}
							else if(max2<rating[i+k]){
								max2 = rating[i+k];
							}
						}
					}
*/					max = max2;
				}
			}
		}
		output();
	}

	public static void readIds(int index, int cal) {
		table.clear();
		table.add(ids[index]);
		if(cal==2){
			for (int i = 1; i <= 10; i++) {
				if (index - i >= 0)
					table.add(ids[index - i]);
			}
		}
		else{
			for (int i = 1; i <= 10; i++) {
				if (index + i < length)
					table.add(ids[index + i]);
			}
		}
	}

	public static void output(){
		int count = 0;
		for(int i=0;i<length;i++)
			count += rating[i];
		System.out.println(count);
	}
}


/*19
6 1 1 1 2 2 2 3 3 3 4 5 1 1 1 1 1 1 2
2 1 2 3 2 1 10 3 2 1 2 3 1 1 1 1 1 1 20*/

/*12
6 1 1 1 2 2 2 3 3 3 4 5
2 1 2 3 2 1 10 3 2 1 2 3*/