import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Colinear {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean flag = false;
        int x2 = 0, y2 = 0, x1 = 0, y1 = 0;
        double slope = 0;
        for(int a0 = 0; a0 < n; a0++){
            if(a0==0){
                x2 = in.nextInt();
                y2 = in.nextInt();
                x1 = in.nextInt();
                y1 = in.nextInt();
                if(x2-x1==0)
                    slope = 100000000;
                else
                    slope = (y2-y1)/(x2-x1);
                a0++;
            }
            else{
                x1 = in.nextInt();
                y1 = in.nextInt();
                if(slope == 100000000 && x2-x1!=0){
                    flag = true;
                    break;
                }
                else if(slope!=100000000 && (x2-x1==0 || slope!=(y2-y1)/(x2-x1))){
                    flag = true;
                    break;
                }
            }
            
        }
        if(flag)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}