package br.com.ideiascriativas.icbingo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Bingo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int ballsToSort;
    private int ballsToCard;
    private LocalDate dateOfBingo;
    private int numberTurn;
    private int limitCards;
    private int sizeArrayToCards;

    private List<Card> cardsGenerate;
    private List<Lot> lotsValidation;

    public Bingo() {
        this.cardsGenerate = new LinkedList<>();
        this.lotsValidation = new LinkedList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBallsToSort() {
        return ballsToSort;
    }

    public void setBallsToSort(int ballsToSort) {
        this.ballsToSort = ballsToSort;
    }

    public int getBallsToCard() {
        return ballsToCard;
    }

    public void setBallsToCard(int ballsToCard) {
        this.ballsToCard = ballsToCard;
    }

    public LocalDate getDateOfBingo() {
        return dateOfBingo;
    }

    public void setDateOfBingo(LocalDate dateOfBingo) {
        this.dateOfBingo = dateOfBingo;
    }

    public int getNumberTurn() {
        return numberTurn;
    }

    public void setNumberTurn(int numberTurn) {
        this.numberTurn = numberTurn;
    }

    public int getLimitCards() {
        return limitCards;
    }

    public void setLimitCards(int limitCards) {
        this.limitCards = limitCards;
    }

    public int getSizeArrayToCards() {
        return sizeArrayToCards;
    }

    public void setSizeArrayToCards(int sizeArrayToCards) {
        this.sizeArrayToCards = sizeArrayToCards;
    }

    public List<Card> getCardsGenerate() {
        return cardsGenerate;
    }

    public void setCardsGenerate(List<Card> cardsGenerate) {
        this.cardsGenerate = cardsGenerate;
    }

    public List<Lot> getLotsValidation() {
        return lotsValidation;
    }

    public void setLotsValidation(List<Lot> lotsValidation) {
        this.lotsValidation = lotsValidation;
    }

    public int getRemainingCardsToGenerate() {
        return this.limitCards - this.cardsGenerate.size();
    }

    public void addCard(Card card) {
        this.cardsGenerate.add(card);
    }

    public void removeCard(Card card) {
        this.cardsGenerate.remove(card);
    }
}
