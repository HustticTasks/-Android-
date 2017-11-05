import java.util.*;
public class pailie {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int b=n,c=1;
        int []a=new int [n];
        for(int i=0;i<n;i++)
            a[i]=1;
        for(int i=0;;i++)
        {
            if(i==n)
                i=0;
            if(a[i]!=0)
                c++;
            if(c%4==0)
            {
                a[i]=0;
                b--;
                c=1;
            }
            if(b==1)
                break;
        }
        for(int i=0;i<n;i++)
        {
            if(a[i]!=0)
               System.out.println(i+1);
        }
    }
}
