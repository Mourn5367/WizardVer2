abstract class SkillUnit extends Unit
{
    int skillDMG[];
    int criticalDMG;
    int maxMP;
    int MP;
    int beforeMP;
    int skillCost[];
    String skill[];
    int minCost;

    int MinSkillCost()
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
