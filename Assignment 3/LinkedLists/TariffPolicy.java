package LinkedLists;
//--------------------------------------------------------------------
//Assignment 3
//Question: Part2
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------


/**
 * An interface defining the policy for evaluating trade tariffs.
 * Implementing classes must provide logic for assessing whether a trade proposal
 * meets the required tariff thresholds and determining the appropriate response.
 */
public interface TariffPolicy {

	
	/**
     * Evaluates a proposed trade based on tariff requirements.
     *
     * @param requestID       the unique identifier for the trade request
     * @param proposedTariff  the tariff rate proposed by the requester
     * @param minimumTariff   the minimum tariff rate required to accept the trade
     * @param tradeValue      the total monetary value of the trade
     * @return a string message indicating whether the trade is accepted,
     *         conditionally accepted with a surcharge, or rejected
     */
	String evaluateTrade(String requestID,double proposedTariff, double minimumTariff, double tradeValue);
}
