import java.util.Scanner;

public class InputUserCommand
{
    public Scanner scanner;
    public InputUserCommand()
    {
       this.scanner = new Scanner(System.in);
    } // 객체가 생성될때 스캐너 객체 생성

    public int InputArray(String[] _inputArray)
    {
        return ParsingInt(_inputArray);
    }
    // 행동 선택지를 넣고 유저가 숫자 입력값을 반환 

    public int ParsingInt(String[] _inputArray ) // 선택지 이외의 숫자, 숫자 이외의 값을 거르기 위해
    {
        boolean noneException =false;
        int noneExceptionIntText = 0;
        while(!noneException)
        {
            try
            {
                noneExceptionIntText = Integer.parseInt(scanner.nextLine());
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

    public int SelectSkill(SkillUnit _skillUnit, Status _status) // 어떤 스킬을 고를지 입력받음
    {
        int selectSkill = InputArray(_skillUnit.skill) - 1;

        while(_skillUnit.MP < _skillUnit.skillCost[selectSkill])
        {
            _status.NotEnoughMPPrint(_skillUnit,selectSkill);
            _status.SelectText(_skillUnit.skill);
            selectSkill = InputArray(_skillUnit.skill) - 1;
        }
        return selectSkill;
    }

    public void SetName(Unit _unit,Status status) // 유닛을 작명함
    {

        int maxNameLength = 7;
        String setNameMenu[] = {"작명한다.","기본이름으로"};
        status.SelectText(setNameMenu);
        int inputMenu = ParsingInt(setNameMenu);
        if (inputMenu == 1)
        {

            System.out.print("이름을 입력하세요 최대 7 글자까지 됩니다. :");
            while(true)
            {
                String unitName = scanner.nextLine();
                if (unitName.length() > maxNameLength)
                {
                    System.out.println("7글자를 초과하였습니다.");
                    System.out.print("이름을 입력하세요 최대 7 글자까지 됩니다. :");
                }
                else
                {
                    _unit.name = unitName;
                    break;
                }
            }
        }
        System.out.printf("\n당신의 이름은 %s입니다 !\n\n",_unit.name);
    }
}
