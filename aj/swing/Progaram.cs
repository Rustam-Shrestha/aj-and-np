using System; 
using System.Collections.Generic; 
using System.Linq; 
public class Employee
{

 public int Id { get; set; } // Property to store employee ID
 public string Name { get; set; } // Property to store employee name
 public int Age { get; set; } // Property to store employee age
 public double Salary { get; set; } // Property to store employee salary
 public string Address { get; set; } // Property to store employee address
}
class Program
{
 static void Main()
 {
 // Creating a list of 5 employees
 List<Employee> employees = new List<Employee>
 {
 new Employee { Id = 1, Name = "Ramesh", Age = 30, Salary = 50000, 
Address = "Address 1" },
 new Employee { Id = 2, Name = "Suresh", Age = 22, Salary = 40000, 
Address = "Address 2" },
 new Employee { Id = 3, Name = "Ravi", Age = 28, Salary = 45000, 
Address = "Address 3" },
 new Employee { Id = 4, Name = "Amit", Age = 25, Salary = 35000, 
Address = "Address 4" },
 new Employee { Id = 5, Name = "Rajesh", Age = 32, Salary = 60000, 
Address = "Address 5" }
 };
 // LINQ query to filter employees
 var result = employees
 .Where(e => e.Name.StartsWith("R") && e.Age > 25).OrderByDescending(e => e.Age) .Select(e => new { e.Name, e.Address }); 
 // Displaying the filtered employees
 Console.WriteLine("Employees whose names start with 'R' and are older than 25 (sorted by age):");
 foreach (var employee in result) // Iterating through the filtered 
employees
 {
 Console.WriteLine($"Name: {employee.Name}, Address: {employee.Address}"); // Displaying employee details
 }
 // LINQ query to select the employee with the maximum salary
 var maxSalaryEmployee = employees.OrderByDescending(e => e.Salary).FirstOrDefault(); salary)
 // Displaying the employee with the maximum salary
 if (maxSalaryEmployee != null) // Checking if an employee was found
 {
 Console.WriteLine("\nEmployee with the maximum salary:");
 Console.WriteLine($"Name: {maxSalaryEmployee.Name}, Salary: {maxSalaryEmployee.Salary}, Address: {maxSalaryEmployee.Address}"); // Displaying employee details
 }
 }
}
