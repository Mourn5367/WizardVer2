import java.security.SecureRandom;
interface Attack extends LoadingText
{
    SecureRandom random = new SecureRandom();
    default boolean CreatRandomValue(int _selectRandomValue,SkillUnit _skillUnit) // 0은 크리티컬
    {
        double ranValue = random.nextDouble();

        switch (_selectRandomValue)
        {
            case 0:
            {
                return ranValue < _skillUnit.criticalPercent;
            }
            default:
                return false;
        }
    }
    default void OriginAttack(Unit _offense,Unit _defense)
    {
        System.out.printf("%s !!\n",_offense.ableList[0]);
        _defense.beforeHP = _defense.HP;
        _defense.HP -= _offense.originDMG;
    }

    default void SkillAttack(SkillUnit _skillUnit, Unit _deffense, int _sellectSkill) throws InterruptedException {
        _skillUnit.beforeMP = _skillUnit.MP;
        _skillUnit.MP -= _skillUnit.skillCost[_sellectSkill];
        System.out.printf("%s !!\n",_skillUnit.skill[_sellectSkill]);
        LoadingTextPrint();
        if (CreatRandomValue(0,_skillUnit))
        {
            System.out.println("!! 크리티컬 발생 !!");
            _deffense.beforeHP = _deffense.HP;
            _deffense.HP -= _skillUnit.skillDMG[_sellectSkill] + _skillUnit.criticalDMG;
        }
        else
        {
            _deffense.beforeHP = _deffense.HP;
            _deffense.HP -= _skillUnit.skillDMG[_sellectSkill];
        }

    }

    default void UnitAttack
            (int _selectAttack,  Unit _unit, Unit _defense, Status _status,
             InputUserCommand _inputUserCommand) throws InterruptedException {
        _selectAttack -= 1;
        Player player;
        Enemy enemy;
        switch (_selectAttack)
        {
            case 0:// 기본공격은 1번
                OriginAttack(_unit,_defense);
                break;
            case 1:// 마법공격은 2번
                if(_unit instanceof Player )
                {
                    player = (Player)_unit;
                    if (player.MP < player.MinSkillCost())
                    {
                        System.out.printf("기력이 최소 요구량 %d 보다 작아 %s(을)를 사용합니다.\n",
                                player.MinSkillCost(), player.ableList[0]);
                        OriginAttack(player,_defense);
                    }
                    else
                    {
                        int selectSkill = 0;
                        _status.SelectText(player.skill);
                        selectSkill = _inputUserCommand.SelectSkill(player, _status);
                        SkillAttack(player, _defense, selectSkill);
                        _status.AfterUnitSkillStatus(player,selectSkill);
                    }
                    break;
                }
                else if(_unit instanceof Enemy)
                {

                }
                break;
        }
    }


}
