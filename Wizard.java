public interface Wizard
{
    String WIZARDNAME = "Gandalf";
    String UNITCLASSNAME = "Wizard";
    int WIZARDMAXHP = 80;
    int WIZARDMAXMP = 100;
    String[] WIZARDABLELIST ={"기본 공격","마법 공격"};
    String[] WIZARDSKILL = {"짱센마법"}; // 마법 관련은 중첩 클래스 도입해야 편함
    int[] WIZARDSKILLCOST = {30};
    int WIZARDORIGINDMG = 5;
    int[] WIZARDSKILLDMG = {30};
    int WIZARDCRITICALADDITIONALDMG = 10;
    default void SetWizard(Player _player)
    {
        _player.unitClass = UNITCLASSNAME;
        _player.name = WIZARDNAME;
        _player.maxHP = WIZARDMAXHP;
        _player.HP = _player.maxHP;
        _player.beforeHP = 0;

        _player.originDMG = WIZARDORIGINDMG;
        _player.skillDMG = WIZARDSKILLDMG;
        _player.criticalDMG = WIZARDCRITICALADDITIONALDMG;

        _player.maxMP = WIZARDMAXMP;
        _player.MP = _player.maxMP;
        _player.beforeMP = 0;

        _player.skillCost = WIZARDSKILLCOST;
        _player.skill = WIZARDSKILL;
        _player.ableList = WIZARDABLELIST;
        _player.minCost = _player.MinSkillCost();
    }


}