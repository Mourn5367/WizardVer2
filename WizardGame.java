public class WizardGame
{
    public static void main(String[] args) throws InterruptedException {
        InputUserCommand inputUserCommand = new InputUserCommand();
        CombatCondition combatCondition = new CombatCondition();
        Status status = new Status();
        Combat combat = new Combat();
        Player player = new Player();
        Enemy enemy = new Enemy();

        player.SetWizard(player);
        enemy.SetMonster(enemy);
        status.GameLoadingText();

        inputUserCommand.SetName(player,status);

        status.MeetingScene(player,enemy);

        while(true)
        {
            status.SelectText(player.ableList);
            combat.UnitAttack(inputUserCommand.InputArray(player.ableList),player,enemy
                    ,status,inputUserCommand);
            if(!combatCondition.IsEscape(enemy,status)) {break;}
            status.UnitStatus(enemy);
            combat.UnitAttack(1,enemy,player
                    ,status,inputUserCommand);
            if(!combatCondition.IsEscape(player,status)) {break;}
            status.UnitStatus(player);
            status.AfterCombatStatusSymbol(player,enemy);
        }
    }
}