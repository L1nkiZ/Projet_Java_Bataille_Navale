package tests.fr.iut.cpoa.tools;

import static fr.iut.cpoa.tools.Utils.checkString;
import static fr.iut.cpoa.tools.Utils.bataille;
import static fr.iut.cpoa.tools.Utils.tour;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import fr.iut.cpoa.tools.Utils;

public class UtilsTest {

	@Test
	public void testCheckStringIsValid() {
		assertTrue(Utils.checkString("A1"));
	}

	@Test
	public void testCheckStringIsNotValid() {
		Assert.assertFalse(checkString("sdqsdjjkl"));
	}

	@Test
	public void testBataille() { assertTrue(Utils.bataille(1,2)); }

	@Test
	public void testTour() { assertTrue(Utils.tour(1)); }
}
