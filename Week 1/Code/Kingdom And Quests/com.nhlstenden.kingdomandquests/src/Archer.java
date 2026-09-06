public class Archer extends Character
{
    public Archer(String name, int attackPower, int defensivePower)
    {
        super(name, attackPower, defensivePower);
    }

    @Override
    public void useSpecialAbility()
    {
        setAttackPower(getAttackPower() * 2);
    }
}
