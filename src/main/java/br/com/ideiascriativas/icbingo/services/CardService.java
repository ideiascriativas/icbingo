package br.com.ideiascriativas.icbingo.services;

import br.com.ideiascriativas.icbingo.exceptions.CardException;
import br.com.ideiascriativas.icbingo.model.Bingo;
import br.com.ideiascriativas.icbingo.model.Card;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CardService {

    private RandomService rs;

    public CardService() {
        this.rs = new RandomService();
    }

    /**
     * Método para gerar uma certa quantidade cartelas para o Bingo recebido por parâmetro.
     *
     * @param bingo
     * @param quantity
     * @throws CardException
     */
    public void generateCards(Bingo bingo, int quantity) throws CardException {
        // Matriz sizeArrayToCards X sizeArrayToCards
        int sizeArrayToCards = bingo.getSizeArrayToCards();
        // quantidade de bolas no total do sorteio do Bingo
        int ballsToSort = bingo.getBallsToSort();
        //verificando se o número de bolas do sorteio é dívisivel pelo o tamanho da matriz escolhida para o bingo.
        if (ballsToSort % sizeArrayToCards != 0) {
            throw new CardException("A tamanho da matriz para a cartela não é divisível pelo número de bolas do sorteio.");
        }
        //obtendo a faixa de número para ser gerado por cada linha da matriz.
        int numberRange = ballsToSort / sizeArrayToCards;
        //gerando o número de cartelas recebido por parâmetro.
        for (int i = 0; i < quantity; i++) {
            int[][] card = generateCard(bingo.getSizeArrayToCards(), numberRange);
            while (isRepeatedCard(card, bingo.getCardsGenerate())) {
                card = generateCard(bingo.getSizeArrayToCards(), numberRange);
            }
            Card c = new Card();
            c.setTable(card);
            bingo.addCard(c);
        }
    }

    /**
     * Método para criar todas cartelas que ainda podem ser geradas para o Bingo recebido por parâmetro.
     *
     * @param bingo
     * @throws CardException
     */
    public void generateCards(Bingo bingo) throws CardException {
        //obtendo a quantia restante de quantas cartelas ainda podem ser geradas para o bingo.
        int remainingCardsToGenerate = bingo.getRemainingCardsToGenerate();
        //gerando todas cartelas restante
        this.generateCards(bingo, remainingCardsToGenerate);
    }

    /**
     * Gera uma cartela pelo tamanho definido no primeiro parâmetro, sendo o segundo parâmetro uma faixa
     * para gerar números entre essa quantidade.
     * <p>
     * Ex: generateCard(2, 10);
     * <p>
     * card = [ 1, 10 ]
     * [ 11, 20 ]
     *
     * @param sizeArrayToCards
     * @param rangeNumber
     * @return Retorna a cartela em matriz int[][]
     */
    private int[][] generateCard(int sizeArrayToCards, int rangeNumber) {
        int[][] card = new int[sizeArrayToCards][sizeArrayToCards];
        int min = 0;
        for (int i = 0; i < sizeArrayToCards; i++) {
            card[i] = rs.randomLine(sizeArrayToCards, rangeNumber, min);
            min += rangeNumber;
        }
        return card;
    }

    public boolean isRepeatedCard(int[][] card, List<Card> cards) {
        if (cards.size() == 0) {
            return false;
        }
        // Percorrer todos as cartelas criadas
        for (Card card1 : cards) {
            //Percorrer a linha da cartela criada com a cartela da vez já adicionada.
            boolean stopCompare = false;
            for (int j = 0; j < card.length; j++) {
                //Percorrendo a coluna da cartela criada com a cartela da vez já adicionada.
                for (int k = 0; k < card.length; k++) {
                    if (card[j][k] != card1.getTable()[j][k]) {
                        stopCompare = true;
                        break;
                    }
                }
                if (stopCompare) {
                    break;
                }
            }
            if (!stopCompare) {
                System.out.println("Repetiu");
                return true;
            }
        }
        return false;
    }
}
