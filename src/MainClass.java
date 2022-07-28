import java.util.Scanner;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        int playerNum = 10; // 유저 구슬 갯수
        int computerNum = 10; // 컴퓨터 구슬 갯수
        int playerInputNum;
        String result; //dddd
        String userAnswer;


        System.out.println("오징어 게임에 오신것을 환영합니다.");
        System.out.println("이번 게임은 구슬 게임입니다.");
        System.out.println("당신과 나는 각각 10개의 구슬을 가지고 있습니다.");
        System.out.println("10개의 구슬을 다 잃으면 죽습니다.");
        System.out.println("시작합니다.");

        while (true) {
            Scanner sc = new Scanner(System.in); // 입력받기 위한 준비
            // 여기서 부터 반복 배팅 조건이 안맞으면 계속 반복
            while (true) {
                System.out.print("배팅 하세요. >> ");
                //배팅 숫자를 입력받기
                playerInputNum = sc.nextInt(); // 숫자를 입력받아서 변수에 저장
                if (playerInputNum > playerNum) {
                    System.out.println("보유한 구슬보다 많이 배팅할 수 없습니다.");
                } else {
                    System.out.println("당신은 " + playerInputNum + " 개의 구슬을 배팅했습니다.");
                    System.out.println("게임 진행!");
                    break;
                }
            }
            System.out.println("맞춰봐~");
            Random random = new Random(); // 랜덤을 사용하기 위한 준비
            int computerInput = random.nextInt(computerNum) + 1; // 1~9까지 숫자가 랜덤으로 나오게
            System.out.println("컴퓨터가 구슬을 내고 있습니다..");

            if (computerInput % 2 == 1) {
                result = "홀";
            } else {
                result = "짝";
            }
            System.out.println("완료!");

            System.out.print("홀짝 입력 >> ");
            userAnswer = sc.next();
            if (userAnswer == result) {
                System.out.println("승리!");
                System.out.println("컴퓨터가 낸 구슬 " + computerInput + " 개를 가져옵니다.");
                playerNum += computerInput;
                computerNum -= computerInput;
            } else {
                System.out.println("패배!");
                System.out.println("컴퓨터가 당신이 배팅한 구슬 " + playerInputNum + " 개를 가져갑니다.");
                playerNum -= playerInputNum;
                computerNum += playerInputNum;
            }
            System.out.println("[현재 구슬 갯수]");
            System.out.println("컴퓨터 : " + computerNum + " 플레이어 : " + playerNum);
            if(playerNum == 0){
                System.out.println("빵! 당신은 죽었습니다.");
                break;
            }else if(computerNum == 0){
                System.out.println("빵! 컴퓨터가 죽었습니다.");
                break;
            }
        }


    }
}