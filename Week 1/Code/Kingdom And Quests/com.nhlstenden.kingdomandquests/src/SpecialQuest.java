public class SpecialQuest extends Quest
{
    private Item rewardItem;

    public SpecialQuest(String title, int xpReward, int difficulty, Item rewardItem)
    {
        super(title, xpReward, difficulty);
        this.rewardItem = rewardItem;
    }

    @Override
    public void complete(Player player)
    {
        super.complete(player);
        player.getItems().add(rewardItem);
    }
}
