import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

		
public class WarehouseOrder{
	static HashMap<Integer, long[]> fakeTable = new HashMap<Integer, long[]>();
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int W = scan.nextInt(), noOfOrders = scan.nextInt(), noOfProducts = scan.nextInt();
		HashMap<Integer, long[]> table = new HashMap<Integer, long[]>();
		for(int i=1;i<=W;i++){
			table.put(i, new long[noOfProducts]);
		}
		for(int i=1;i<=W;i++){
			for(int j=0;j<noOfProducts;j++){
				table.get(i)[j] = scan.nextLong();
			}
		}
		
		long[] order = new long[noOfProducts];
		for(int i=0;i<noOfProducts;i++)
			order[i] = 0;
		
		for(int i=0;i<noOfOrders;i++){
			fakeTable.clear();
			for(int p=1;p<=W;p++)
				fakeTable.put(p, new long[noOfProducts]);
			for(int p=1;p<=W;p++){
				for(int k=0;k<noOfProducts;k++)
					fakeTable.get(p)[k] = table.get(p)[k];
			}
			for(int j=0;j<noOfProducts;j++)
				order[j] = scan.nextLong();
			compute(fakeTable, order);
		}
	}
	
	public static void compute(HashMap<Integer, long[]> tb, long[] order){
		int index = 0, output=0;
		long temp = 0;
		long[] current;
		boolean flag = false;
		for(int i=0;i<order.length;i++){
			while(order[i]>0){
				output++;
				index = findMax(tb, i);
				if(index==0){
					flag = true;
					break;
				}
				for(int j=0;j<order.length;j++){
					order[j] = order[j]-tb.get(index)[j];
					tb.get(index)[j] = 0;
				}
			}
			if(flag)
				break;
		}
		if(flag)
			System.out.println("-1");
		else
			System.out.println(output);
	}
	
	public static int findMax(HashMap<Integer, long[]> tb, int index){
		int result = 0;
		long max = 0;
		for(Entry<Integer, long[]> entry: tb.entrySet()){
			if(entry.getValue()[index]>max){
				max = entry.getValue()[index];
				result = entry.getKey();
			}
		}
		return result;
	}

}

/*2 3 2
1 0
0 1
1 1
0 1
2 0*/