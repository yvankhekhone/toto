package com.codurance;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
/**
 * 
 * Transaction dun compte.
 * 
 * @author ykhekhone
 * @date 4 avr. 2020
 */
public class Transactions
{
    private List<Transaction> transactionList = new ArrayList<>();
    /**
     * Ajout d 'une operation sur un compte
     * @param transaction
     */
    public void add(Transaction transaction)
    {
        transactionList.add(transaction);
    }
    /**
     * Récuperation de tous les transaction d un compte
     * @return
     */
    public List<Transaction> all()
    {
        return unmodifiableList(transactionList);
    }
}
