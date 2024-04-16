abstract class SkillUnit extends Unit
{
    int skillDMG[]; // 스킬 공격 데미지
    int criticalDMG; // 크리티컬 추가 데미지 량
    double criticalPercent; // 크리티컬 계수
    int maxMP; // 최대 MP
    int MP; // 현재 MP
    int beforeMP; // 전투가 일어나기 전 MP
    int skillCost[]; // 스킬 MP소모량
    String skill[]; // 스킬 이름
    int minCost; // 스킬중 최소 MP소모량

    int MinSkillCost() // 최소 MP소모량 구하기
    {
        int minCost = 0;
        for (int i = 0; i < skillCost.length;i++)
        {
            minCost = skillCost[0];
            if (minCost > skillCost[i])
            {
                minCost = skillCost[i];
            }
        }
        return minCost;
    }
}
