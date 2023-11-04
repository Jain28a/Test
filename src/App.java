import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            
            // Print reverse Array
            int[] firstArray = {3,6,9,12,15,18,21,24,27,30};
            printArray(firstArray);
            System.out.print("Reversed Array is ");
            reverseArray(firstArray);
            System.out.print("Reversed Array is ");
            printArray(firstArray);

            //Get 2 List of integers , merge and sort 
            listMergeAndSort();

            //Find Differential along with its event lype - 2 Lists of Employee object
            // if department was changed then print "Department Changed" if new entry is found then "New Employee" and
            // if missing entry in the new collection then "Employee Terminated"
            findDifferential();

            //Sort Employee object based on Accessding Employee ID 
            List<Employee> globalEmployee = Arrays.asList(
                new Employee (12, "Aparna Jain", 2),
                new Employee (21, "Atharva Jain", 3),
                new Employee (3, "Arnav Jain", 4)
            );

            sortEmployeeList(globalEmployee);
            printList(globalEmployee);
            } 
            catch (Exception e) { 
                System.out.print(e.getMessage() + e.getStackTrace());
            }
            finally
            {
            System.out.print("Execution completed !!!!!");
            }
        }

        static void printArray(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
                System.out.println();
            }
        }
        
        static void reverseArray(int arr[])
        {   int temp;
            if (arr.length > 0)
            {   int start = 0 ; int end = arr.length - 1;
                while(start < end)
                {
                    temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }
            }
        }

        static void listMergeAndSort (){

            List<Integer> list1 = new ArrayList<>();
            list1.add(5);
            list1.add(2);
            list1.add(9);

            List<Integer> list2 = new ArrayList<>();
            list2.add(7);
            list2.add(3);
            list2.add(1);

            List<Integer> mergedList = new ArrayList<>(list1);
            System.out.println("List1 elements " + mergedList);

            mergedList.addAll(list2);
            System.out.println("List1 & List2 elements " + mergedList);

            Collections.sort(mergedList);
            System.out.println("Merged and Sorted List: " + mergedList);

        }
        
        static void findDifferential()
        {
            List<Employee> old = Arrays.asList(
            new Employee (1, "Aparna Jain", 2),
            new Employee (2, "Atharva Jain", 3),
            new Employee (3, "Arnav Jain", 4)
        );

        List<Employee> newList = Arrays.asList(
            new Employee (1, "Aparna Jain", 2),
            new Employee (2, "Atharva Jain", 5),
            new Employee (4, "Aditya Jain", 6)
        );

            for(int counter=0; counter  < old.size(); counter ++)
            {
                if (old.get(counter).empid == newList.get(counter).empid)
                {
                    if (old.get(counter).empname == newList.get(counter).empname)
                    {
                        if (old.get(counter).departmentid != newList.get(counter).departmentid)
                        {   System.out.println("For "  + newList.get(counter).empname + " Department has Changed ! ");
                        }
                    }
                }
                else
                {   System.out.println("For "  + old.get(counter).empname + " Employee Terminated ! ");
                    System.out.println("For "  + newList.get(counter).empname + " New Employee ! ");
                }
            }
        }
        
        static void sortEmployeeList (List<Employee> listname)
        {
            Collections.sort(listname, new EmployeeComparator());
        }
        
        static void printList(List<Employee> listname)
     {
        for (int counter =0; counter < listname.size(); counter++)
        {
            Employee e = listname.get(counter);
            System.out.print( "Employee Id : " + e.empid + " Employee Name : " + e.empname +  " Department Id :  "+ e.departmentid  + "\n");
        }
     }
}
