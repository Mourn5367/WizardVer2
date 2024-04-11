
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
        _enemy.enemyHP -= _player.playerOriginDMG;
    }

    public void PlayerSkillAttack (Player _player, Enemy _enemy,boolean _critical)
    {
        if (_critical)
        {
            _enemy.enemyHP -= _player.playerOriginDMG + _player.criticalPlusDMG;
        }
        else
        {
            _enemy.enemyHP -= _player.playerOriginDMG;
        }
    }

    public void EnemyAttack(Player _player, Enemy _enemy)
    {
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
