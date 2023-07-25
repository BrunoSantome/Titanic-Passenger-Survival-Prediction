package testDataPart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Values.TrainingValue;
import trainDataPart.SingleCharacteristiqueTree;
import trainDataPart.TrainingChar;

/**
 *
 * @author Bruno Santome Antolin
 */
public class TestDataSet {
	ArrayList<TestDataList> TargetdataList;
	public TestDataSet(ArrayList<TestDataList> T) {
		this.TargetdataList = T;
	}

	public ArrayList<TestDataList> extractPredictionValues(ArrayList<TrainingChar> t,Map<TrainingValue,TrainingValue> p) throws IOException {
		String filePath = "C:\\Users\\Brunaquen\\Desktop\\TITANIC\\test (1).csv";
		Map<TrainingValue,TrainingValue> ResultMap = new HashMap<TrainingValue, TrainingValue>();
		String line = "";
		int s = 1;
		String[] WholeData = {};
		String SpecificData = "";
		TestDataSet set = new TestDataSet(this.TargetdataList);
		FileReader fileReader = new FileReader(filePath);
		BufferedReader buf = new BufferedReader(fileReader);
		String CharacteristiquesRow = buf.readLine();

		for (TrainingChar c : t) {

			if (c.getName().contentEquals("Pclass")) {
				s += t.indexOf(c);
			}
		}
		while ((line = buf.readLine()) != null) {
			WholeData = line.split(":");

			String[] WorkingData = {WholeData[s]};
			set.CreatePredictiveList( WorkingData,p);
			SpecificData = Arrays.toString(WorkingData);

		}

		return this.TargetdataList;
	}

	public void CreatePredictiveList( String[] values,Map<TrainingValue,TrainingValue> d) {
		SingleCharacteristiqueTree t = new SingleCharacteristiqueTree(d);
		int Pclass = Integer.valueOf(values[0]);

		TrainingValue v1 = new TrainingValue(Pclass);
		int TargetValue = t.getTargetValue(v1);

		TrainingValue tvalue = new TrainingValue(TargetValue);
		TestDataList list = new TestDataList(v1, tvalue);
		this.TargetdataList.add(list);



	}
}
