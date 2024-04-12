import java.util.Scanner;

public class InputUserCommand
{
    private Scanner input;
    public InputUserCommand()
    {
       this.input = new Scanner(System.in);
    }

    public int InputInt()
    {
        System.out.print("명령을 입력 해 주세요\n");
        System.out.print("1. asd\t2. asd\t3. asd\n");

        return ParsingInt();

    }

    public int ParsingInt()
    {
        boolean noneException =true;
        int noneExceptionIntText = 0;
        while(!noneException)
        {
            try
            {
                noneExceptionIntText = Integer.parseInt(input.nextLine());

                if (noneExceptionIntText != 1) //여기서 선택지를 이외의 값을 가져오면 다시 받게하자
                {
                    noneException = false;
                }
                else
                {
                    noneException = true;
                }
            }
            catch (NumberFormatException numException)
            {
                System.out.println("못알아먹겠어 !");
            }
        }

        return noneExceptionIntText;

    }


}
