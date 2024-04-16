public interface Wizard
{
    // 직업이 Wizard인 경우 이 값을 가져야 함
    String WIZARDNAME = "Gandalf";
    String UNITCLASSNAME = "Wizard";
    int WIZARDMAXHP = 80;
    int WIZARDMAXMP = 100;
    String[] WIZARDABLELIST ={"기본 공격","마법 공격"};
    String[] WIZARDSKILL = {"짱센마법","더 짱센마법"};
    int[] WIZARDSKILLCOST = {30,60};
    int WIZARDORIGINDMG = 5;
    int[] WIZARDSKILLDMG = {30,80};
    int WIZARDCRITICALADDITIONALDMG = 10;
    double WIZARDCRITICALPERCENT = 0.3;
    // 마법 별로 크리티컬이 달라지면 크리티컬 계수도 배열로 바꿔야함
    default void SetWizard(Player _player)
    {
        _player.unitClass = UNITCLASSNAME;
        _player.name = WIZARDNAME;
        _player.maxHP = WIZARDMAXHP;
        _player.HP = _player.maxHP;
        _player.beforeHP = 0;
        _player.originDMG = WIZARDORIGINDMG;
        _player.ableList = WIZARDABLELIST; // 여기 까지 Unit값 설정
        
        _player.skillDMG = WIZARDSKILLDMG;
        _player.criticalDMG = WIZARDCRITICALADDITIONALDMG;
        _player.criticalPercent = WIZARDCRITICALPERCENT;

        _player.maxMP = WIZARDMAXMP;
        _player.MP = _player.maxMP;
        _player.beforeMP = 0;

        _player.skillCost = WIZARDSKILLCOST;
        _player.skill = WIZARDSKILL;

        _player.minCost = _player.MinSkillCost();
    }


}
