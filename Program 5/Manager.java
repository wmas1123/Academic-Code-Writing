/***********************************************************************************
William Mastronardi CSC205 25993
This class will be an extension of the Employee class, used to store data for an 
on-field baseball manager.
***********************************************************************************/
public class Manager extends Employee {
   private int _careerWins;
   private int _careerGames;
   
   public Manager(int careerGames, int careerWins, int salary, int yearsInBaseball, String name) {
      super(salary, yearsInBaseball, name);
      _careerGames = careerGames;
      _careerWins = careerWins;
   }
   
   public int getCareerWins() {
      return _careerWins;
   }
   
   public int getCareerGames() {
      return _careerGames;
   }
   
   public void yearlyUpdate(int games, int won) {
      super.yearlyUpdate();
      _careerGames += games;
      _careerWins += won;
   }
   
   public double getValue() {
      return _careerWins / _careerGames;
   }
      
   public String toString() {
      return super.toString() + "\nCareer Games: " + _careerGames + "\nCareer Wins: " + _careerWins;
   }
}