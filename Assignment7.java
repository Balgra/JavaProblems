interface Collection{

}

interface Strategy{
	public boolean isCondition(Employee employee);
}


class StrategyClass1 implements Strategy{
	protected String name;
	public StrategyClass1(String n){
		this.name = n;
	}
	public boolean isCondition(Employee employee){
		return this.name.equals(employee.name);
	}
}
class StrategyClass2 implements Strategy{
	public boolean isCondition(Employee employee){
		double salary = employee.getSalary();
		return Double.compare(salary, 1000) == 0;
	}
}

abstract class Employee implements Collection{
	protected String name;
	protected String ID;

	public Employee(String n, String cnp){
		this.name = n;
		this.ID = cnp;
	}

	abstract public double getSalary();

	public boolean equals(Employee employee){
		return this.name.equals(employee.name) && this.ID.equals(employee.ID);
	}

	public String toString(){
		return this.name + " " + this.ID + " " + String.valueOf(this.getSalary());
	}
}

class PermanentEmployee extends Employee{
	protected double salary;

	public PermanentEmployee(String n, String cnp,double s){
		super(n, cnp);
		this.salary = s;
	}

	public double getSalary(){
		return this.salary;
	}
}

class HourlyPaidEmployee extends Employee{
	protected int workedHours;
	protected double hourlyRate;

	public HourlyPaidEmployee(String n, String cnp, double rate){
		super(n,cnp);
		this.hourlyRate = rate;
	}

	public void setWorkedHours(int hours){
		this.workedHours = hours;
	}

	public double getSalary(){
		return this.workedHours * this.hourlyRate;
	}
}


class Company{
	private Collection[] employees;
	private int size;
	private int capacity;

	public Company(){
		this.size = 0;
		this.capacity = 100;
		this.employees = new Collection[this.capacity];
	}

	public void addEmployee(Employee employee){
		if(this.size == this.capacity){
			System.out.println("Employee list is full!");
			return;
		}

		for(int i = 0; i < this.size; ++i){
			if(this.employees[i].equals(employee)){
				System.out.println("This employee already exists!");
				return;
			}
		}

		this.employees[this.size] = employee;
		this.size++;
	}
	public void printEmployees(){
		for(int i = 0 ; i < this.size; ++i){
			System.out.println(this.employees[i]);
		}
	}

	public boolean isInCompany(Strategy strategy){
		for(int i = 0; i<this.size;++i){
			if(strategy.isCondition((Employee)this.employees[i]) == true)
				return true;
		}
		return false;
	}

}


class Main{
	public static void main(String[] args){
		Company c = new Company();
		PermanentEmployee e1 = new PermanentEmployee("Balgra", "123469", 1000000.1);
		HourlyPaidEmployee e2 = new HourlyPaidEmployee("Amir", "1239", 4200.1);
		e2.setWorkedHours(70);
		PermanentEmployee e3 = new PermanentEmployee("Luigi", "109090", 1000.0);
		
		StrategyClass1 s1 = new StrategyClass1("Amirz");
		StrategyClass2 s2 = new StrategyClass2();

		c.addEmployee(e1);
		c.addEmployee(e2);
		c.addEmployee(e3);

		c.printEmployees();

		System.out.println(c.isInCompany(s1));
		System.out.println(c.isInCompany(s2));
	}
}