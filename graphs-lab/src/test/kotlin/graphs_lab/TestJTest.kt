package graphs_lab

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TestJTest {

	@Test
	@DisplayName("sum test")
	fun testSum() {
		Assertions.assertEquals(
			0, sum(intArrayOf(1, -1))
		)
	}
}