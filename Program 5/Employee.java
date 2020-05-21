/***********************************************************************************
William Mastronardi CSC205 25993
This method abstracts the employee class, which will be used as framework for all 
other pieces of the program 5 puzzle, every piece of Program will 5 will contain
all data members found within the Employee class.
***********************************************************************************/
public abstract class Employee {
   private int _salary;
   private int _yearsInBaseball;
   private String _name;
   
   public Employee(int salary, int yearsInBaseball, String name) {
      _name = name;
      _salary = salary;
      _yearsInBaseball = yearsInBaseball;
   }
   
   public int getSalary() {
      return _salary;
   }
   
   public int getYearsInBaseball() {
      return _yearsInBaseball;
   }
   
   public String getName() {
      return _name;
   }
   
   public void yearlyUpdate() {
      _yearsInBaseball++;
   }
   
   public String toString() {
      return "\nName: " + _name + "\nYears in baseball: " + _yearsInBaseball
             + "\nSalary: " + _salary;
   }
}