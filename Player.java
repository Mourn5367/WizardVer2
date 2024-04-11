public class Player
{
    public Player()
    {
        PlayerValue characterValue = new PlayerValue();
        characterValue.SetPlayerValue(this);
    }
    public String playerName = "";
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
