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

    public int beforePlayerHP = 0;
    public int beforePlayerMP = 0;
    public int playerMP = 0;

    public String[] playerableAct ={"기본 공격","마법 공격"};
    public String[] playerSkill = {"짱센마법"}; // 마법 관련은 중첩 클래스 도입해야 편함
    public int[] playerSkillCost = {30};
    public int playerOriginDMG = 0;
    public int playerSkillDMG = 0;
    int criticalPlusDMG = 0;

    public void SetPlayerName(Player _player, String _name)
    {
        _player.playerName = _name;
    }
    public int MinSkillCost()
    {
        int minCost = 0;
        for (int i = 0; i < playerSkillCost.length;i++)
        {
            minCost = playerSkillCost[0];
            if (minCost > playerSkillCost[i])
            {
                minCost = playerSkillCost[i];
            }
        }
        return minCost;
    }

}
