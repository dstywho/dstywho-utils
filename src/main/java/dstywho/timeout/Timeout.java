package dstywho.timeout;

import org.joda.time.Duration;

public class Timeout {

    public static final Timeout TIMEOUT_ONE_SECONDs    = new Timeout(1000);
    public static final Timeout TIMEOUT_ONE_SECOND     = new Timeout(1000);

    public static final Timeout TIMEOUT_TWO_SECONDS    = new Timeout(2000);

    public static final Timeout TIMEOUT_FIVE_SECONDS   = new Timeout(5000);

    public static final Timeout TIMEOUT_TEN_SECONDS    = new Timeout(10000);

    public static final Timeout TIMEOUT_THIRTY_SECONDS = new Timeout(30000);

    public static final Timeout SIXTY_SECONDS          = new Timeout(60000);

    public static final Timeout TIMEOUT_TWENTY_SECONDS = new Timeout(20000);

    private final int           milliseconds;

    public Timeout(final String timeoutInMilliseconds)
        {
            this.milliseconds = Integer.parseInt(timeoutInMilliseconds);
        }

    public Timeout(final int timeoutInMilliseconds)
        {
            this.milliseconds = timeoutInMilliseconds;
        }

    public Timeout(final Duration duration)
        {
            this.milliseconds = (int) duration.getMillis();
        }

    @Override
    public String toString()
        {
            return milliseconds + "";
        }

    public String toS()
        {
            return toString();
        }

    public int toSeconds()
        {
            return milliseconds / 1000;
        }

    public long toLong()
        {
            return new Long(milliseconds);
        }

    public Duration toDuration()
        {
            return new Duration(milliseconds);
        }

    public void sleep()
        {
            try
                {
                    Thread.sleep(milliseconds);
                }
            catch (InterruptedException e)
                {
                    throw new RuntimeException("Tired of sleeping", e);
                }
        }
}
