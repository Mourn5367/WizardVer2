public class WizardGame
{
    public static void main(String[] args)
    {
        Player player = new Player();
        Enemy enemy = new Enemy();
        Status status = new Status();
        Combat combat = new Combat();
        InputUserCommand inputUserCommand = new InputUserCommand();


        for (int i =0; i < 1000; i++)
        {
            combat.PlayerSkillAttack(player,enemy,combat.CreatRandomValue());
        }


    }
}
