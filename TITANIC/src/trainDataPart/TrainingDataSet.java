package trainDataPart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import Values.TrainingValue;

/**
 *
 * @author Bruno Santome Antolin
 */
public class TrainingDataSet {

	private String name;
	List<TrainingRow> rows;
	List<TrainingChar> characteristics;

	public TrainingDataSet(String name, List<TrainingRow> r, List<TrainingChar> c) {
		this.name = name;
		this.rows = r;
		r = new ArrayList<TrainingRow>();
		this.characteristics = c;
		c = new ArrayList<TrainingChar>();

	}

	public Map<TrainingValue, TrainingValue> createSingleCharTree(ArrayList<TrainingRow> r) {
		int firstClassAlive = 0;
		int secondClassAlive = 0;
		int thirdClassAlive = 0;
		int firstClassDead = 0;
		int secondClassDead = 0;
		int thirdClassDead = 0;

		TrainingValue v = new TrainingValue(0);
		TrainingValue v1 = new TrainingValue(1);
		TrainingValue v2 = new TrainingValue(2);
		TrainingValue v3 = new TrainingValue(3);
		Map<TrainingValue, TrainingValue> map1 = new HashMap<TrainingValue, TrainingValue>();
		Map<TrainingValue, TrainingValue> Tree = new HashMap<TrainingValue, TrainingValue>();
		//Now we want to see the number of deaths and alives in each Class

		for (TrainingRow row : r) {
			map1 = row.getRowMap();
			if (map1.containsKey(v1) == true) {
				if (map1.get(v1).equals(v)) {
					firstClassDead++;
				}
				if (map1.get(v1).equals(v1)) {
					firstClassAlive++;
				}
			}
			if (map1.containsKey(v2) == true) {

				if (map1.get(v2).equals(v)) {
					secondClassDead++;
				}
				if (map1.get(v2).equals(v1)) {
					secondClassAlive++;
				}
			}
			if (map1.containsKey(v3) == true) {
				if (map1.get(v3).equals(v)) {
					thirdClassDead++;
				}
				if (map1.get(v3).equals(v1)) {
					thirdClassAlive++;
				}
			}

		}




		// Tree Creation with the values
		// FirstClass Value
		if (firstClassAlive > firstClassDead) {
			Tree.put(v1, v1);
		}
		if (firstClassAlive < firstClassDead) {
			Tree.put(v1, v);
		}
		// SecondClass Value
		if (secondClassAlive > secondClassDead) {
			Tree.put(v2, v1);
		}
		if (secondClassAlive < secondClassDead) {
			Tree.put(v2, v);
		}
		// ThirdClass Value
		if (thirdClassAlive > thirdClassDead) {
			Tree.put(v3, v1);
		}
		if (thirdClassAlive < thirdClassDead) {
			Tree.put(v3, v);
		}

		if (thirdClassAlive == thirdClassDead) {
			int i = ThreadLocalRandom.current().nextInt(0, 1 + 1);
			if (i == v.getV2().getNumValue()) {
				Tree.put(v3, v);
			}
			if (i == v1.getV2().getNumValue()) {
				Tree.put(v3, v1);
			}
		}

		//The Map is returned
		return Tree;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TrainingRow> getRows() {
		return rows;
	}

	public void setRows(List<TrainingRow> rows) {
		this.rows = rows;
	}

	public List<TrainingChar> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<TrainingChar> characteristics) {
		this.characteristics = characteristics;
	}
}
