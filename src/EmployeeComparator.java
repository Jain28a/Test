public class EmployeeComparator implements java.util.Comparator<Employee> 
    {
        @Override
        public int compare(Employee a, Employee b)  
        {
            return a.empid - b.empid;
        }
    }
    

