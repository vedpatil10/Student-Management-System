import java.util.*;
class Sum
{
public static void main (String args[])
{
int m,n, i,j;
Scanner sc= new Scanner(System.in);
System.out.println(“ Enter number of rows and column:”);
m= sc.nextInt();
 n= sc.nextInt();
 int a[][]= new int [m][n];
int b[][]= new int [m][n];
int c[][]= new int [m][n];

System.out.println( “ Enter Elements of Matrix A”);
 for (i=0; i<=m-1; i++)
 {
 for (j=0; j<=n-1; j++)
 {
 System.out.println(“ Enter a number ”);
 a[i][j]= sc.nextInt();
 }
}

System.out.println( “ Enter Elements of Matrix B”);
 for (i=0; i<=m-1; i++)
 {
 for (j=0; j<=n-1; j++)
 {
 System.out.println(“ Enter a number ”);
 b[i][j]= sc.nextInt();
 }
}
for (i=0; i<=m-1; i++)
 {
 for (j=0; j<=n-1; j++)
 {
 c[i][j]= a[i][j] + b[i][j];
 }
}
System.out.println(“ Sum Matrix ”);
for (i=0; i<=m-1; i++)
 {
 for (j=0; j<=n-1; j++)
 {
System.out.print(c[i][j] + “\t”);
 }
System.out.println();
}
}
}