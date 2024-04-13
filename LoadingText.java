import java.util.Random;
public interface LoadingText {
    Random random = new Random();
    default void LoadingTextPrint() throws InterruptedException {
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
}
