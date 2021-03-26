import java.io.File;
import java.util.Scanner;

abstract class ReadFile {

    public void ReadFile() {

        try {
            System.out.print("Enter the file name with extension : ");

            Scanner input = new Scanner(System.in);

            File file = new File(input.nextLine());

            input = new Scanner(file);


            while (input.hasNextLine())
             {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}

class Dosomething extends ReadFile{

	public Dosomething(){

	}

}



class Main{
	public static void main(String[] args){
		System.out.println("SDF");

		ReadFile citire= new Dosomething();

		citire.ReadFile();
	}
}


