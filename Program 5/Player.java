/***********************************************************************************
William Mastronardi CSC205 25993
This class is an abstract class used to generalize many common functions between the
two kinds of players, batters and pitchers.
***********************************************************************************/
public abstract class Player extends Employee {
   
   private int _gamesPlayed;
   
   public Player(int gamesPlayed, int salary, int yearsInBaseball, String name) {
      super(salary, yearsInBaseball, name);
      _gamesPlayed = gamesPlayed;
   }
   
   public int getGamesPlayed() {
      return _gamesPlayed;
   }
   
   public void yearlyUpdate(int games) {
      _gamesPlayed += games;
      super.yearlyUpdate();
   }
   
   public String toString() {
      return super.toString() + "\nGames Played: " + _gamesPlayed;
   }
   
   public int getAtBats() {
      return 0;
   }
   
   public int getInnings() {
      return 0;
   }
   
   public int getHomeRuns() {
      return 0;
   }
   
   public int getEarnedRuns() {
      return 0;
   }
   
   public int getWalks() {
      return 0;
   }
   
   public int getHits() {
      return 0;
   }
   
   public int getHitsBatter() {
      return 0;
   }
   
   public abstract double getValue();
}