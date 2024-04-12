


public class Status
{

    public void TimeSleep(int _time,String _message)
    {
        for (int i = 0; i < 3; i++ )
        {
            System.out.printf("%s",_message);
            try {Thread.sleep(_time);}
            catch (InterruptedException InterException)
            {InterException.printStackTrace();}
        }
    }

    public void MeetingScene(Player _player,Enemy _enemy)
    {
        TimeSleep(1,"몬스터 접근중 !\n");

        System.out.printf("마법사 %s(이)가 야생의 %s를 만났다!!\n\n",_player.playerName,_enemy.enemyName);
    }

    public void EnemyStatus(Enemy _enemy)
    {
        System.out.printf("적: %s 체력: %d/%d.\n"
                ,_enemy.enemyName, _enemy.enemyHP, _enemy.maxEnemyHP);
    }

    public void PlayerStatus(Player _player )
    {
        System.out.printf("마법사: %s 체력: %d/%d 기력: %d/%d.\n"
                ,_player.playerName, _player.playerHP, _player.maxPlayerHP,  _player.playerMP,_player.maxPlayerMP);
    }

    public void PlayerSelectText(Player _player)
    {
        for (int i = 0; i < _player.playerableAct.length; i++)
        {
            System.out.printf("%d. %s\t",i+1,_player.playerableAct[i]);
        }
        System.out.println();
    }
    public void AfterCombatStatus(Player _player, Enemy _enemy)
    {
        System.out.printf("%s(이)가 %d의 피해를 입어 %d/%d의 체력이 되었고 %s(이)가 %d의 피해를 입어 %d/%d 체력이 되었다!\n"
                ,_player.playerName, _player.beforePlayerHP - _player.playerHP, _player.playerHP,_player.maxPlayerHP,
                        _enemy.enemyName, _enemy.beforeEnemyHP -  _enemy.enemyHP, _enemy.enemyHP,_enemy.maxEnemyHP);
    }

    public void AfterPlayerSkillStatus(Player _player) //나중에 마법여러개 일때는 바꿔야함
    {
        System.out.printf("%s을(를) 사용하여 기력을 %d 사용했다\n" +
                "기력이 %d/%d 남았다 !", _player.playerSkill[0], _player.playerSkillCost[0],
                                    _player.playerMP,_player.maxPlayerMP);
    }

    public void EndCombatPrint(int _escapeCombatConditionNum, Player _player, Enemy _enemy)
    {
        if ( _escapeCombatConditionNum == 0)
        {
            EnemyStatus(_enemy);
            System.out.printf("남겨둔채 %s(이)가 쓰러졌다..!!!\n",_player.playerName);

        }
        else if (_escapeCombatConditionNum == 1)
        {
            PlayerStatus(_player);
            System.out.printf("상태로 %s(을)를 쓰러뜨렸다..!!!\n",_enemy.enemyName);

        }
        else
        {
            System.out.println("격렬한 전투중이다.");
        }
    }

    public void NotEnoughMPPrint(Player _player) // 스킬 추가 되면 변경
    {
        System.out.printf("기력이 %d이므로 기력 %d(을)를 소모하는 %s을 할수없어 !!\n"
                ,_player.playerMP,_player.playerSkillCost[0],_player.playerableAct[1]);

    }

    public void PlayerSkillPrint(Player _player)
    {
        for (int i = 0; i < _player.playerSkill.length;i++)
        {
            System.out.printf("%d. ",i+1);
            System.out.printf("%s ",_player.playerSkill[i]);
        }
        System.out.println();
    }
}
