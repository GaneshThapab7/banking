package com.banking.Model;

import javax.persistence.*;

@Entity
public class Number_Generator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "prefixNo")
    private int prefixNo;

    @Column(name = "startingPrefixNo")
    private int startingPrefixNo;

    @Column(name = "prefixWord")
    private String prefixWord;

    @Column(name = "displayNo")
    private String displayNo;

    public Number_Generator() {
    }


    public Number_Generator(int id, String name, int prefixNo, int startingPrefixNo, String prefixWord, String displayNo) {
        this.id = id;
        this.name = name;
        this.prefixNo = prefixNo;
        this.startingPrefixNo = startingPrefixNo;
        this.prefixWord = prefixWord;
        this.displayNo = displayNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrefixNo() {
        return prefixNo;
    }

    public void setPrefixNo(int prefixNo) {
        this.prefixNo = prefixNo;
    }

    public int getStartingPrefixNo() {
        return startingPrefixNo;
    }

    public void setStartingPrefixNo(int startingPrefixNo) {
        this.startingPrefixNo = startingPrefixNo;
    }

    public String getPrefixWord() {
        return prefixWord;
    }

    public void setPrefixWord(String prefixWord) {
        this.prefixWord = prefixWord;
    }

    public String getDisplayNo() {
        return displayNo;
    }

    public void setDisplayNo(String displayNo) {
        this.displayNo = displayNo;
    }
}