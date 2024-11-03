import java.util.ArrayList;
/****************************************************************************
 * CS2043 - Project CourseList Class
 * @ author - Nicolas Serrano, Domenica Vasco and Taryn Cail
 * @ version - 1.0
 * @ date - October 30th, 2024
 ****************************************************************************/
public class GroupList
{
    // Instance Data
    private ArrayList<Group> groupList;

    // Constructor
    public GroupList()
    {
        groupList = new ArrayList<Group>();
    }

    // Search Method to find a specific group using the groupName
    Group searchForGroup(String thisGroupName)
    {
        for(int i = 0; i < groupList.size(); i++)
        {
            // If the group at i's name matches incoming groupName return it
            if(groupList.get(i).getGroupName().equalsIgnoreCase(thisGroupName))
            {
                return groupList.get(i);
            }
        }
        System.out.println("Group with that name not found");
        return null;
    }

    // Basic Methods
    public void addGroup(Group newGroup)
    {
        groupList.add(newGroup);
    }
}



