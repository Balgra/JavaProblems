interface Item{
 
    public String getContent();
}
 
class File implements Item{
    private String information;
 
    public File( String information)
    {   
        this.information = information;
    }

    public String getContent()
    {
        String myString = this.information;
        return myString;
    }
 
}
 
class Folder implements Item{
    private Item[] entries;
    private int nr_of_el = 0;


    public Folder(int size)
    {  
        entries = new Item[size];       
    }
 
    public void add(Item entity){
    	
       // File aux = new File(information);
        entries[nr_of_el] = entity; // check pt loc.
        nr_of_el++;
        
    }
 

    @Override
    public String getContent()
    {
        String my_String = ""; // de folosit string buffer.
        for( int i = 0 ; i < nr_of_el; i++ )
            {
                my_String += entries[i].getContent();
                my_String += "\n";
            }
        return my_String;
    }
 
 
}
 
 
class FolderMain{
    public static void main(String args[])
    {
        Folder my_Folder = new Folder(5);
        my_Folder.add(new Folder(4));
        my_Folder.add(new File("FDSA"));
        my_Folder.add(new File("FDSA1"));
        my_Folder.add(new File("FDSA2"));
        my_Folder.add(new File("123"));


        //Folder new_folder = new Folder(2,"dsadsad");
        System.out.println(my_Folder.getContent());
    }
}