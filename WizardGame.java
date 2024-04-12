public class WizardGame
{
    public static void main(String[] args)
    {
        Player player = new Player();
        Enemy enemy = new Enemy();
        Status status = new Status();
        Combat combat = new Combat();
        InputUserCommand inputUserCommand = new InputUserCommand();
        CombatCondition combatCondition = new CombatCondition();
        status.MeetingScene(player,enemy);

        while (true)
        {
            status.EnemyStatus(enemy);
            status.PlayerStatus(player);
            status.PlayerSelectText(player);

            combat.PlayerAttack(inputUserCommand.InputInt(player), player,enemy,
                                status,combatCondition);
            if (!combatCondition.isEscape(player,enemy,status) )break;
            combat.EnemyAttack(player,enemy);
            if (!combatCondition.isEscape(player,enemy,status) )break;
            status.AfterCombatStatus(player,enemy);
        }
        System.out.println("모험 끝");

    }
}
