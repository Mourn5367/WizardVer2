class EnemyValue
{

    String name = "몬스터";
    private int enemyHP = 100;
    private int oriDMG = 10;

    protected void SetEnemyValue(Enemy _enemy)
    {
        _enemy.enemyHP = enemyHP;
        _enemy.enemyDMG = oriDMG;
    }
}
