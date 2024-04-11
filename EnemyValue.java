public class EnemyValue
{

    String name = "몬스터";
    int hP = 100;
    int oriDMG = 10;

    public void SetEnemyValue(Enemy _enemy)
    {
        _enemy.enemyHP = hP;
        _enemy.enemyDMG = oriDMG;
    }
}
