abstract class Carriage{

		protected int packetCapacity;
}

abstract class PassengerCar extends Carriage{

	protected int passengerCapacity;

	public void openDoors(){
		System.out.println("doors open");
	}

	public void closeDoors(){
		System.out.println("doors closed");
	}
}

class PassengerCarA extends PassengerCar{

	public PassengerCarA()
	{
		this.passengerCapacity=40;
		this.packetCapacity=300;
	}
}

class PassengerCarB extends PassengerCar{

	public PassengerCarB()
	{
		this.passengerCapacity=40;
		this.packetCapacity=300;
	}
}

class LoadCar extends Carriage{

	public LoadCar()
	{
		packetCapacity=400;
	}
}


class Train extends Carriage{
	private Carriage[] carriages;
	private int size;

	public Train(Carriage ...car){
		this.carriages=new Carriage[15];
		this.size=0;
		for(Carriage i: car){
			this.carriages[this.size++]=i;
		}
	}

	public boolean equals(Train train)
	{
		int cap1=0, cap2=0;
		for(int i=0;i<this.size; ++i){
			if(this.carriages[i] instanceof PassengerCarA)
				cap1=cap1+300;
			else
				cap1=cap1+400;
		}

		for(int i=0; i< train.size; ++i){
			if(train.carriages[i] instanceof PassengerCarA)
				cap2=cap2+300;
			else
				cap2=cap2+400;
		}
		return cap1==cap2;
	}

	public String toString(){
		String out="";
		for(int i=0; i<this.size; ++i){
			if(this.carriages[i] instanceof PassengerCarA)
				out=out+"PassengerCarA";
			if(this.carriages[i] instanceof PassengerCarB)
				out=out+"PassengerCarB";
			if(this.carriages[i] instanceof LoadCar)
				out=out+"LoadCar";

			out=out+" ";
		}

		return out;
	}


}

class Main
{
	public static void main(String[] args){

		PassengerCarA a1=new PassengerCarA();
		PassengerCarA a2=new PassengerCarA();
		PassengerCarB b1=new PassengerCarB();
		PassengerCarB b2=new PassengerCarB();
		a1.closeDoors();
		b2.openDoors();
		LoadCar c1=new LoadCar();
		LoadCar c2=new LoadCar();

		Train t1=new Train(a1,b1,b2);
		Train t2=new Train(a2,c1,c2);
		Train t3=new Train(a1);

		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t1.equals(t2));
		System.out.println(t1.equals(t3));


	}
}





