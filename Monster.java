public interface Monster
{
    String MONSTERNAME = "몬스터";
    int MONSTERMAXHP = 100;
    int MONSTERORIDMG = 10;

    String UNITCLASSNAME = "적";
    String MONSTERABLELIST[] = {"흉폭한 일격"};

    default void SetMonster(Enemy _enemy)
    {
        _enemy.unitClass = UNITCLASSNAME;
        _enemy.name = MONSTERNAME;
        _enemy.maxHP = MONSTERMAXHP;
        _enemy.HP = _enemy.maxHP;
        _enemy.originDMG = MONSTERORIDMG;
        _enemy.ableList = MONSTERABLELIST;
    }
}
