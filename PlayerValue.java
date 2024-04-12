class PlayerValue
{
    private String playername = "Gandalf";
    final int ORIGINHp = 80;
    final int ORIGINMp = 100;

    private int oriDMG = 10;
    private int skillDMG = 30;

    private int criticalPlusDMG = 10;

    protected void SetPlayerValue(Player _player)
    {
        _player.playerName = playername;
        _player.maxPlayerHP = ORIGINHp;
        _player.maxPlayerMP = ORIGINMp;
        _player.playerHP = ORIGINHp;
        _player.playerMP = ORIGINMp;
        _player.beforePlayerHP = ORIGINHp;
        _player.beforePlayerMP = ORIGINMp;
        _player.playerOriginDMG = oriDMG;
        _player.playerSkillDMG = skillDMG;
        _player.criticalPlusDMG =criticalPlusDMG;
    }
}
