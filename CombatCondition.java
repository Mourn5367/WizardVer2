public class CombatCondition
{

    public boolean EscapeCondition(Unit _unit)
    {
        // 유닛의 체력이 0 이하 이면 true 반환
        return _unit.HP <= 0;
    }
    public boolean IsEscape(Unit _unit, Status status) throws InterruptedException {
        Thread.sleep(1000);
        if (EscapeCondition(_unit)) // true일 경우
        {
            status.EndCombatPrint(EscapeCondition(_unit), _unit);
            Thread.sleep(500);
            return false; // false를 반환해 while문 종료에 도움을 줌
        } else {
            System.out.printf("공격을 마쳤다...\n");
            Thread.sleep(500);
            return true;
        }
    }
}
