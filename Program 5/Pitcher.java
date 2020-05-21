/***********************************************************************************
William Mastronardi CSC205 25993
This class is used to store data based on a Pitcher for a baseball team. This class
will use basic data (innings pitched, walks, hits, earned runs) to calculate some 
more complex data such as the earned run average (ERA), or the Walks plus Hits per
Innings Pitched (WHIP) and the player value.
***********************************************************************************/
public class Pitcher extends Player {
   private int _innings;
   private int _earnedRuns;
   private int _walks;
   private int _hits;
   
   public Pitcher(int gamesPlayed, int salary, int yearsInBaseball, String name, int innings,
                  int earnedRuns, int walks, int hits) {
      super(gamesPlayed, salary, yearsInBaseball, name);
      _innings = innings;
      _earnedRuns = earnedRuns;
      _walks = walks;
      _hits = hits;
   }
   
   public void yearlyUpdate(int games, int innings, int earnedRuns, int walks, int hits) {
      super.yearlyUpdate(games);
      _innings += innings;
      _earnedRuns += earnedRuns;
      _walks += walks;
      _hits += hits;
   }
   
   public int getInnings() {
      return _innings;
   }
   
   public int getEarnedRuns() {
      return _earnedRuns;
   }
   
   public int getWalks() {
      return _walks;
   }
   
   public int getHits() {
      return _hits;
   }
   
   public double getERA() {
      return (double)(_earnedRuns * 9) / _innings;
   }
   
   public double getWHIP() {
      return (_walks + _hits) / _innings;
   }
   
   public double getValue() {
      return -(4.51 - getERA()) / 4.51 + (1.32 - getWHIP()) / 1.32;
   }
   
   public String toString() {
      return super.toString() + "\nPlayer Position: Pitcher\nInnings Pitched: " + _innings
             + "\nEarned Runs: " + _earnedRuns + "\nWalks: " + _walks + "\nHits: " + _hits
             + "\nPlayer Value: " + getValue();
   }
      
}