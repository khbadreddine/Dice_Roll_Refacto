package DiceRoll;

import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

	Yatzy yatzy = new Yatzy(0, 0, 0, 0, 0);

	@Test
	public void chance_scores_sum_of_all_dice() {
		yatzy.changeValueOfDices(2, 3, 4, 5, 1);
		assertEquals(15, yatzy.chance());
		yatzy.changeValueOfDices(3, 3, 4, 5, 1);
		assertEquals(16, yatzy.chance());
	}

	@Test
	public void yatzy_scores_50() {
		yatzy.changeValueOfDices(4, 4, 4, 4, 4);
		assertEquals(50, yatzy.yatzyCategorie());
		yatzy.changeValueOfDices(6, 6, 6, 6, 6);
		assertEquals(50, yatzy.yatzyCategorie());
		yatzy.changeValueOfDices(6, 6, 6, 6, 3);
		assertEquals(0, yatzy.yatzyCategorie());
	}

	@Test
	public void ones_test() {
		yatzy.changeValueOfDices(1, 2, 3, 4, 5);
		assertEquals(1, yatzy.sumDices(1));
		yatzy.changeValueOfDices(1, 2, 1, 4, 5);
		assertEquals(2, yatzy.sumDices(1));
		yatzy.changeValueOfDices(6, 2, 2, 4, 5);
		assertEquals(0, yatzy.sumDices(1));
		yatzy.changeValueOfDices(1, 2, 1, 1, 1);
		assertEquals(4, yatzy.sumDices(1));
	}

	@Test
	public void tows_test() {
		yatzy.changeValueOfDices(1, 2, 3, 2, 6);
		assertEquals(4, yatzy.sumDices(2));
		yatzy.changeValueOfDices(2, 2, 2, 2, 2);
		assertEquals(10, yatzy.sumDices(2));
	}

	@Test
	public void threes_test() {
		yatzy.changeValueOfDices(1, 2, 3, 2, 3);
		assertEquals(6, yatzy.sumDices(3));
		yatzy.changeValueOfDices(2, 3, 3, 3, 3);
		assertEquals(12, yatzy.sumDices(3));
	}

	@Test
	public void fours_test() {
		yatzy.changeValueOfDices(4, 4, 4, 5, 5);
		assertEquals(12, yatzy.sumDices(4));
		yatzy.changeValueOfDices(4, 4, 5, 5, 5);
		assertEquals(8, yatzy.sumDices(4));
		yatzy.changeValueOfDices(4, 5, 5, 5, 5);
		assertEquals(4, yatzy.sumDices(4));
	}

	@Test
	public void fives_test() {
		yatzy.changeValueOfDices(4, 4, 4, 5, 5);
		assertEquals(10, yatzy.sumDices(5));
		yatzy.changeValueOfDices(4, 4, 5, 5, 5);
		assertEquals(15, yatzy.sumDices(5));
		yatzy.changeValueOfDices(4, 5, 5, 5, 5);
		assertEquals(20, yatzy.sumDices(5));
	}

	@Test
	public void sixes_test() {
		yatzy.changeValueOfDices(4, 4, 4, 5, 5);
		assertEquals(0, yatzy.sumDices(6));
		yatzy.changeValueOfDices(4, 4, 6, 5, 5);
		assertEquals(6, yatzy.sumDices(6));
		yatzy.changeValueOfDices(6, 5, 6, 6, 5);
		assertEquals(18, yatzy.sumDices(6));
	}

	@Test
	public void one_pair() {
		yatzy.changeValueOfDices(3, 4, 3, 5, 6);
		assertEquals(6, yatzy.onePair());
		yatzy.changeValueOfDices(5, 3, 3, 3, 5);
		assertEquals(10, yatzy.onePair());
		yatzy.changeValueOfDices(5, 3, 6, 6, 5);
		assertEquals(12, yatzy.onePair());
	}

	@Test
	public void two_Pair() {
		yatzy.changeValueOfDices(3, 3, 5, 4, 5);
		assertEquals(16, yatzy.twoPair());
		yatzy.changeValueOfDices(3, 3, 5, 5, 5);
		assertEquals(16, yatzy.twoPair());
	}

	@Test
	public void three_of_a_kind() {
		yatzy.changeValueOfDices(3, 3, 3, 4, 5);
		assertEquals(9, yatzy.numberOfAKind(3));
		yatzy.changeValueOfDices(5, 3, 5, 4, 5);
		assertEquals(15, yatzy.numberOfAKind(3));
		yatzy.changeValueOfDices(3, 3, 3, 3, 5);
		assertEquals(9, yatzy.numberOfAKind(3));
	}

	@Test
	public void four_of_a_kind() {
		yatzy.changeValueOfDices(3, 3, 3, 3, 5);
		assertEquals(12, yatzy.numberOfAKind(4));
		yatzy.changeValueOfDices(5, 5, 5, 4, 5);
		assertEquals(20, yatzy.numberOfAKind(4));
		yatzy.changeValueOfDices(3, 3, 3, 3, 3);
		assertEquals(12, yatzy.numberOfAKind(4));
	}

	@Test
	public void smallStraight() {
		yatzy.changeValueOfDices(1, 2, 3, 4, 5);
		assertEquals(15, yatzy.smallStraight());
		yatzy.changeValueOfDices(2, 3, 4, 5, 1);
		assertEquals(15, yatzy.smallStraight());
		yatzy.changeValueOfDices(1, 2, 2, 4, 5);
		assertEquals(0, yatzy.smallStraight());
	}

	@Test
	public void largeStraight() {
		yatzy.changeValueOfDices(6, 2, 3, 4, 5);
		assertEquals(20, yatzy.largeStraight());
		yatzy.changeValueOfDices(2, 3, 4, 5, 6);
		assertEquals(20, yatzy.largeStraight());
		yatzy.changeValueOfDices(1, 2, 2, 4, 5);
		assertEquals(0, yatzy.largeStraight());
	}

	@Test
	public void fullHouse() {
		yatzy.changeValueOfDices(6, 2, 2, 2, 6);
		assertEquals(18, yatzy.fullHouse());
		yatzy.changeValueOfDices(2, 3, 4, 5, 6);
		assertEquals(0, yatzy.fullHouse());
	}
}
