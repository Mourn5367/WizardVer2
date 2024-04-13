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

        inputUserCommand.SetName(player,status);

        status.MeetingScene(player,enemy);

        while(true)
        {
            status.SelectText(player.ableList);
            combat.UnitAttack(inputUserCommand.InputInt(player.ableList),player,enemy
                    ,status,inputUserCommand);
            if(!combatCondition.IsEscape(enemy,status)) {break;}
            status.UnitStatus(enemy);
            combat.OriginAttack(enemy,player);
            if(!combatCondition.IsEscape(player,status)) {break;}
            status.UnitStatus(player);
            status.AfterCombatStatusSymbol(player,enemy);
        }
    }
}
