package com.codurance;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
/**
 * 
 * transaction est une operation sur le compte avec une date .
 * 
 * @author ykhekhone
 * @date 4 avr. 2020
 */
public class Transaction
{
    /** date de la transaction */
    private final String date;
    /** valeur de la transaction */
    private final int amount;
    /**
     * 
     * Constructeur.
     * @param date
     * @param amount
     */
    public Transaction(String date, int amount)
    {
        this.date = date;
        this.amount = amount;
    }
    /**
     * valeur de l operation
     * @return
     */
    public int amount()
    {
        return amount;
    }
    /**
     * date de l operation
     * @return
     */
    public String date()
    {
        return date;
    }

    @Override
    public boolean equals(Object o)
    {
        return reflectionEquals(this, o);
    }

    @Override
    public int hashCode()
    {
        return reflectionHashCode(this);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("Transaction{");
        return builder.append("date='").append(date).append(", amount=").append(amount).append('\'').append('}').toString();
    }
}
