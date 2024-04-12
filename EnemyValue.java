class EnemyValue
{

    String enemyName = "몬스터";
    private final int ENEMYORIGINHP = 100;
    private final int ENEMYORIGINDMG = 10;

    protected void SetEnemyValue(Enemy _enemy)
    {
        _enemy.enemyName = enemyName;
        _enemy.maxEnemyHP = ENEMYORIGINHP;
        _enemy.enemyHP = ENEMYORIGINHP;
        _enemy.enemyDMG = ENEMYORIGINDMG;
    }
    public void SetEnemyName(Enemy _enemy, String _name)
    {
        _enemy.enemyName = _name;
    }
}
