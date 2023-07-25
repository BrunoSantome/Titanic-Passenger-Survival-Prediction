package trainDataPart;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Values.TrainingValue;
/**
 *
 * @author Bruno Santome Antolin
 */
public class SingleCharacteristiqueTree {

	Map<TrainingValue, TrainingValue> treeMap;

	public SingleCharacteristiqueTree(Map<TrainingValue, TrainingValue> map) {
		this.treeMap = map;
		map = new HashMap<TrainingValue, TrainingValue>();
	}

	public int getTargetValue(TrainingValue v) {
		int value = 0;
		for(Entry<TrainingValue, TrainingValue> e : this.treeMap.entrySet()) {
			//System.out.println(e.getValue().getV2().getNumValue());
			if(e.getKey().getV2().getNumValue() == v.getV2().getNumValue()) {
				value = e.getValue().getV2().getNumValue();

			}


		}

		return value;
	}
	public String toString() {
		return  this.treeMap.toString();
	}
	public Map<TrainingValue, TrainingValue> getTreeMap() {
		return treeMap;
	}

	public void setTreeMap(Map<TrainingValue, TrainingValue> treeMap) {
		this.treeMap = treeMap;
	}
}
