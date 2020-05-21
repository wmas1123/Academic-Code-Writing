/***********************************************************************************
William Mastronardi CSC205 25993
This class is used to store the basic data for a baseball batter, such as at bats,
hits, and home runs. This basic information will be used to calculate some more complex
statistics, such as the batting average or the value of the player.
***********************************************************************************/
public class Batter extends Player {
   private int _atBats;
   private int _hitsBatter;
   private int _homeRuns;
   
   public Batter(int gamesPlayed, int salary, int yearsInBaseball, String name, int homeRuns, 
                  int atBats, int hits) {
      super(gamesPlayed, salary, yearsInBaseball, name);
      _homeRuns = homeRuns;
      _atBats = atBats;
      _hitsBatter = hits;
   }
   
   public void yearlyUpdate(int games, int homeRuns, int hits, int atBats) {
      super.yearlyUpdate(games);
      _homeRuns += homeRuns;
      _hitsBatter += hits;
      _atBats += atBats;
   }
   
   public int getHomeRuns() {
      return _homeRuns;
   }
   
   public int getHitsBatter() {
      return _hitsBatter;
   }
   
   public int getAtBats() {
      return _atBats;
   }
   
   public String toString() {
      return super.toString() + "\nPlayer Position: Batter\nAt Bats: " + _atBats
             + "\nHits: " + _hitsBatter + "\nHome Runs: " + _homeRuns + "\nPlayer Value: " + getValue();

   }
   
   public double getBattingAverage() {
      return _hitsBatter / _atBats;
   }
   
   public double getValue() {
      return (getBattingAverage() - 0.248) / 0.248 + (_homeRuns - 20) / 20;
   }
}