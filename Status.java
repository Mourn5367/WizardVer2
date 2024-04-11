public class Status
{
    public void PlayerStatus(Player _player )
    {
        System.out.printf("체력 %d/%d 현재 기력은 %d/%d입니다."
                , _player.playerHP, _player.maxPlayerHP,  _player.playerMP,_player.maxPlayerMP);
    }
}
