public class PlayerValue
{
    int hP = 80;
    int mP = 100;

    int oriDMG = 10;
    int skillDMG = 30;

    int criticalPlusDMG = 10;

    public void SetPlayerValue(Player _player)
    {
        _player.playerHP = hP;
        _player.playerMP = mP;
        _player.playerOriginDMG = oriDMG;
        _player.playerSkillDMG = oriDMG;
        _player.criticalPlusDMG =criticalPlusDMG;

    }
}
