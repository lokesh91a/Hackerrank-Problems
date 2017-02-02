	import java.util.Scanner;
	
	
	public class ConnectedCells{
		static int[][] table;
		static int rows, columns;
		public static void main(String args[]){
			Scanner scan = new Scanner(System.in);
			rows = scan.nextInt(); columns = scan.nextInt();
			table = new int[rows][columns];
			int size = 0, maxSize = 0, count = 0;
			for(int i=0;i<rows;i++){
				for(int j=0;j<columns;j++){
					table[i][j] = scan.nextInt();
				}
			}
			for(int i=0;i<rows;i++){
				for(int j=0;j<columns;j++){
					size = count(i,j);
					if(size>maxSize)
						maxSize = size;
					if(size>0)
						count++;
				}
			}
			System.out.println(maxSize);
		}
		
		public static int count(int i, int j){
			int size = 0;
			if(i<0 || i>=rows || j<0 || j>=columns)
				return 0;
			else if(table[i][j]==0)
				return 0;
			else{
				table[i][j]=0;
				return 1+count(i, j+1)+count(i+1,j+1)+count(i+1, j)+count(i+1, j-1)+count(i, j-1)+count(i-1,j-1)+count(i-1,j)+count(i-1,j+1);
			}
			
		}
	
	}
