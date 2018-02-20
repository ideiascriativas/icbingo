package br.com.ideiascriativas.icbingo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Card implements Serializable{

    @Id
    private Long id;
    @Column(unique = true)
    private String serial_bar;
    private boolean sale;
    private boolean winner;
    private int[][] table;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial_bar() {
        return serial_bar;
    }

    public void setSerial_bar(String serial_bar) {
        this.serial_bar = serial_bar;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public int[][] getTable() {
        return table;
    }

    public void setTable(int[][] table) {
        this.table = table;
    }
}
