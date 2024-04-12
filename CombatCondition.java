public class CombatCondition
{

    public int EscapeCondition(Player _player,Enemy _enemy)
    {

        if (_player.playerHP == 0 )
        {
            return 0;
        }
        else if (_enemy.enemyHP == 0)
        {
            return 1;
        }
        else
        {
            return 2;
        }

    }
    public boolean isEscape(Player _player, Enemy _enemy, Status status)
    {
        if (EscapeCondition(_player,_enemy) == 0 )
        {
            status.EndCombatPrint(EscapeCondition(_player,_enemy), _player,_enemy);
            return false;
        }
        if (EscapeCondition(_player,_enemy) == 1 )
        {
            status.EndCombatPrint(EscapeCondition(_player,_enemy), _player,_enemy);
            return false;
        }
        return true;
    }

    public boolean SkillCostCondition(Player _player,Status _status) // 나중에 스킬 여러개면 사용
    {
        if (_player.playerMP < _player.playerSkillCost[0])
        {
            _status.NotEnoughMPPrint(_player);
            return false;
        }
        else return true;
    }


}
