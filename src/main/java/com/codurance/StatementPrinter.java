package com.codurance;

import static com.google.common.collect.Lists.reverse;
import static java.util.stream.Collectors.toList;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import com.codurance.bankkata.Console;
/**
 * 
 * StatementPrinter gestion de l 'affichage d un compte.
 * 
 * @author ykhekhone
 * @date 4 avr. 2020
 */
public class StatementPrinter
{

    private static final String STRING = " | ";

    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

    private Console console;
    /*
     * Constructor
     */
    public StatementPrinter(Console console)
    {
        this.console = console;
    }
    /**
     * affiche les transactions sur le compte avec affichage du header
     * @param transactionList
     */
    public void print(List<Transaction> transactionList)
    {
        printHeader();
        printStatementLinesFor(transactionList);
    }
    /**
     * Affiche un header DATE | AMOUNT | BALANCE
     */
    private void printHeader()
    {
        console.printLine(STATEMENT_HEADER);
    }
    /**
     * Affiche les lignes de facon decroissant à lordre d'insertion dans la liste transactionList
     * @param transactionList
     */
    private void printStatementLinesFor(List<Transaction> transactionList)
    {
        List<String> statementLines = statementLines(transactionList);
        reverse(statementLines).forEach(console::printLine);
    }
    /**
     * Format les transaction
     * @param transactionList
     * @return
     */
    private List<String> statementLines(List<Transaction> transactionList)
    {
        AtomicInteger runningBalance = new AtomicInteger(0);
        return transactionList.stream()
                .map(transaction -> statementLine(runningBalance, transaction)).collect(toList());
    }
    /**
     * Format l'affiche d un transation
     * @param runningBalance
     * @param t
     * @return
     */
    private String statementLine(AtomicInteger runningBalance, Transaction t)
    {
        return t.date().concat(STRING).concat(formatDecimal(t.amount()))
                .concat(STRING).concat(formatDecimal(runningBalance.addAndGet(t.amount())));
    }
    /**
     * Formatte montant
     * @param amount
     * @return
     */
    private String formatDecimal(int amount)
    {

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
        return decimalFormat.format(amount);
    }
}
