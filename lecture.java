
/*
class Unboxing{
	public static void tiparesteIntreg(Integer x){
		System.out.println(5+x);
	}
}









class Main{
	public static void main(String[] args){
		System.out.println("SDF");
		Unboxing x= new Unboxing();
		x.tiparesteIntreg(5);
	}	
}*/

/*

class Device{

	protected String information;

	public Device(){
		information="";
	}

	public Device(String information){

		this.information=information;
	}

	public void store(String information){
		//System.out.println(information);
		this.information=information;
	}

	public String load(){
		return this.information;
	}


}


class PhotoDevice extends Device{

	public PhotoDevice(String information){
		super(information);
	}

	public void takePicture(){
		System.out.println("Taking picture");
		String picture = information;
		this.store(picture);
	}


}

class VideoDevice extends Device{

	public String producer;

	public VideoDevice(String information, String producer){
		super(information);
		this.producer=producer;
	}

	public void film(){
		System.out.println("Filmul este");
		String film = information;

		this.store(film);
	}


}
/*
abstract class Myabstract{

	public abstract void print1();
	public abstract void print2();
	public void print3(){
		System.out.println("coaie");
	};
}

class Mysubabstract extends Myabstract{

	public String info;
	public Mysubabstract(String info){
		this.info=info;
	}
	public void print1(){
	 	System.out.println(this.info); // daca e abstract trebuie implementata daca nu e safe.
	}

	public void print2(){
	 	System.out.println("SDF"+this.info);
	}

}*/

//class Main{

	//public static void main(String[] args){

		//Device a= new Device("Aparat photo");
		//Device a1= new Device("Masina virtuala");
		//Device a2= new Device();
		//Device a3= new PhotoDevice("Alune");
		//Device a4= new VideoDevice("SAW 4 ","Motorola");

		/*System.out.println(a.load());
		System.out.println(a1.load());
		System.out.println(a2.load());*/ 
		//((PhotoDevice)a3).takePicture(); //typecasting. !!!!
		//System.out.println("A picture of " + a3.load());
		//((VideoDevice)a4).film();
		//System.out.println("the film "+ a4.load());


		/*(Mysubabstract obiect= new Mysubabstract("ASD");

		obiect.print1();
		obiect.print2();*/




	//}
//}*/







/*

abstract class UnitateLupta{

	public abstract void ranire(int value);

	public abstract void loveste(UnitateLupta unitate);

	public abstract boolean esteVie();
}


abstract class UnitateSimpla extends UnitateLupta{

	private int viata, putere;

	public UnitateSimpla(int viata, int putere){
		this.viata=viata;
		this.putere=putere;
	}

	public void ranire(int valoare){
		if(esteVie()){
			viata=viata-valoare;
		}
	}

	public void loveste(UnitateLupta unitate){
		
		if(esteVie()){
			unitate.ranire(putere);
		}
	}

	public boolean esteVie(){
		
		if(viata>0){
			return true;
		}
		else{
			return false;
		}
	}
}

class Arcas extends UnitateSimpla{

	private static final int Viata_Arcas=100;
	private static final int Putere_Arcas=10;

	public Arcas(){
		super(Viata_Arcas,Putere_Arcas);
	}
}

class Calaret extends UnitateSimpla{

	private static final int Viata_Calaret=200;
	private static final int Putere_Calaret=15;

	private static int nr_cai=0;

	public Calaret(){
		super(Viata_Calaret,Putere_Calaret);
	}

	public static int getNrCaiPierduti(){
		return nr_cai;
	}

	public void ranire(int valoare){

		boolean intainte_de_ranire=this.esteVie();
		super.ranire(valoare);
		boolean dupa_ranire=this.esteVie();
		if((intainte_de_ranire==true)&&(dupa_ranire==false)){
			nr_cai++;
		}
	}
}


class Pluton extends UnitateLupta{

	private UnitateLupta[] membri=new UnitateLupta[10];
	private int nr_membri=0;

	public void ranire(int valoare){

		for(int i=0;i<nr_membri;i++){

			if(membri[i].esteVie()){

				membri[i].ranire(valoare);
				break;
			}
		}
	}

	public void loveste(UnitateLupta unitate){
		for(int i=0;i<nr_membri;i++){
			membri[i].loveste(unitate);
		}
	}

	public boolean esteVie(){
		if(nr_membri==0){
			return true;
		}

		for(int i=0; i<nr_membri; i++){
			if(membri[i].esteVie()){
				return true;
			}
		}

		return false;
	}

	public boolean adauga(UnitateLupta unitate){
		if(!unitate.esteVie()||!this.esteVie()){
			return false;
		}
		if(nr_membri==membri.length){
			UnitateLupta[] tmp= new UnitateLupta[membri.length+10];
			for(int i=0;i<membri.length;i++){
				tmp[i]=membri[i];
			}
			membri=tmp;
		}

		membri[nr_membri]=unitate;
		nr_membri++;
		return true;
	}

}

class Main{

	public static void main(String argv[]){

		Pluton pluton1,pluton2,pluton3;

		pluton1=new Pluton();
		pluton1.adauga(new Arcas());
		pluton1.adauga(new Arcas());
		pluton1.adauga(new Arcas());
		pluton1.adauga(new Arcas());
		pluton1.adauga(new Arcas());
		pluton1.adauga(new Arcas());

		pluton3=new Pluton();
		pluton3.adauga(new Arcas());
		pluton3.adauga(new Arcas());

		pluton2=new Pluton();

		pluton2.adauga(new Calaret());
		pluton2.adauga(new Calaret());
		pluton2.adauga(pluton3);

		boolean loveste_primul = (Math.random()>0.5);

		while(pluton1.esteVie() && pluton2.esteVie()){
			if(loveste_primul){
				System.out.println("Loveste Pluton1");
				pluton1.loveste(pluton2);
			}
			else{
				System.out.println("Loveste Pluton2");
				pluton2.loveste(pluton1);
			}
			loveste_primul=!loveste_primul;
		}

		System.out.println("Pluton1 este viu:" + pluton1.esteVie());
		System.out.println("Pluton2 este viu:" + pluton2.esteVie());
		System.out.println("A castigat:" + (pluton1.esteVie() ? "pluton1" :pluton2.esteVie() ? "pluton2" : "nimeni"));
		System.out.println("Numar cai decedati:" + Calaret.getNrCaiPierduti());

	}
}*/


/*
interface Expresie {
	Expresie calculDerivata();
}


class Constanta implements Expresie {

		private double valoare;
		public Constanta(double valoare) {
		this.valoare = valoare;
		}

		public Expresie calculDerivata() {
		return new Constanta(0);
		}

		public String toString() {
		return valoare + "";
		}
}

class Variabila implements Expresie {

		public Expresie calculDerivata() {
		return new Constanta(1);
		}
		public String toString() {
		return "x";
		}
}

abstract class ExpresieBinara implements Expresie {

		protected Expresie st,dr;

		public ExpresieBinara(Expresie st, Expresie dr) {
		this.st = st;
		this.dr = dr;
		}
}

class Suma extends ExpresieBinara {

		public Suma(Expresie st, Expresie dr) {
		super(st,dr);
		}
		public Expresie calculDerivata() {

		return new Suma(st.calculDerivata(),dr.calculDerivata());
		}

		public String toString() {
		return "(" + st.toString() + " + " + dr.toString() + ")";
		}
}

class Inmultire extends ExpresieBinara {

		public Inmultire(Expresie st, Expresie dr) {
				super(st,dr);
		}

		public Expresie calculDerivata() {
			Expresie t1 = new Inmultire(st,dr.calculDerivata());
			Expresie t2 = new Inmultire(st.calculDerivata(),dr);
			return new Suma(t1,t2);
		}

		public String toString() {
				return "(" + st.toString() + " * " + dr.toString() + ")";
		}
}


class Main {
	public static void main(String[] args) {

		Constanta c1 = new Constanta(1);
		Variabila v1 = new Variabila();
		Variabila v2 = new Variabila();
		Inmultire i1 = new Inmultire(v1,v2);
		Suma exp = new Suma(c1,i1);
		System.out.println("The expresion is "+exp);
		Expresie deriv1 = exp.calculDerivata();
		System.out.println("The derivative is"+deriv1);
		Expresie deriv2 = deriv1.calculDerivata();
		System.out.println("The derivative of the derivative"+deriv2);
	}
}
*/

/*

import java.util.*;
abstract class Student {
    protected String name;
    protected double grade;
    protected int year;
 
    public Student(String n, double g, int y){
        this.name = n; this.grade = g; this.year = y;
    }
 
    public abstract double getGrade();
 
    public String toString(){
        return " Name: " + name + " Grade: " + getGrade()+ " Year: "+ year + "\n";
    }
 
    public boolean equals(Object o){
        if(o instanceof Student)
            return ((Student) o).name.equals(name)&&((Student) o).year ==year;
        return false;
    }
 
    public String getName(){
        return name;
    }
}
class Erasmusstudent extends Student{
    public Erasmusstudent(String n,double g, int y){
        super(n,g,y);
    }
    public double getGrade(){
        return grade*10;
    }
}
class RegularStudent extends Student{
    public RegularStudent(String n, double g, int y){
        super(n,g,y);
    }
    public double getGrade()
    {
        return grade;
    }
}
class University{
    private String name;
    private List<Student> students;
 
    public University(String name){
        this.name = name;
        this.students = new ArrayList<>(5);
    }
    public void addStudent(Student student) throws StudentsAlreadyExistsException{
        if(!students.contains(student))
            students.add(student);
        else
            throw new StudentsAlreadyExistsException(student.getName());
    }
    public String toString(){
        return "University "+name+"has students "+students;
    }
}
class StudentsAlreadyExistsException extends RuntimeException{
    public StudentsAlreadyExistsException(String studentName){
        super("Student "+studentName+" already exists in university");
    }
}
class Main{
    public static void main(String[] args) {
        University university = new University("UP");
                    for(int i=0;i<10;i++){
                        if(i%2==0)
                            university.addStudent(new Erasmusstudent("Student",i+1,i));
                        else
                            university.addStudent(new RegularStudent("Student",i+1,i-1));
                    }
                
                System.out.println(university);
    }
}*/

import java.util.*;


abstract class Teacher{
	protected String name;
	protected double salary;

	public Teacher(String name){
		this.name=name;
		this.salary=getSalary();
	}
	public abstract double getSalary();

	public String toString(){
		return "Name" + name + "\n" + "Salary" + salary;
	}

	public boolean equals(Object o){
		if (o instanceof Teacher){
			return ((Teacher)o).name.equals(name);
		}
		return false;
	}
}

class HourlyPaidTeacher extends Teacher{

	private static int workedHours=20;

	public HourlyPaidTeacher(String name){
		super(name);
	}

	public double getSalary(){
		return workedHours*20;
	}
	public int getworkedHours(){
		return workedHours;
	}
}

class PermanentTeacher extends Teacher{
	public PermanentTeacher(String name){
		super(name);
	}

	public double getSalary(){
		return 3200.5;
	}
}

class University{
	private String name;
	private List<Teacher> teachers;

	public University(String name){
		this.name=name;
		teachers= new ArrayList<>(2);
	}

	public void addTeacher(Teacher teacher){
		if(!teachers.contains(teacher)){
			teachers.add(teacher);
		}
		else{
			throw new TeacherAlreadyAddedException(teacher.name);
		}
	}
	public String toString(){
		return name+ " " + teachers;
	}
}

abstract class AlreadyAddedException extends RuntimeException{
	public AlreadyAddedException(String entity){
		super(entity+"already added");
	}
}

class TeacherAlreadyAddedException extends AlreadyAddedException{
	public TeacherAlreadyAddedException(String name){
		super("Teacher"+name);
	}
}


class Main{

	public static void main(String[] args){
		
		Teacher t1= new PermanentTeacher("Mike");
		Teacher t2= new PermanentTeacher("Joie");
		Teacher t3= new HourlyPaidTeacher("Raphael");
		Teacher t4= new HourlyPaidTeacher("Johnny");
		Teacher t5= new HourlyPaidTeacher("Mike");
		University university = new University("UPT");
		try{

			university.addTeacher(t1);
			university.addTeacher(t2);
			university.addTeacher(t3);
			university.addTeacher(t4);
			university.addTeacher(t5);
		}catch(AlreadyAddedException e){
			System.out.println(e);
		}

		System.out.println(university);
		System.out.println(((HourlyPaidTeacher)t3).getworkedHours());
		//System.out.println(t3.getworkedHours());
	}

}