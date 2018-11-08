package ru.alazarev.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Aleksey Lazarev
 * @version 0.1
 * @since 07.11.2018
 */

public class CalculateTest {
	/**
	* Test echo.
	* @param name Your name.
	* @return Echo plus your name.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Aleksey Lazarev";
		String expect = "Echo, echo, echo : Aleksey Lazarev";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}

}