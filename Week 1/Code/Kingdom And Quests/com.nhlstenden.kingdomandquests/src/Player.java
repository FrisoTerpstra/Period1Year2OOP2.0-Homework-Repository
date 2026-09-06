import java.util.ArrayList;
import java.util.List;

public class Player
{
    private int xp;
    private int level;
    private Character character;
    private List<Item> items;

    public Player(int xp, int level, Character character)
    {
        this.setXp(xp);
        this.setLevel(level);
        this.setCharacter(character);
        this.items = new ArrayList<>();
    }

    public int getXp()
    {
        return this.xp;
    }

    public void setXp(int xp)
    {
        this.xp = xp;
    }

    public int getLevel()
    {
        return this.level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public Character getCharacter()
    {
        return this.character;
    }

    public void setCharacter(Character character)
    {
        this.character = character;
    }

    public List<Item> getItems()
    {
        return this.items;
    }

    public void setItems(List<Item> items)
    {
        if (items == null)
        {
            throw new IllegalArgumentException("items cannot be null or empty");
        }

        for (Item item : items)
        {
            if (item == null)
            {
                throw new IllegalArgumentException("items cannot be null");
            }
        }

        this.items = new ArrayList<>(items);
    }

    public void chooseCharacter(Character character) {
        this.character = character;

        System.out.println("Character chosen.");
    }

    public void viewAvailableQuests() {
        System.out.println("Viewing available quests.");
    }

    public void selectQuest(Quest quest) {
        System.out.println("Quest selected.");
    }

    public void playQuest(Quest quest) {

        if (canPlayQuest(quest))
        {
            System.out.println("Playing quest.");
        } else

        {
            System.out.println("You do not have enough XP to play this quest.");
        }
    }

    public void completeQuest(Quest quest)
    {

        if (canPlayQuest(quest))
        {
            quest.complete(this);
        } else

        {
            System.out.println("You do not have enough XP to complete this quest.");
        }
    }

    public void gainXp(int amount)
    {
        xp += amount;

        System.out.println
                (
                "XP gained: " + amount +
                        ". Total XP: " + xp
        );
    }

    public void levelUp() {

        if (xp >= 200) {
            level++;

            System.out.println
                    (
                            "Level up! Current level: " + level
                    );
        } else
        {
            System.out.println
                    (
                    "You need 200 XP to level up."
            );
        }
    }

    public boolean canPlayQuest(Quest quest)
    {
        return xp >= quest.getRequiredXp();
    }
}
