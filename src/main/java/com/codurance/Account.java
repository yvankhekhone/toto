package com.codurance;

/**
 * 
 * Account.
 * 
 * @author ykhekhone
 * @date 4 avr. 2020
 */
public class Account
{

    /** Recupere la date instant et formaté */
    private Clock clock;
    /** historique des transactions */
    private Transactions transactions;
    /** affichage */
    private StatementPrinter statementPrinter;

    /**
     * 
     * Constructeur.
     * @param clock
     * @param transactions
     * @param statementPrinter
     */
    public Account(Clock clock, Transactions transactions, StatementPrinter statementPrinter)
    {
        
        this.clock = clock;
        this.transactions = transactions;
        this.statementPrinter = statementPrinter;
    }
    /**
     * Ajoute amount dans le compte
     * @param amount
     */
    public void deposit(int amount)
    {
        Transaction deposit = new Transaction(clock.dateAsString(), amount);
        transactions.add(deposit);
    }
    /**
     * Retire la valeur du compte
     * @param amount
     */
    public void withdraw(int amount)
    {
        Transaction deposit = new Transaction(clock.dateAsString(), -amount);
        transactions.add(deposit);
    }
    /**
     * affiche toutes les transactions d'un compte
     */
    public void printStatement()
    {
        statementPrinter.print(transactions.all());
    }

}
