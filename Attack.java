import java.security.SecureRandom;
interface Attack extends LoadingText
{
    SecureRandom random = new SecureRandom();
    default boolean CreatRandomValue(SkillUnit _skillUnit)
    {
        double ranValue = random.nextDouble();
        return ranValue < _skillUnit.criticalPercent; // 확률을 통과 했으면 true
    }
    default void OriginAttack(Unit _offense,Unit _defense) // 기본 공격할 때
    {
        System.out.printf("%s !!\n",_offense.ableList[0]);
        _defense.beforeHP = _defense.HP;
        _defense.HP -= _offense.originDMG;
    }

    default void SkillAttack(SkillUnit _skillUnit, Unit _deffense,
                             int _sellectSkill) throws InterruptedException // skill 공격 함수
    {
        _skillUnit.beforeMP = _skillUnit.MP;
        _skillUnit.MP -= _skillUnit.skillCost[_sellectSkill];
        System.out.printf("%s !!\n",_skillUnit.skill[_sellectSkill]);
        LoadingTextPrint();
        if (CreatRandomValue(_skillUnit)) // 크리티컬 확률을 통과했으면
        {
            System.out.println("!! 크리티컬 발생 !!");
            _deffense.beforeHP = _deffense.HP;
            _deffense.HP -= _skillUnit.skillDMG[_sellectSkill] + _skillUnit.criticalDMG;
        }
        else // 통과 못한 경우
        {
            _deffense.beforeHP = _deffense.HP;
            _deffense.HP -= _skillUnit.skillDMG[_sellectSkill];
        }

    }

    default void UnitAttack
            (int _selectAttack,  Unit _unit, Unit _defense, Status _status,
             InputUserCommand _inputUserCommand) throws InterruptedException
    {   // 유닛이 공격을 할때 기본 공격 할지 마법 공격할지 이 함수뒤로 나뉘어진다.
        _selectAttack -= 1; // 배열은 0번 부터라 1 차감
        Player player;
        Enemy enemy;
        switch (_selectAttack) // 1. 기본 공격 2. 마법공격
        {
            case 0:// 기본공격은 1번
                OriginAttack(_unit,_defense);
                break;
            case 1:// 마법공격은 2번
                if(_unit instanceof Player )
                {
                    player = (Player)_unit;
                    if (player.MP < player.MinSkillCost()) // 최소 마나 마법보다 적은 MP일 경우
                    {
                        System.out.printf("기력이 최소 요구량 %d 보다 작아 %s(을)를 사용합니다.\n",
                                player.MinSkillCost(), player.ableList[0]);
                        OriginAttack(player,_defense); // 기본공격을 하게 설정
                    }
                    else // 아니라면 마법을 선택한다.
                    {
                        int selectSkill = 0; // 마법 선택을 담을 변수
                        _status.SelectText(player.skill);
                        selectSkill = _inputUserCommand.SelectSkill(player, _status); // 입력받기
                        SkillAttack(player, _defense, selectSkill);
                        _status.AfterUnitSkillStatus(player,selectSkill);
                    }
                    break;
                }
                else if(_unit instanceof Enemy)
                    // 스킬을 사용하는 Enemy의 경우는 입력 받을 수 없으니 따로 클래스 검사해서 예외처리
                    // 아직은 스킬을 사용하는 Enemy가 없다.
                {

                }
                break;
        }
    }


}
