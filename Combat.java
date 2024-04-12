
import java.security.SecureRandom;

public class Combat
{
    SecureRandom random = new SecureRandom();
    public boolean CreatRandomValue()
    {
        float ranValue = random.nextFloat();

        return ranValue <= 0.3;
    }
    public void PlayerOriginAttack(Player _player, Enemy _enemy)
    {
        _enemy.beforeEnemyHP = _enemy.enemyHP;
        _enemy.enemyHP -= _player.playerOriginDMG;
    }

    public void PlayerSkillAttack (Player _player, Enemy _enemy,boolean _critical)
    {

        _player.beforePlayerMP = _player.playerMP;
        _player.playerMP -= _player.playerSkillCost[0]; // 이 부분도 마법 추가되면 바뀌어야함

        if (_critical)
        {
            System.out.println("!! 크리티컬 발생 !!");
            _enemy.beforeEnemyHP = _enemy.enemyHP;
            _enemy.enemyHP -= _player.playerSkillDMG + _player.criticalPlusDMG;
        }
        else
        {
            _enemy.beforeEnemyHP = _enemy.enemyHP;
            _enemy.enemyHP -= _player.playerSkillDMG;
        }
    }

    public void EnemyAttack(Player _player, Enemy _enemy)
    {
        _player.beforePlayerHP = _player.playerHP;
        _player.playerHP -= _enemy.enemyDMG;
    }

    public void PlayerAttack(int _selectAttackMenu, Player _player, Enemy _enemy, boolean _critical)
    {

        float _criticalValue =  random.nextFloat();

        switch( _selectAttackMenu)
        {
            case 1:PlayerOriginAttack(_player,_enemy);
            case 2:PlayerSkillAttack(_player,_enemy,_critical);
        }
    }
}
