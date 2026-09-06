public class Mage extends Character
{
    public Mage(String name, int attackPower, int defensivePower)
    {
        super(name, attackPower, defensivePower);
    }

    @Override
    public void useSpecialAbility()
    {
        setDefensivePower(getDefensivePower() + 4);
    }
}
