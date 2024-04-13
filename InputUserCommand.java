import java.util.Scanner;

public class InputUserCommand
{
    private Scanner input;
    public InputUserCommand()
    {
       this.input = new Scanner(System.in);
    }

    public int InputInt(String[] _inputArray)
    {
        return ParsingInt(_inputArray);
    }

    public int ParsingInt(String[] _inputArray )
    {
        boolean noneException =false;
        int noneExceptionIntText = 0;
        while(!noneException)
        {
            try
            {
                noneExceptionIntText = Integer.parseInt(input.nextLine());
                if (noneExceptionIntText > 0 && noneExceptionIntText <= _inputArray.length )
                    //여기서 선택지를 이외의 값을 가져오면 다시 받게하자
                {
                    noneException = true;
                }
                else
                {
                    System.out.print("나는 ");
                    for (int i = 0; i < _inputArray.length; i++)
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
                for (int i = 0; i < _inputArray.length; i++)
                {
                    System.out.printf("숫자 %d\t",i+1);
                }
                System.out.print("말고는 못 알아먹겠어 !\n");
            }
        }
        return noneExceptionIntText;
    }

    public int SelectSkill(SkillUnit _skillUnit, Status _status)
    {
        int selectSkill = InputInt(_skillUnit.skill) - 1;

        while(_skillUnit.MP <= _skillUnit.skillCost[selectSkill])
        {
            selectSkill = InputInt(_skillUnit.skill);
            _status.NotEnoughMPPrint(_skillUnit,selectSkill);
            _status.SkillUnitSelectText(_skillUnit);
        }
        return selectSkill;
    }

    public void SetName(Unit _unit,Status status)
    {
        String setNameMenu[] = {"작명한다.","기본이름으로"};
        status.SelectText(setNameMenu);
        int inputMenu = ParsingInt(setNameMenu);
        if (inputMenu == 1)
        {
            System.out.print("이름을 입력하세요 :");
            _unit.name = input.nextLine();
        }
        System.out.printf("당신의 이름은 %s입니다 !\n",_unit.name);
    }
}
