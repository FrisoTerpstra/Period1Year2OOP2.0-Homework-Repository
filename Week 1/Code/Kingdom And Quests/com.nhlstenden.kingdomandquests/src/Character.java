public abstract class Character
{
    private String name;
    private int attackPower;
    private int defensivePower;

    public Character(String name, int attackPower, int defensivePower)
    {
        this.name = name;
        this.attackPower = attackPower;
        this.defensivePower = defensivePower;
    }

    public void attack()
    {
        System.out.println(name + " attacks with " + attackPower + " attack power.");
    }

    public void defend()
    {
        System.out.println(name + " defends with " + defensivePower + " defense power.");
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public int getAttackPower()
    {
        return this.attackPower;
    }

    public void setAttackPower(int attackPower)
    {
        this.attackPower = attackPower;
    }

    public int getDefensivePower()
    {
        return this.defensivePower;
    }

    public void setDefensivePower(int defensivePower)
    {
        this.defensivePower = defensivePower;
    }

    public abstract void useSpecialAbility();
}
