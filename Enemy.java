class Enemy extends EnemyValue
{
    public Enemy()
    {
        SetEnemyValue(this);
    }


    public String enemyName = "";
    public int maxEnemyHP = 0;
    public int enemyHP = 0;

    public int beforeEnemyHP = 0;
    public int enemyDMG = 0;
}

