public class StarWarsHero
{
    private String _name;
	private String _type;
    private double _height;
    private int _brains;
    private int _darkSide;
    private int _jediPowers;
    private int _battleSkills;
	private int _forceFactor;
 
    public StarWarsHero(String name, String type, double height,
	  int brains, int darkSide, int jediPowers,
	  int battleSkills, int forceFactor )
    {
        _name = name;
	    _type = type;
        _height = height;
        _brains = brains;
        _darkSide = darkSide;
        _jediPowers = jediPowers;
        _battleSkills = battleSkills;
	    _forceFactor = forceFactor;
    }
    
    public String getName()
    {
        return _name;
    }
  
    public String getType()
    {
        return _type;
    }
  
    public double getHeight()
    {
        return _height;
    }
    
    public int getBrains()
    {
        return _brains;
    }

    public int getDarkSide()
    {
        return _darkSide;
    }

    public int getJediPowers()
    {
        return _jediPowers;
    }

    public int getBattleSkills()
    {
        return _battleSkills;
    }

    public int getForceFactor()
    {
        return _forceFactor;
    }
  
    public String toString()
    {
        return "[" + _name + " : " + _type + "]\n" + 
		   "(a) Height: " + _height + " (b) Brains: " + _brains + "\n" +
		   "(c) Dark Side: " + _darkSide + " (d) Jedi Powers: " + _jediPowers + "\n" +
		   "(e) Battle Skills: " + _battleSkills + " (f) Fear Factor: " + _forceFactor + "\n";
    }
}
    
