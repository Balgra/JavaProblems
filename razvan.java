
class Student{
 
	public String name="Andrei";
	public String id="1230";
  	int practical,exam;
  	float finalmark;

	public Student(int practical, int exam){
		this.practical=practical;
		this.exam=exam;
	}

	public int finalMark()
	{
		return (exam+practical)/2; 
	}

	@Override
	public String toString(){

		String out="";
		finalmark=finalMark();
		System.out.println(name+ " " +id +" "+ finalmark);
		return out;

	}


}

class Stud extends Student{

	public Stud(int practical, int exam)
	{
		super(practical,)
	}
}

class Main{
	public static void main(String[] args){

		Student student= new Student(5,5);

		System.out.println(student);
	}
}