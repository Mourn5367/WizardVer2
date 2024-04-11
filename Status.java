public class Status
{
    public void PlayerStatus(Player _player )
    {
        System.out.printf("현재 체력은 %d 현재 기력은 %d입니다."
                , _player.playerHP, _player.playerMP);
    }
}
