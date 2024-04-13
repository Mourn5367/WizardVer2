
public class CombatCondition
{

    public boolean EscapeCondition(Unit _unit)
    {
        if (_unit.HP <= 0 )
        {
            return true;
        }
        else return false;
    }
    public boolean IsEscape(Unit _unit, Status status) throws InterruptedException {
        Thread.sleep(1000);
        if (EscapeCondition(_unit) == true) {
            status.EndCombatPrint(EscapeCondition(_unit), _unit);
            Thread.sleep(500);
            return false;
        } else {
            System.out.printf("공격을 마쳤다...\n");
            Thread.sleep(500);
            return true;
        }
    }

    public boolean SkillCostCondition(Player _player,Status _status,int _selectSkill) // 나중에 스킬 여러개면 사용
    {
        if (_player.MP < _player.skillCost[_selectSkill])
        {
            _status.NotEnoughMPPrint(_player,_selectSkill);
            return false;
        }
        else return true;
    }

}
