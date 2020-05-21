public class StarWarsHeroArray
{
    private StarWarsHero[] _cards;

    public StarWarsHeroArray()
    {
        _cards = new StarWarsHero[]
        {   
		    // name, type, height, brains, darkSide, jediPowers, battleSkills, forceFactor
            new StarWarsHero("Anakin Skywalker", "Jedi",          1.85, 15, 18, 75, 55, 4),
            new StarWarsHero("Commander Cody",   "Republic",      1.83, 12, 20,  2, 39, 1),
            new StarWarsHero("Count Dooku",      "Separatist",    1.93, 18, 21, 70, 55, 2),

            new StarWarsHero("Darth Maul",       "SithLord",      1.75,  9, 24, 80, 48, 1),
		   	new StarWarsHero("General Grievous", "Separatist",    2.16, 17, 20, 50, 60, 1),
            new StarWarsHero("Ki-Adi-Mundi",     "Jedi",          1.98, 17,  3, 85, 46, 3),

            new StarWarsHero("Jango Fett",       "BountyHunter",  1.83, 11, 20, 17, 49, 1),
            new StarWarsHero("Kit Fisto",        "Jedi",          1.96, 13,  4, 81, 44, 2),
            new StarWarsHero("Lama Su",          "Hamindan",      2.29, 13,  5,  1, 12, 1),

            new StarWarsHero("Mace Windu",       "Jedi",          1.88, 18,  2, 95, 55, 3),
            new StarWarsHero("Mas Amedda",       "Republic",      1.96, 10,  9,  1, 14, 3),
            new StarWarsHero("Poggle the Lesser","Separatist",    1.75,  8, 14,  1,  9, 2),

            new StarWarsHero("Qui-Gon Jinn",     "Jedi",          1.93, 19,  2, 65, 41, 1),
            new StarWarsHero("Senator Amidala",  "Republic",      1.65, 17,  2, 30, 40, 2),
            new StarWarsHero("Tarfful",          "Wookee",        2.34,  8,  6, 10, 52, 1),

            new StarWarsHero("Boba Fett",        "BountyHunter",  1.83, 11, 20, 17, 49, 4),
            new StarWarsHero("C-3PO",            "Droid",         1.67, 19,  0,  0,  8, 6),
            new StarWarsHero("Chewbacca",        "RebelAlliance", 2.28, 12,  5, 10, 55, 4),

            new StarWarsHero("Darth Vader",      "GalacticEmpire",2.03, 16, 22, 82, 55, 4),
            new StarWarsHero("Emperor Palatine", "Empire",        1.73, 14, 25, 95, 25, 5),
            new StarWarsHero("Greedo",           "BountyHunter",  1.73,  8, 18,  2, 30, 2),
			
            new StarWarsHero("Han Solo",         "RebelAlliance", 1.83, 13,  6,  4, 50, 3),
            new StarWarsHero("Jaba the Hutt",    "Criminal",      1.75, 13, 20,  0, 10, 3),
            new StarWarsHero("Lando Calrissian", "RebelAlliance", 1.78, 15,  8,  6, 48, 2),

            new StarWarsHero("Luke Skywalker",   "Jedi",          1.72, 15,  4, 90, 43, 4),
            new StarWarsHero("Mon Mothma",       "RebelAlliance", 1.7,  18,  0, 30, 20, 2),
            new StarWarsHero("Obi-Wan Kenobi",   "Jedi",          1.75, 18,  1, 80, 26, 6),

            new StarWarsHero("Leia Organa",      "RebelAlliance", 1.52, 17,  1, 50, 38, 4),
            new StarWarsHero("R2-D2",            "Droid",         1.09, 14,  0,  0, 14, 6),
            new StarWarsHero("Wicket W Warrick", "Ewok",          0.8,  14,  2, 20,  1, 1)            
        };
    }

    public StarWarsHero[] getCards()
    {
        return _cards;
    }

}