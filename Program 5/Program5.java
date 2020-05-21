/***********************************************************************************
William Mastronardi Class CSC205 25993
This program will be used to test the Team class and also modify the team however the
User chosses to from the menu. 
MENU 1:
a) Modify the Team with no Players and a default manager
b) Modify the Team with 2 batters, 2 pitchers, and a named manager

MENU 2:
a) Hire a new manager
b) Hire a new Pitcher
c) Hire a new Batter
d) Fire a Player
e) Get information on a Player
f) Get information on the Manager
g) Get the number of Pitchers
h) Get the number of Batters
i) Get the number of Players on the team
j) Get the Team's average Earned Run Average (ERA)
k) Get the Team's average Walks plus Hits per Innings Pitched (WHIP)
l) Get the Team's average Batting Average
m) Get the Team's average Value
n) View the Team's roster
o) Get the team's total salary
***********************************************************************************/
import java.util.*;

public class Program5 {
   public static Scanner kb = new Scanner(System.in);
   public static void main(String[] args) {
      Team team1 = new Team();
      Manager manager = new Manager(0, 0, 2500000, 0, "David Ross");
      Team team2 = new Team(manager);
      Pitcher pitcher = new Pitcher(170, 20000000, 8, "Yu Darvish", 1051, 417, 384, 850);
      Batter batter = new Batter(706, 18600000, 5, "Kris Bryant", 138, 2643, 751);
      team2.addPitcher(pitcher);
      pitcher = new Pitcher(192, 12666667, 9, "Tyler Chatwood", 828, 403, 432, 819);
      team2.addPitcher(pitcher);
      team2.addBatter(batter);
      batter = new Batter(665, 10000000, 6, "Javier Baez", 110, 2316, 626);
      team2.addBatter(batter);
      char input;
      System.out.println("Welcome to Baseball Team Creator!\n");
      System.out.println("In this program you can test modifying a baseball team. ");
      System.out.println("The program offers 2 teams to modify, a default team with no players ");
      System.out.println("(Team 1) or a team that has 4 players (Team 2). \n");
      do{
         do{
            System.out.println("a - Team 1\nb - Team 2\nc - Quit the program");
            System.out.print("Enter which team you would like to modify: ");
            input = kb.next().charAt(0);
            if(input < 'a' && input > 'c')
               System.out.println("Error: Invalid Input, Try again.");
         }while(input < 'a' && input > 'c');
         switch(input) {
            case 'a':
            menuForTeamManipulation(team1);
            break;
            case 'b':
            menuForTeamManipulation(team2);
            break;
         }
      }while(input != 'c');
   }
   
   public static void menuForTeamManipulation(Team team) {
      char input;
      Player store;
      System.out.println("How would you like to manipulate the team?");
      do{
         do{
            System.out.println("a - Hire a new Manager\nb - Hire a new Pitcher\nc - Hire a new Batter");
            System.out.println("d - Remove a Player\ne - Get info on a specific player by name");
            System.out.println("f - View info on the Manager\ng - Get the number of Pitchers");
            System.out.println("h - Get number of Batters\ni - Get number of Batters");
            System.out.println("j - Get the average Earned Run Average (ERA) of the team");
            System.out.println("k - Get the average Walks plus Hits per Innings Pitched (WHIP) of the team");
            System.out.println("l - Get the Average Batting Average of the team\nm - Get the team's average value");
            System.out.println("n - View the roster\no - View the team's salary");
            System.out.print("q - Quit modifying this Team\nEnter a choice from the menu above: ");
            input = kb.next().charAt(0); 
            if(input < 'a' && input > 'q') 
               System.out.println("Error, Invalid Input. Try again.");
         }while(input < 'a' && input > 'q');
         switch(input) {
            case 'a':
               getNewManager(team);
               break;
            case 'b':
               getNewPitcher(team);
               break;
            case 'c':
               getNewBatter(team);
               break;
            case 'd':
               System.out.print("Enter the name for the Player you'd like to remove: ");
               store = team.removePlayer(kb.next());
               System.out.println("Removed player: " + store);
               break;
            case 'e':
               System.out.print("Enter the name for the Player you'd like to view: ");
               System.out.println(team.findPlayerByName(kb.next()));
               break;
            case 'f':
               System.out.println("Current Manager: " + team.getManager());
               break;
            case 'g':
               System.out.println("Current number of Pitchers: " + team.getPitchers());
               break;
            case 'h':
               System.out.println("Current number of Batters: " + team.getBatters());
               break;
            case 'i':   
               System.out.println("Current number of Players: " + team.getNumberOfPlayers());
               break;
            case 'j':
               System.out.println("Team's average ERA: " + team.getERA());
               break;
            case 'k':
               System.out.println("Team's average WHIP: " + team.getWHIP());
               break;
            case 'l':
               System.out.println("Team's average Batting Average: " + team.getTeamBattingAverage());
               break;
            case 'm':
               System.out.println("Team's average Value: " + team.getValue());
               break;
            case 'n':
               System.out.println(team);
               break;
            case 'o':
               System.out.println("Team's salary " + team.getSalary());
         }
      }while(input != 'q');
      System.out.println("Sending you back to the main menu. . .");
   }

   public static void getNewManager(Team team) {
      System.out.print("What is the new manager's name? ");
      String name = kb.next();
      System.out.print("How many career games? ");
      int games = kb.nextInt();
      System.out.print("How many career wins? ");
      int wins = kb.nextInt();
      System.out.print("How much is their salary? ");
      int salary = kb.nextInt();
      System.out.print("How many years have they been in baseball? ");
      int years = kb.nextInt();
      Manager hired = new Manager(games, wins, salary, years, name);
      System.out.print("Replacing manager " + team.getManager() + " with the new manager " + hired);
      team.replaceManager(hired);
   }

   public static void getNewPitcher(Team team) {
      System.out.print("What is the new pitcher's name? ");
      String name = kb.next();
      System.out.print("How many games have they played? ");
      int games = kb.nextInt();
      System.out.print("How many innings have they pitched? ");
      int innings = kb.nextInt();
      System.out.print("How many walks have they had? ");
      int walks = kb.nextInt();
      System.out.print("How many hits have they had? ");
      int hits = kb.nextInt();
      System.out.print("How many earned runs do they have? ");
      int earnedRuns = kb.nextInt();
      System.out.print("How much is their salary? ");
      int salary = kb.nextInt();
      System.out.print("How many years have they been in baseball? ");
      int years = kb.nextInt();
      Pitcher hired = new Pitcher(games, salary, years, name, innings, earnedRuns, walks, hits);
      System.out.println("Hiring pitcher " + hired);
      team.addPitcher(hired);
   }

   public static void getNewBatter(Team team) {
      System.out.print("What is the new batter's name? ");
      String name = kb.next();
      System.out.print("How many games have they played? ");
      int games = kb.nextInt();
      System.out.print("How mant at bats have they had? ");
      int atBats = kb.nextInt();
      System.out.print("How many hits have they had? ");
      int hits = kb.nextInt();
      System.out.print("How many home runs do they have? ");
      int homeRuns = kb.nextInt();
      System.out.print("How much is their salary? ");
      int salary = kb.nextInt();
      System.out.print("How many years have they been in baseball? ");
      int years = kb.nextInt();
      Batter hired = new Batter(games, salary, years, name, homeRuns, atBats, hits);
      System.out.println("Hiring batter " + hired);
      team.addBatter(hired);
   }

}
/***********************************************************************************
William Mastronardi CSC205 25993
This class is an abstract class used to generalize many common functions between the
two kinds of players, batters and pitchers.
***********************************************************************************/
/*
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
/***********************************************************************************
William Mastronardi CSC205 25993
This class is an abstract class used to generalize many common functions between the
two kinds of players, batters and pitchers.
***********************************************************************************/
/*
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
/***********************************************************************************
William Mastronardi CSC205 25993
This class will be an extension of the Employee class, used to store data for an 
on-field baseball manager.
***********************************************************************************/
/*
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
/***********************************************************************************
William Mastronardi CSC205 25993
This class is used to store the basic data for a baseball batter, such as at bats,
hits, and home runs. This basic information will be used to calculate some more complex
statistics, such as the batting average or the value of the player.
***********************************************************************************/
/*
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
/***********************************************************************************
William Mastronardi CSC205 25993
This class is used to store data based on a Pitcher for a baseball team. This class
will use basic data (innings pitched, walks, hits, earned runs) to calculate some 
more complex data such as the earned run average (ERA), or the Walks plus Hits per
Innings Pitched (WHIP) and the player value.
***********************************************************************************/
/*
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
/***********************************************************************************
William Mastronardi CSC205 25993
This class will use the Java ArrayList class to store data of a team, creating one 
manager either based on parameters passed to the constructor or defaulting a manager
if no parameters are sent. This class will also instances of the manager and the abstract
player classes to create a baseball team. 
***********************************************************************************/
/*
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
**/