class PlayerValue
{
    final int ORIGINHp = 80;
    final int ORIGINMp = 100;

    private int hP = 80;
    private int mP = 100;

    private int oriDMG = 10;
    private int skillDMG = 30;

    private int criticalPlusDMG = 10;

    protected void SetPlayerValue(Player _player)
    {
        _player.maxPlayerHP = ORIGINHp;
        _player.maxPlayerMP = ORIGINMp;
        _player.playerHP = hP;
        _player.playerMP = mP;
        _player.playerOriginDMG = oriDMG;
        _player.playerSkillDMG = oriDMG;
        _player.criticalPlusDMG =criticalPlusDMG;

    }
}
