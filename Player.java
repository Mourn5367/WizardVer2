class Player extends PlayerValue
{
    public Player()
    {
        SetPlayerValue(this);
    }
    public String playerName = "";
    int maxPlayerHP = 0;
    int maxPlayerMP = 0;

    public int playerHP = 0;
    public int playerMP = 0;

    public int playerOriginDMG = 0;
    public int playerSkillDMG = 0;
    int criticalPlusDMG = 0;

    public void SetPlayerName(Player _player, String _name)
    {
        _player.playerName = _name;
    }
}
