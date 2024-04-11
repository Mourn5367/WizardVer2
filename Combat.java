
import java.util.Random;
public class Combat
{
    Random random = new Random();
    public void PlayerOriginAttack(Player _player, Enemy _enemy, boolean _critical)
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
        _enemy.enemyHP -= _player.playerSkillDMG;
    }

    public void PlayerAttack(int _selectAttackMenu, Player _player, Enemy _enemy, boolean _critical)
    {

        float _criticalValue =  random.nextFloat();

        switch( _selectAttackMenu)
        {
            case 1:PlayerOriginAttack(_player,_enemy,_critical);
            case 2:PlayerSkillAttack(_player,_enemy,_critical);
        }
    }

}
