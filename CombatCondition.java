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
        if (EscapeCondition(_unit)) {
            status.EndCombatPrint(EscapeCondition(_unit), _unit);
            Thread.sleep(500);
            return false;
        } else {
            System.out.printf("공격을 마쳤다...\n");
            Thread.sleep(500);
            return true;
        }
    }
}
