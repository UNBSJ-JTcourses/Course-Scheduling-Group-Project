import java.io.*;

class FileManager
{
    public static void save(GroupList o)
    {

        FileOutputStream fos = null;
        ObjectOutputStream outfile = null;

        try {
            fos = new FileOutputStream("OutputFile.dat");
            outfile = new ObjectOutputStream(fos);
            outfile.writeObject(o);
        } catch (IOException e) {
            System.out.println("Problem saving the file");
        } finally {
            try {
                if (outfile != null)
                    outfile.close();
            } catch (IOException e) {
                System.out.println("Problem closing the file");
            }
        }
    }

    public static void read(GroupList g)
    {
        GroupList myList = new GroupList();
        FileInputStream fis = null;
        ObjectInputStream infile = null;

        try
        {
            fis = new FileInputStream("OutputFile.dat");
            infile = new ObjectInputStream(fis);
            myList = (GroupList) infile.readObject();
            g.setGroupList(myList.getGroupList());
        }
        catch (IOException e)
        {
            System.out.println("Problem reading the file");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Problem parsing the file");
        }
        finally
        {
            try
            {
                if (infile != null)
                    infile.close();
            }
            catch (IOException e)
            {
                System.out.println("Problem closing the file");
            }
        }
    }
}
