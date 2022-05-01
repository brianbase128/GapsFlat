import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test of the Ranges class
 */
public class TestRanges {

    double precision = 0.001;

    @Test
    public void testConstructor() {
        Ranges ranges = new Ranges(1.0, 100.0);
        assertThat(ranges.sum(), closeTo(99.0, precision));

        Interval[] expected = { new Interval(1.0, 100.0) };
        assertThat (ranges, contains(expected)); // checks ranges.iterator()
    }

    @Test
    public void testSubtractAll() {
        Ranges ranges = new Ranges(10.0, 100.0);
        Interval interval = new Interval(9.0, 110.0);
        ranges.subtract(interval);
        assertThat(ranges.sum(), closeTo(0.0, precision));
        assertThat (ranges.iterator().hasNext(), is(false));
    }

}