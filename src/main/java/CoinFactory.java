public class CoinFactory
{
    public Coin getCoin(String coinType)
    {
        if(coinType == null)
            return null;

        if(coinType.equalsIgnoreCase("ILS"))
        {
            return new ILS();
        } else if (coinType.equalsIgnoreCase("USD"))
        {
            return new USD();
        }
        return null;
    }
}
