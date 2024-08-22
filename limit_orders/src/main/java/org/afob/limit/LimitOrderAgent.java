package org.afob.limit;

import org.afob.execution.ExecutionClient;
import org.afob.prices.PriceListener;

import java.math.BigDecimal;

public class LimitOrderAgent implements PriceListener {

    private final ExecutionClient m_executionClient ;
    public LimitOrderAgent(final ExecutionClient ec) {
        m_executionClient = ec;
    }


    @Override
    public void priceTick(String productId, BigDecimal price) {
        
        if ( "IBM".equals(productId) && price != null && price < 100) {
            m_executionClient.buy();
        }    
    }

    public void addOrder(TransactionType transactionType, String productId, 
                        int  amount, int limit) {

        if( transactionType == TransactionType.BUY) {
            if ( "IBM".equals(productId)  &&  price < 100) {
               
                m_executionClient.buy(productId, amount);
            } else {
                m_executionClient.buy(productId, amount);
            }
        } else if (transactionType == TransactionType.SELL) {

            m_executionClient.sell(productId, amount);
        }
        
    }

}

public enum TransactionType {
    BUY,
    SELL;

}
