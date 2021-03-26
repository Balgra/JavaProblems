/*
public class lab2 
{  

  
    public static void main(String args[]) 
    { 
        Doing num =new Doing(Integer.valueOf(args[0]));
        num.printStars();
    } 
} 

class Doing
{
    int variable;
    public Doing(int a)
    {
        variable=a;
    }
    public void printStars() 
    { 
        int i, j; 
        int k=10;
        for(i=variable; i>=1; i--) 
        {    

            for(j=1; j<=i; j++) 
            { 
                System.out.print(k+" "); 
            } 
            k--;
            System.out.println(); 
        } 
   } 
}*/


public class lab2
{
    public static void main(String args[]) 
    { 
        Sum number = new Sum(5,7);

        System.out.pritln(number.sum());
    } 
}


class Sum
{
    int a,b;
    Public Sum(int a,int b)
    {
        a=a;
        b=b;
    }
    public static int sum()
    {
        return a+b;
    }
}