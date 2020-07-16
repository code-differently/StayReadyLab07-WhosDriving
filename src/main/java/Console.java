import java.util.Scanner;

public class Console{
    private Scanner inputSource;

    public Console(Scanner inputSource) {
        this.inputSource = inputSource;

    }

    public String getInput() {
        return this.inputSource.nextLine();
    }
}
