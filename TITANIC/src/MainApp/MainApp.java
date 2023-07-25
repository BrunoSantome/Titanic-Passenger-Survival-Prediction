package MainApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Values.TrainingValue;
import testDataPart.TestDataList;
import testDataPart.TestDataSet;
import trainDataPart.DAO;
import trainDataPart.TrainingChar;
import trainDataPart.TrainingDataSet;
import trainDataPart.TrainingRow;

/**
 *
 * @author Bruno Santome Antolin
 */
public class MainApp {

	public static void main(String[] args) {
		Map<TrainingValue, TrainingValue> FinalTree = new HashMap<TrainingValue, TrainingValue>();
		ArrayList<TrainingChar> charList = new ArrayList<TrainingChar>();
		ArrayList<TrainingRow> listrow = new ArrayList<TrainingRow>();
		TrainingDataSet trainset = new TrainingDataSet("TrainData1", listrow, charList);
		DAO manager = new DAO(listrow);
		// I creat two TrainingCharValues, the ones i use on my project
		TrainingChar p1 = new TrainingChar("Survived");
		TrainingChar p2 = new TrainingChar("Pclass");
		// I add them to the arrayList
		charList.add(p1);
		charList.add(p2);
		try {
			listrow = manager.extractTrainingData(charList);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// here the DecisionTree is created
		FinalTree = trainset.createSingleCharTree(listrow);
		//SingleCharacteristiqueTree s = new SingleCharacteristiqueTree(FinalTree);

		//Once we get here we can move on into the next point
		//Which is the TestDataSet
		ArrayList<TestDataList> h = new ArrayList<TestDataList>();
		TestDataSet Tset = new TestDataSet(h);
		//We create another list of Characteristiques and we add the only profile
		ArrayList<TrainingChar> charList2 = new ArrayList<TrainingChar>();
		charList.add(p2);

		//with the following method we extract the values of the TestData and with CreatePredictiveMap
		//we create the Map with the profile and the predictives target values

		try {
			h = Tset.extractPredictionValues(charList2, FinalTree);
			//To print the results of the Prediction
			System.out.println(h.toString());
		} catch (IOException e) {

			e.printStackTrace();
		}



	}
}
