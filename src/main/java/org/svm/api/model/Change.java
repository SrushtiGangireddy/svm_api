package org.svm.api.model;

public class Change {
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    public Change(Float balance) {
        pennies = Integer.parseInt(balance.toString().replace(".", ""));
        quarters = pennies / 25;
        pennies %= 25;
        dimes = pennies / 10;
        pennies %= 10;
        nickels = pennies / 5;
        pennies %= 5;
    }

    public int getQuarters() {
        return this.quarters;
    }

    public int getDimes() {
        return this.dimes;
    }

    public int getNickels() {
        return this.nickels;
    }

    public int getPennies() {
        return this.pennies;
    }
}
