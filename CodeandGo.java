
import java.util.ArrayList;

class User
{
	String prenume;
	String nume;
	String domeniu;

	public User(String prenume, String nume, String domeniu)
	{
		this.prenume=prenume;
		this.nume=nume;
		this.domeniu=domeniu;
	}

	public String getemail()
	{
		return prenume+"."+nume+"@"+domeniu;
	}
}


public class CodeandGo

{
		public static void main(String[] args)
		{
			/*System.out.println("SD");
			int a=5;
			int b=5;

			String text=a + " " + b;
			System.out.println(a + b);
			System.out.println(text);

			String prenume = "Andrei";
			String nume= "Statestcu";
			String domeniu = "dexsoftware.net";

			text=prenume+"."+nume+"@"+domeniu;

			System.out.println(text);


			User u= new User();

			u.prenume="ion";
			u.nume="popescu";
			u.domeniu="student.upt.rp";

			String text1=u.prenume+"."+u.nume+"@"+u.domeniu;

			System.out.println(text1);*/

		/*User user1= new User();

			user1.prenume="Andrei";
			user1.nume="Bălgradean";
			user1.domeniu="student.upt.ro";

			System.out.println(user1.getemail());*/

		//	User u1= new User("ion","popesc","student.upt.ro");
			//User u2= new User("sd","SD","student.upt.ro");

			///System.out.println(u1.getemail());

			//lista in Java;

			//String[] a= new String[100]; pt vectori/ siruri

			//ArrayList<String> nume= new ArrayList<>();

			/*nume.add("SDF");
			nume.add("SDF12");
			nume.add("SDFfad");
			System.out.println(nume.get(1));
			System.out.println(nume.contains("SDF"));
			System.out.println(nume.size());

			nume.remove("SDF");
			System.out.println(nume.size());*/


			User u1= new User("ion","popesc","student.upt.ro");
			User u2= new User("sd","SD","student.upt.ro");
			User u3= new User("Andrei","Andrei","dustd");

			ArrayList<User> utilizatori= new ArrayList<>();

			utilizatori.add(u1);
			utilizatori.add(u2);
			utilizatori.add(u3);
			System.out.println(utilizatori.size());

			for(User u : utilizatori)
			{
				// u este defapt utilizatori.get(i);
 				System.out.println(u.getemail());

			}

			//create a new list 

			ArrayList<User> utilAndrei= new ArrayList<>();

			for(User uti : utilizatori)
			{
				if(uti.prenume=="Andrei");
				{
					utilAndrei.add(uti);
				}

				//System.out.println(utilAndrei.size());
			}
			System.out.println(utilAndrei.get(0));
		}

}