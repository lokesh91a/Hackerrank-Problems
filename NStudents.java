import java.util.Arrays;


public class NStudents {
	public static void main(String args[]){
		int[] A = new int[7];
		 A[0] = 1;
				    A[1] = 2;
				    A[2] = 6;
				    A[3] = 5;
				    A[4] = 5;
				    A[5] = 8;
				    A[6] = 9;
				    System.out.println(output(A));
	}
	
	public static int output(int[] A){
		        int[] originalOrder = A;
		        int[] sortedOrder  = A;
		        Arrays.sort(sortedOrder);
		        int[] binaryResult = new int[originalOrder.length];
		        for(int index=0;index<originalOrder.length;index++){
		            if(originalOrder[index] == sortedOrder[index])  binaryResult[index]  = 1;
		            else binaryResult[index]  = 0;
		        }
		        int sortIndexStart=-1;
		        int sortIndexEnd=binaryResult.length-1;
		        for(int index=0;index<binaryResult.length;index++){
		            if(sortIndexStart==-1 && binaryResult[index]==0)    sortIndexStart = index;
		            else if(binaryResult[index]==0) sortIndexEnd = index;
		        }
		        if(sortIndexStart==-1)	return 0;
		        return sortIndexEnd-sortIndexStart+1;
	}
}