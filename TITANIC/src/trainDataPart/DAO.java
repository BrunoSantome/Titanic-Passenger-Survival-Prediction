package trainDataPart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Values.TrainingValue;

/**
 *
 * @author Bruno Santome Antolin
 */
public class DAO {

	ArrayList<TrainingRow> Rows;

	public DAO(ArrayList<TrainingRow> R) {
		this.Rows = R;

	}

	public ArrayList<TrainingRow> extractTrainingData(ArrayList<TrainingChar> t) throws IOException {
		String filePath = "C:\\Users\\Brunaquen\\Desktop\\TITANIC\\train (2).csv";
		String line = "";
		int i = 0;
		int q = 1;
		int s = 1;
		String[] WholeData = {};
		String SpecificData = "";
		DAO d = new DAO(Rows);
		FileReader fileReader = new FileReader(filePath);
		BufferedReader buf = new BufferedReader(fileReader);
		String CharacteristiquesRow = buf.readLine();

		for (TrainingChar c : t) {

			if (c.getName().contentEquals("Survived")) {
				q += t.indexOf(c);
			}
			if (c.getName().contentEquals("Pclass")) {
				s += t.indexOf(c);
			}
		}

		while ((line = buf.readLine()) != null) {
			WholeData = line.split(":");

			if (d.testNoNullValue(WholeData) == false && Arrays.asList(WholeData).contains("")) {
				continue;
			}

			String[] WorkingData = { WholeData[s], WholeData[q] };
			d.CreateTrainingRow(i, WorkingData);
			SpecificData = Arrays.toString(WorkingData);
			i++;
		}

		return d.Rows;
	}

	public boolean testNoNullValue(String[] values) {
		int Counter = 0;
		for (String e : values) {
			if (e.isEmpty()) {
				Counter++;
			}
		}
		if (Counter > 0) {
			// there are Null values
			return false;
		} else {
			// There aren't null values
			return true;
		}
	}

	public void CreateTrainingRow(int numRow, String[] values) {

		int Pclass = Integer.valueOf(values[0]);
		int survived = Integer.valueOf(values[1]);
		TrainingValue v1 = new TrainingValue(Pclass);
		TrainingValue v2 = new TrainingValue(survived);
		TrainingValue v3 = new TrainingValue(3);
		Map<TrainingValue, TrainingValue> map = new HashMap<TrainingValue, TrainingValue>();
		map.put(v1, v2);
		TrainingRow row = new TrainingRow(numRow, map);
		Rows.add(row);

	}



}
