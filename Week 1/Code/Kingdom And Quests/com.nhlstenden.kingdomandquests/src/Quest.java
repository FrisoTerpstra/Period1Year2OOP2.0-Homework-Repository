public class Quest
{
    private String title;
    private int xpReward;
    private int difficulty;

    public Quest(String title, int xpReward, int difficulty)
    {
        this.title = title;
        this.xpReward = xpReward;
        this.difficulty = difficulty;
    }

    public int getRequiredXp()
    {
        return (this.difficulty * 10);
    }

    public void complete(Player player)
    {
        player.gainXp(xpReward);
    }
}
