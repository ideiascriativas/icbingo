package br.com.ideiascriativas.icbingo;

import br.com.ideiascriativas.icbingo.exceptions.CardException;
import br.com.ideiascriativas.icbingo.model.Bingo;
import br.com.ideiascriativas.icbingo.model.Card;
import br.com.ideiascriativas.icbingo.services.CardService;

import java.util.List;

public class Test {

    public static void main(String[] args) throws CardException {

        CardService cardService = new CardService();
//
        Bingo b = new Bingo();
        b.setBallsToCard(25);
        b.setBallsToSort(75);
        b.setSizeArrayToCards(5);

        cardService.generateCards(b, 20000);

        List<Card> cardsGenerate = b.getCardsGenerate();
        System.out.println("cardsGenerate.size() = " + cardsGenerate.size());
//        cardsGenerate.forEach(card -> {
//            Arrays.stream(card.getTable()).forEach(line -> {
//                Arrays.stream(line).forEach(v -> {
//                    String value = v < 10 ? "0"+ v : v + "";
//                    System.out.print(value + " ");
//                });
//                System.out.println("");
//            });
//            System.out.println("\n");
//        });

//        int[][] card = new int[5][5];
//        int[][] card2 = new int[5][5];
//
//        for (int i = 0; i < 5; i++){
//            for (int j = 0; j < 5; j++){
//                card[i][j] = 2;
//                card2[i][j] = 2;
//            }
//        }

//        Card c = new Card();
//        c.setTable(card);
//        b.addCard(c);
//        card2[2][4] = 1;
//        boolean repeatedCard = cardService.isRepeatedCard(card2, b.getCardsGenerate());
//        System.out.println("repeatedCard = " + repeatedCard);
    }
}
