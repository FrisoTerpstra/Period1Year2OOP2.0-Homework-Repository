public class Warrior extends Character
{
    public Warrior(String name, int attackPower, int defensivePower)
    {
        super(name, attackPower, defensivePower);
    }

    @Override
    public void useSpecialAbility()
    {
        setAttackPower(getAttackPower() + 4);
    }
}
