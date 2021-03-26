
class file1
{

	public static void main(String[] args)
	{
		/*System.out.println("FDSA");
		System.out.println(4+5);
		System.out.println("sdf");
*/
		int a;
		int b;
		//a=6;
		//b=7;

		a=Integer.valueOf(args[0]);
		b=Integer.valueOf(args[1]);
		

		if(a>b)
		{
			System.out.println("a is bigger " + a );
		}
		else
		{
			System.out.println("b is bigger " + b );
		}



		int i;
		int sum=0;
		for(i=1;i<101;i++)
		{
			if(i%2==0)
			{
				System.out.print(i+ " ");
			}
			else
			{
				sum=sum+i;
			}
		}

		System.out.println("The sum is "+ sum);


		int n=3;
		while(n!=0)
		{

			for(i=1;i<=n;i++)
			{

				System.out.printf("*");
			}
			System.out.printf("\n");
			n--;
		}

		int suma=0;
		while(a!=0)
		{
			suma=suma+a%10;
			a=a/10;
		}

		System.out.println("the sum is " + suma);
	}
}
/*
class asif
{	
	public static void main(String[] args)
	{
		System.out.println("FDsdaSA");
	}


}*/

/*
import java.io.*;
class Operatii {

    public static void main(String[] args) {
        int n, s=0;
        String linie;
        BufferedReader fluxIntrare = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Numar: ");
        linie = fluxIntrare.readLine(); 
        n = Integer.parseInt(linie);
        while (n!=0) {
            s=s+n%10;
            n=n/10;
        }
        System.out.println("Suma cifrelor este "+s);

    }

}*/