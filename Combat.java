
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

    public void PlayerAttack(int _selectAttackMenu, Player _player,
                             Enemy _enemy,Status _status,CombatCondition combatCondition)
    {
        _selectAttackMenu -= 1;
        boolean isCostCondition = false;
        float _criticalValue =  random.nextFloat();
        switch( _selectAttackMenu)
        {
            case 0:
            {
                System.out.printf("%s !!\n",_player.playerableAct[_selectAttackMenu]);
                PlayerOriginAttack(_player,_enemy);
                break;
            }
            case 1:
            {
                _status.PlayerSkillPrint(_player);

                if (_player.playerMP <_player.MinSkillCost())
                {
                    System.out.printf("기력이 %d 보다 작아 %s(을)를 사용합니다.\n",
                            _player.MinSkillCost(),_player.playerableAct[0]);

                    System.out.printf("%s !!\n",_player.playerableAct[_selectAttackMenu]);
                    PlayerOriginAttack(_player,_enemy);
                    break;
                }
                System.out.printf("%s !!\n",_player.playerableAct[_selectAttackMenu]);
                PlayerSkillAttack(_player,_enemy,CreatRandomValue());
                break;
            }
        }
    }

}
