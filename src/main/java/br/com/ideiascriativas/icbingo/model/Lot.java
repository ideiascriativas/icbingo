package br.com.ideiascriativas.icbingo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Lot implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Long numberLot;
    @OneToMany
    private List<Card> cards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberLot() {
        return numberLot;
    }

    public void setNumberLot(Long numberLot) {
        this.numberLot = numberLot;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
