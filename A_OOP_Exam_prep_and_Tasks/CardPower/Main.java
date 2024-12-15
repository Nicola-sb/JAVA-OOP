package CardPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

        CardsPower cardsPower= CardsPower.valueOf(scanner.nextLine());
        SuitPower suitPower= SuitPower.valueOf(scanner.nextLine());

        int cardPower=cardsPower.getPower()+suitPower.getSuitPower();

        //: "Card name: {card name} of {suit name}; Card power: {power of rank + power of suit}".
        System.out.printf("Card name: %s of %s; Card power: %d",cardsPower,suitPower,cardPower);

    }
}
