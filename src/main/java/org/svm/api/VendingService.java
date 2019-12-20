package org.svm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.svm.api.model.Change;
import org.svm.api.model.Soda;
import org.svm.api.dao.SodaDao;

import java.util.List;

@Service
public class VendingService {
    @Autowired
    private SodaDao sodaDao;
    private Float balance;
    private int sodaSelection;
    private Change change;
    private String state;

    public VendingService(SodaDao sodaDao) {
        this.sodaDao = sodaDao;
        balance = 0.00f;
        sodaSelection = 0;
        change = null;
        state = "Initializing...";
    }

    public void insertMoney(String amount, int quantity) {
        switch (amount) {
            case "dollar":
                balance = balance + (quantity*1.00f);
                break;
            case "quarter":
                balance = balance + (quantity*0.25f);
                break;
            case "dime":
                balance = balance + (quantity*0.10f);
                break;
            case "nickel":
                balance = balance + (quantity*0.05f);
                break;
            case "penny":
                balance = balance + (quantity*0.01f);
                break;
        }
    }

    public void dispenseSoda() {
        if (sodaSelection != 0) {
            Soda soda = null;
            try {
                soda = sodaDao.getSodaById(sodaSelection);
                Float sodaPrice = soda.getPrice();
                if (soda.getQuantity() <= 0) {
                    state = "Soda Sold Out";
                } else if (balance < sodaPrice) {
                    Float rem = sodaPrice - balance;
                    state = "Please Insert $" + rem + " to get the soda";
                } else {
                    Float temp = balance - sodaPrice;
                    Change change = new Change(temp);
                    this.change = change;
                    balance = 0.00f;
                    int remSodas = soda.getQuantity() - 1;
                    soda.setQuantity(remSodas);
                    state = "Enjoy your soda";
                }
            } catch(Exception e) {
                state = "Please enter valid soda selection from the list";
            }
        }
    }

    public void returnChange() {
        Change change = new Change(balance);
        this.change = change;
        balance = 0.00f;
        sodaSelection = 0;
        state = null;
    }

    public List<Soda> getAllSodas() {
        return sodaDao.getAllSoda();
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public int getSodaSelection() {
        return sodaSelection;
    }

    public void setSodaSelection(int selection) {
        this.sodaSelection = selection;
    }

    public Soda getSodaById(int id) {
        return sodaDao.getSodaById(id);
    }

    public Change getChange() {
        return change;
    }

    public void setChange(Change change) {
        this.change = change;
    }

    @Override
    public String toString() {
        return "Soda Vending Machine{" +
                "Balance available = " + balance + "\n" +
                "sodaSelected = " + sodaSelection + "\n" +
                "change = " + change + "\n" +
                "state of machine = " + state + "\n" +
                "sodaList = " + sodaDao.getAllSoda() + '\n' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
