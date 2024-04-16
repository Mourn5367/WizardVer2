import java.util.Random;
public interface LoadingText {
    Random random = new Random();
    default void LoadingTextPrint() throws InterruptedException
            // 확률적인 일이 생길때 넣을 로딩 텍스트
            // 현재 마법공격에만 있어 그곳에만 넣고있음
    {
        int loadingText = random.nextInt(4,8);
        for (int i = 1; i <loadingText; i++)
        {
            if ( i % 2 == 0)
            {
                System.out.print("☆");
                Thread.sleep(500);
            }
            else
            {
                System.out.print("★");
                Thread.sleep(500);
            }
        }
        System.out.println();
    }

    default void GameLoadingText() throws InterruptedException
    // 게임 구동 시 실행될 로딩 창
    {
        int loadingText = random.nextInt(2,4);

        System.out.print("마법사와 몬스터 구동중");
        for (int i =0; i < 3; i++)
        {
            System.out.print(". ");
            Thread.sleep(1000);
        }
        System.out.print("\n");
        System.out.print("준비가 거의 다 되었습니다.\n");
        System.out.print("[");
        for (int i =0; i < loadingText; i++)
        {
            System.out.print("|");
            Thread.sleep(random.nextInt(1000, 2000));
        }
       for (int i = 0;i <3; i++)
       {
           System.out.print("|");
           Thread.sleep(300);
       }
        System.out.print("]\n");
        System.out.println("준비되었습니다.");
        Thread.sleep(1000);
    }
}
