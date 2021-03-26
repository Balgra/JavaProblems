class Information
{
    public String info;
    public int count;

    public Information(String info)
    {
        this.info = info;
        count = 1;
    }

   // @Override
    public String toString() 
    {
        return info + " " + count;
    };
}

class Text
{
    private Information[] items;
    private int counting;

    public Text() 
    {
        items = new Information[20];
        counting = 0;
    }

    public boolean addWord(String word)
     {
        for (int i = 0; i < counting; i++) 
        {
            if (items[i].info.equals(word)) 
            {
                items[i].count++;
                return true;
            }
        }
        if (counting >= 20)
        {
            return false;
        }

        items[counting++] = new Information(word);
        return true;
    }

    @Override
    public String toString() 
    {
        String content = "";

        for (int i = 0; i < counting; i++)
        {
            content += items[i].toString() + " ";
        }
        return content;
    };

}

class Main 
{
    public static void main(String[] args) 
    {
        Text text = new Text();
        text.addWord("flori");
        text.addWord("guma");
        text.addWord("word1");
        text.addWord("makeword");
        text.addWord("flori");
        text.addWord("makeword");
        text.addWord("guma");
        System.out.println("the Items given and the numbers are : " + text);
    }
}
