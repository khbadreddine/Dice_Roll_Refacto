package DiceRoll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzy {

	private List<Integer> dice;
	//liste des valeurs pour Small Straight
	public static final Set<Integer> listSmallStraight = Stream.of(1, 2, 3, 4, 5)
			.collect(Collectors.toCollection(HashSet::new));
	//liste des valeurs pour Large Straight
	public static final Set<Integer> listLargeStraight = Stream.of(2, 3, 4, 5, 6)
			.collect(Collectors.toCollection(HashSet::new));

	public Yatzy(int d1, int d2, int d3, int d4, int d5) {
		dice = new ArrayList<Integer>();
		dice.add(d1);
		dice.add(d2);
		dice.add(d3);
		dice.add(d4);
		dice.add(d5);
	}

	public Yatzy() {
		dice = new ArrayList<Integer>();
	}
	
	/**
	 * Calculer la somme des dés
	 * @return la valeur de la somme
	 */
	public int chance() {
		return dice.stream().mapToInt(i -> i).sum();
	}

	/**
	 * Vérifier si tous les dés ont le même numéro
	 * @return 50 si les valeurs des dés sont égaux sinon 0
	 */
	public int yatzyCategorie() {
		return dice.stream().allMatch(dice.get(0)::equals) ? 50 : 0;
	}
	
	/**
	 * Calculer la somme du dé selon le choix du numéro un,deux..
	 * @param choice : numéro du dé
	 * @return la valeur de la somme
	 */
	public int sumDices(int choice) {
		return dice.stream().filter(i -> i == choice).mapToInt(i -> i).sum();
	}

	/**
	 * Calculer la somme du pair de la plus grande valeur
	 * @return la valeur de la somme
	 */
	public int onePair() {
		int value = 0;
		for (int i = 0; i < dice.size() - 1; i++) {
			if (Collections.frequency(dice, dice.get(i)) >= 2 && dice.get(i) * 2 > value) {
				value = dice.get(i) * 2;
			}
		}
		return value;
	}

	/**
	 * Calculer la somme des paires de dés
	 * @return la valeur de la somme
	 */
	public int twoPair() {
		int value = onePair();
		if (value != 0) {
			dice = dice.stream().filter(i -> i != (value / 2)).collect(Collectors.toList());
			if (onePair() != 0 && dice.size() != 0)
				return value + onePair();
			else
				return 0;
		} else
			return 0;
	}

	/**
	 * Calculer la somme du dé selon le choix trois ou quatre
	 * @param choiceOfKind : choix du genre
	 * @return la valeur de la somme
	 */
	public int numberOfAKind(int choiceOfKind) {
		for (int i = 0; i < (dice.size() - choiceOfKind) + 1; i++) {
			if (Collections.frequency(dice, dice.get(i)) >= choiceOfKind) {
				return choiceOfKind * dice.get(i);
			}
		}
		return 0;
	}

	/**
	 * Vérifier si la liste est small straight 
	 * @return 15 si la condition est vérifiée sinon 0
	 */
	public int smallStraight() {
		return new HashSet<>(dice).equals(listSmallStraight) ? 15 : 0;
	}

	/**
	 * Vérifier si la liste est large straight
	 * @return 20 si la condition est vérifiée sinon 0
	 */
	public int largeStraight() {
		return new HashSet<>(dice).equals(listLargeStraight) ? 20 : 0;
	}

	/**
	 * Calculer la somme des pair et triplet
	 * @return la valeur de la somme
	 */
	public int fullHouse() {
		int value = numberOfAKind(3);
		if (value == 0)
			return 0;
		else {
			dice = dice.stream().filter(i -> i != (value / 3)).collect(Collectors.toList());
			if (dice.size() == 2 && dice.get(0) == dice.get(1))
				return value + dice.get(0) + dice.get(1);
			return 0;
		}
	}

	/**
	 * Modifier les valeurs des dés
	 */
	public void changeValueOfDices(int d1, int d2, int d3, int d4, int d5) {
		if (!dice.isEmpty()) {
			dice.clear();
		}
		dice.add(d1);
		dice.add(d2);
		dice.add(d3);
		dice.add(d4);
		dice.add(d5);
	}
	
	public List<Integer> getDice() {
		return dice;
	}

	public void setDice(List<Integer> dice) {
		this.dice = dice;
	}

}