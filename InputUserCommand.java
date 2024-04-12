import java.util.Scanner;

public class InputUserCommand
{
    private Scanner input;
    public InputUserCommand()
    {
       this.input = new Scanner(System.in);
    }

    public int InputInt(Player _player)
    {
        return ParsingInt(_player);
    }

    public int ParsingInt(Player _player)
    {
        boolean noneException =false;
        int noneExceptionIntText = 0;
        while(!noneException)
        {
            try
            {
                noneExceptionIntText = Integer.parseInt(input.nextLine());

                if (noneExceptionIntText > 0 && noneExceptionIntText <= _player.playerableAct.length ) //여기서 선택지를 이외의 값을 가져오면 다시 받게하자
                {
                    noneException = true;

                }
                else
                {
                    System.out.print("나는 ");
                    for (int i = 0; i < _player.playerableAct.length; i++)
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
                for (int i = 0; i < _player.playerableAct.length; i++)
                {
                    System.out.printf("숫자 %d\t",i+1);
                }
                System.out.print("말고는 못 알아먹겠어 !\n");
            }
        }

        return noneExceptionIntText;

    }

    public void IsNotEnoughMPCost(Player _player, Status _status)
    {
        _status.NotEnoughMPPrint(_player);
        _status.PlayerSelectText(_player);
        InputInt(_player);

    }

}
