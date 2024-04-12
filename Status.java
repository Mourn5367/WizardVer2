public class Status
{
    public void PlayerStatus(Player _player )
    {
        System.out.printf("체력: %d/%d 기력: %d/%d.\n"
                , _player.playerHP, _player.maxPlayerHP,  _player.playerMP,_player.maxPlayerMP);
    }

    public void AfterCombatStatus(Player _player, Enemy _enemy)
    {
        System.out.printf("%s(이)가 %d의 피해를 입어 %d/%d의 체력이 되었고 %s가 %d의 피해를 입어 %d/%d 체력이 되었다!\n"
                ,_player.playerName, _player.beforePlayerHP - _player.playerHP, _player.playerHP,_player.maxPlayerHP,
                        _enemy.enemyName, _enemy.beforeEnemyHP -  _enemy.enemyHP, _enemy.enemyHP,_enemy.maxEnemyHP);
    }

    public void AfterPlayerSkillStatus(Player _player) //나중에 마법여러개 일때는 바꿔야함
    {
        System.out.printf("%s을(를) 사용하여 기력을 %d 사용했다\n" +
                "기력이 %d/%d 남았다 !", _player.playerSkill[0], _player.playerSkillCost[0],
                                    _player.playerMP,_player.maxPlayerMP);
    }

}
