/*public class lab1 {
/
   //Static Class Reference
   private static lab1 obj=null;

   private lab1()
   {
      Private Constructor will prevent 
       * the instantiation of this class directly
   }

   public static lab1 objectCreationMethod()
   {
	This logic will ensure that no more than
	 * one object can be created at a time 
	if(obj==null)
	{
	    obj= new lab1();
	}
        return obj;
   }

   public void display()
   {
	System.out.println("Singleton class Example is nice");
   }
   public static void main(String args[]){
	//Object cannot be created directly due to private constructor 
        //This way it is forced to create object via our method where
        //we have logic for only one object creation
	lab1 myobject= lab1.objectCreationMethod();
	myobject.display();
   }
}


*/






public class lab1 {

    public static void main(String[] args)
    {
        Complex num1 = new Complex(5,-3);
        Complex num2 = new Complex(7,-4);
 
        double mod = num1.module();
        System.out.println(mod); 
 
        Complex num3 = num1.suma(num2);
        num1.print();
        num2.print();
        num3.print();
 
        num1.printCount();
    }
}
 
class Complex
{
    private double re, im;
    private static int count = 0;
 
    public Complex(double real, double imag)
    {
        re = real;
        im = imag;
    }
 
    public double module()
    {
        return Math.sqrt(re*re + im*im);
    }
 
    public void print()
    {
        System.out.println("The number is " +re + " + i*" + im);
        count++;
    }
 
    public Complex suma(Complex num)
    {
        Complex result = new Complex(num.re + re, num.im + im);
        return result;
    }
 
    public void printCount()
    {
        System.out.println(count);
    }
 
}