import java.util.Iterator;
import java.util.ArrayList;

abstract class Type{
	abstract public String getType();
	abstract public String toString();
}

class IntegerType extends Type{
	protected int value;

	public IntegerType(int v){
		this.value = v;
	}

	public String getType(){
		return "Type: Integer";
	}
	public String toString(){
		return Integer.toString(this.value);
	} 
	public boolean equals(IntegerType i){
		return Integer.compare(i.value,this.value)==0;
	}
}

class StringType extends Type{
	protected String value;

	public StringType(String v){
		this.value = v;
	}

	public String getType(){
		return "Type: String";
	}
	public String toString(){
		return this.value;
	} 
	public boolean equals(StringType s){
		return this.value.equals(s);
	}
}

class CollectionType extends Type{

	protected ArrayList<Type> collection = new ArrayList<Type>();

	public String toString(){
		String output = "(";
		boolean ok = false;
		Iterator<Type> it = this.collection.iterator();
		while(it.hasNext()){
			ok = true;
			output = output + it.next().toString() + ",";
		}
		if(ok)
			output = output.substring(0,output.length()-1);
		
		output = output + ")";
		return output;
	}

	public String getType(){
		String output = "Type:CollectionType(";
		boolean ok = false;
		Iterator<Type> it = this.collection.iterator();
		while(it.hasNext()){
			ok = true;
			output = output + it.next().getType();
		}
		if(ok)
			output = output.substring(0,output.length()-1);
		output = output + ")";
		return output;
	}

	public void addElement(Type element){
		this.collection.add(element);
	}

	public boolean equals(CollectionType c){
		if(this.collection.size() != c.collection.size())
			return false;
		else{
			Iterator<Type> it1 = this.collection.iterator();
			Iterator<Type> it2 = c.collection.iterator();
			while(it1.hasNext() && it2.hasNext())
				if(!it1.next().equals(it2.next()))
					return false;
			return true;
		}
	}
}

class Main{
	public static void main(String[] args){
		CollectionType c1 = new CollectionType();
		CollectionType c2 = new CollectionType();
		CollectionType c3 = new CollectionType();

		IntegerType i1 = new IntegerType(1);
		IntegerType i2 = new IntegerType(2);
		IntegerType i3 = new IntegerType(3);

		StringType s1 = new StringType("unu");
		StringType s2 = new StringType("doi");

		c1.addElement(i1);
		c1.addElement(s1);

		c2.addElement(i1);
		c2.addElement(s1);
		c2.addElement(i2);


		c3.addElement(i1);
		c3.addElement(s1);
		c3.addElement(i3);

		System.out.println(c2.equals(c1));
		System.out.println(c2.equals(c3));
		System.out.println(c1.equals(c3));
	}
}