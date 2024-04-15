import java.util.Random;
public class Status implements LoadingText
{
    Random random = new Random();
    public void TimeSleep(int _time,String _message)
    {
        for (int i = 0; i < 3; i++ )
        {
            System.out.printf("%s",_message);
            try {Thread.sleep(_time);}
            catch (InterruptedException InterException)
            {InterException.printStackTrace();}
        }
    }
    public void MeetingScene(Unit _unit1,Unit _unit2)
    {
        TimeSleep(500,"몬스터 접근중 !\n");

        System.out.printf("%s %s(이)가 야생의 %s %s를 만났다!!\n\n"
                ,_unit1.unitClass,_unit1.name, _unit2.unitClass,_unit2.name);
    }

    public void UnitStatus(Unit _unit)
    {
        SkillUnit skillUnit;
        if (_unit instanceof SkillUnit)
        {
            skillUnit =(SkillUnit)_unit;
            System.out.printf("%s: %s 체력: %d/%d 기력: %d/%d\n"
                ,skillUnit.unitClass, skillUnit.name, skillUnit.HP,skillUnit.maxHP,
                    skillUnit.MP, skillUnit.maxMP);
        }
        else
        {
            System.out.printf("%s: %s 체력: %d/%d\n"
                    ,_unit.unitClass,_unit.name, _unit.HP,_unit.maxHP);
        }
    }
    public void SelectText(String[] _array)
    {
        for (int i = 0; i < _array.length; i++)
        {
            System.out.printf("%d. %s\t",i+1,_array[i]);
        }
        System.out.println();
    }
    public void AfterCombatStatusText(Unit _unit1, Unit _unit2) //이모티콘이 깨질경우
    {
        System.out.printf("%s(이)가 %d의 피해를 입어 %d/%d의 체력이 되었고 %s(이)가 %d의 피해를 입어 %d/%d 체력이 되었다!\n"
                ,_unit1.name, _unit1.beforeHP - _unit1.HP, _unit1.HP,_unit1.maxHP,
                _unit2.name, _unit2.beforeHP - _unit2.HP, _unit2.HP,_unit2.maxHP);
    }
    public void AfterCombatStatusSymbol(Unit _unit1, Unit _unit2)
    {
        System.out.printf("%s(이)가 ",_unit1.name);
        UnitHPPrint(_unit1.beforeHP - _unit1.HP);
        System.out.printf("의 피해를 입어 ");
        UnitHPPrint(_unit1);
        System.out.printf("의 체력이 되었고 %s가 ",_unit2.name);
        UnitHPPrint(_unit2.beforeHP - _unit2.HP);
        System.out.printf("의 피해를 입어 ");
        UnitHPPrint(_unit2);
        System.out.println("의 체력이 되었다...!!\n");
    }
    public void AfterUnitSkillStatus(SkillUnit _skillUnit, int selectSkill)
    {
        System.out.printf("%s을(를) 사용하여 기력을 %d 사용했다\n" +
                "기력이 %d/%d 남았다 !\n", _skillUnit.skill[selectSkill], _skillUnit.skillCost[selectSkill],
                                    _skillUnit.MP,_skillUnit.maxMP);
    }
    public void EndCombatPrint(boolean _isEscapeCombatCondition, Unit _unit)
    {
        if (_isEscapeCombatCondition)
        {
            if (_unit instanceof Player)
            {
                UnitStatus(_unit);
                System.out.printf("%s는 %d의 나이로 생을 마감했다...\n",_unit.name,
                        random.nextInt(20,100));
            }
            else if (_unit instanceof Enemy)
            {
                UnitStatus(_unit);
                System.out.printf("%s를 쓰러뜨렸다...!!!\n",_unit.name);
            }
        }
    }
    public void NotEnoughMPPrint(SkillUnit skillUnit,int _selectSkill) // 스킬 추가 되면 변경
    {
        System.out.printf("기력이 %d이므로 기력 %d(을)를 소모하는 %s을 할수없어 !!\n"
                ,skillUnit.MP,skillUnit.skillCost[_selectSkill],skillUnit.skill[_selectSkill]);

    }


    public void UnitHPPrint(Unit _unit)
    {
        if (_unit.HP % 10 !=0)
        {
            System.out.printf("💔");
        }
        for (int i = 0; i < _unit.HP/10; i++)
        {
            System.out.printf("💖");
        }
        for (int i = 0; i < (_unit.maxHP - _unit.HP)/10; i++)
        {
            System.out.printf("🤍");
        }
    }
    public void UnitHPPrint(int _damage)
    {
        if (_damage % 10 !=0)
        {
            System.out.printf("💔");
        }
        else if (_damage <= 0)
        {
            System.out.printf("🤍");
        }
        for (int i = 0; i < _damage/10; i++)
        {
            System.out.printf("💖");
        }
    }



}
