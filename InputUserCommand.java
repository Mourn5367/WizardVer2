import java.util.Scanner;

public class InputUserCommand
{
    private Scanner input;
    public InputUserCommand()
    {
       this.input = new Scanner(System.in);
    }

    public int InputInt(String[] _playerArray)
    {
        return ParsingInt(_playerArray);
    }

    public int ParsingInt(String[] _playerArray )
    {
        boolean noneException =false;
        int noneExceptionIntText = 0;
        while(!noneException)
        {
            try
            {
                noneExceptionIntText = Integer.parseInt(input.nextLine());
                if (noneExceptionIntText > 0 && noneExceptionIntText <= _playerArray.length )
                    //여기서 선택지를 이외의 값을 가져오면 다시 받게하자
                {
                    noneException = true;
                }
                else
                {
                    System.out.print("나는 ");
                    for (int i = 0; i < _playerArray.length; i++)
                    {
                        System.out.printf("숫자 %d\t",i+1);
                    }
                    System.out.print("말고는 못 알아먹겠어 !\n");
                    noneException = false;
                }
            }
            catch (NumberFormatException numException)
            {

                System.out.print("나는 ");
                for (int i = 0; i < _playerArray.length; i++)
                {
                    System.out.printf("숫자 %d\t",i+1);
                }
                System.out.print("말고는 못 알아먹겠어 !\n");
            }
        }
        return noneExceptionIntText;
    }

    public int SelectSkill(Player _player, Status _status)
    {
        int selectSkill = InputInt(_player.playerSkill) - 1;

        while(_player.playerMP <= _player.playerSkillCost[selectSkill])
        {
            selectSkill = InputInt(_player.playerSkill);
            _status.NotEnoughMPPrint(_player);
            _status.PlayerSelectText(_player);
        }
        return selectSkill;
    }

}
