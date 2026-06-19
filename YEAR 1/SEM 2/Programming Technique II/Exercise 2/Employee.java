package Exercise_week2;

public class Employee {
    private String empName;
    private int empAge;
    private String empID;
    private double empDepart;

    public void setEmpName(String name)
    {
        empName = name;
    }

    public String getEmpName()
    {
        return empName;
    }

    public void setEmpAge(int age)
    {
        empAge = age;
    }

    public int getEmpAge()
    {
        return empAge;
    }

    public void setEmpID(String id)
    {
        empID = id;
    }

    public String getEmpID()
    {
        return empID;
    }

    public void setEmpDepart(double depart)
    {
        empDepart = depart;
    }

    public double getEmpDepart()
    {
        return empDepart;
    }

    public void displayInfo()
    {
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee Age: " + empAge);
        System.out.println("Employee ID: " + empID);
        System.out.println("Employee Department: " + empDepart);
    }
}
