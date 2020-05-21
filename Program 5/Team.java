/***********************************************************************************
William Mastronardi CSC205 25993
This class will use the Java ArrayList class to store data of a team, creating one 
manager either based on parameters passed to the constructor or defaulting a manager
if no parameters are sent. This class will also instances of the manager and the abstract
player classes to create a baseball team. 
***********************************************************************************/
import java.util.*;

public class Team {
   private ArrayList<Player> team;
   private Manager _manager;
   private int batters;
   private int pitchers;
   private int size;
   
   public Team() {
      team = new ArrayList<Player>();
      _manager = new Manager(0, 0, 0, 0, "DEFAULT");
      batters = 0;
      pitchers = 0;
      size = 0;
   }
   
   public Team(Manager manager) {
      team = new ArrayList<Player>();
      batters = 0;
      pitchers = 0;
      size = 0;
      _manager = manager;
   }
   
   public void replaceManager(Manager manager) {
      _manager = manager;
   }
   
   public void addBatter(Batter batter) {
      batters++;
      team.add(batter);
      size++;
   }
   
   public void addPitcher(Pitcher pitcher) {
      pitchers++;
      team.add(pitcher);
      size++;     
   }

   public double getTeamBattingAverage() {
      int hits = 0;
      int atBats = 0;
      for(int i = 0; i < size; i++) {
         hits += team.get(i).getHitsBatter();
         atBats += team.get(i).getAtBats();
      }
      if(atBats > 0)
         return (double)hits / atBats;
      else 
         return 0;
   }
   
   public int getHomeRuns() {
      int homeRuns = 0;
      for(int i = 0; i < size; i++) {
         homeRuns += team.get(i).getHomeRuns();
      }
      return homeRuns;
   }
   
   public double getERA() {
      int earnedRuns = 0;
      int innings = 0;
      for(int i = 0; i < size; i++) {
         earnedRuns += team.get(i).getEarnedRuns();
         innings += team.get(i).getInnings();
      }
      double earnedRunAverage  = (double)(earnedRuns * 9) / innings;
      return earnedRunAverage;   
   }
   
   public double getWHIP() {
      int walks = 0;
      int hits = 0;
      int innings = 0;
      for(int i = 0; i < size; i++) {
         walks += team.get(i).getWalks();
         hits += team.get(i).getHits();
         innings += team.get(i).getInnings();
      }
      return (walks + hits) / innings;
   }
   
   public int getSalary() {
      int salary = _manager.getSalary();
      for(int i = 0; i < size; i++)
         salary += team.get(i).getSalary();
      return salary;
   }
   
   public double getValue() {
      double totalValue = 0;
      for(int i = 0; i< size; i++)
         totalValue += team.get(i).getValue();
      double teamValue = totalValue / (size + 1);
      return teamValue;
   }
   
   public Manager getManager() {
      return _manager;
   }
   
   public int getBatters() {
      return batters;
   }
   
   public int getPitchers() {
      return pitchers;
   }
   
   public int getNumberOfPlayers() {
      return team.size();
   }
   
   public Player findPlayerByName(String name) {
      int index = findPlayerIndex(name);
      if(index >= 0)
         return team.get(index);
      else
         return null;
   }
   
   public int findPlayerIndex(String name) {
      for(int i = 0; i < size; i++) {
         if(team.get(i).getName().equals(name))
            return i;
      }
      return -1;
   }
   
   public Player removePlayer(String name) {
      int index = findPlayerIndex(name);
      if(index >= 0)
         return team.remove(index);
      else
         return null;         
   }
   
   public String toString() {
      String s = "\n\nManager: " + _manager + "\n\nPlayers: \n";
      for(int i = 0; i < size; i++) {
         s += "Player: " + team.get(i);
      }
      return s;
   }
}