// 2024_04_16_알고리즘_실습과제
// 한국폴리텍대학_서울정수캠퍼스_인공지능소프트웨어학과
// 2401110252_박지수
// 마법사로 몬스터를 물리치는 게임
// https://github.com/Mourn5367/WizardVer2
public class WizardGame
{
    public static void main(String[] args) throws InterruptedException {
        InputUserCommand inputUserCommand = new InputUserCommand();
        CombatCondition combatCondition = new CombatCondition();
        Status status = new Status();
        Combat combat = new Combat();
        Player player = new Player();
        Enemy enemy = new Enemy();

        player.SetWizard(player); // 유저는 Wizard 적은 Monster 세팅 
        enemy.SetMonster(enemy);
        status.GameLoadingText();

        inputUserCommand.SetName(player,status); // 작명 여부

        status.MeetingScene(player,enemy);

        while(true)
        {
            status.SelectText(player.ableList); // 선택지 출력
            combat.UnitAttack(inputUserCommand.InputArray(player.ableList),player,enemy
                    ,status,inputUserCommand); // 유저 공격
            if(!combatCondition.IsEscape(enemy,status)) {break;} // 적이 죽었는지 검사
            status.UnitStatus(enemy); // 적 상태  출력
            combat.UnitAttack(1,enemy,player
                    ,status,inputUserCommand); // 적이 입력을 못받아 기본공격하게 입력설정함
            if(!combatCondition.IsEscape(player,status)) {break;} // 유저가 죽었는지 검사
            status.UnitStatus(player); // 유저 상태 출력
            status.AfterCombatStatusSymbol(player,enemy); // 전투 요약
        }
    }
}