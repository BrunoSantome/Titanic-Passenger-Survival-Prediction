package testDataPart;

import Values.TrainingValue;

public class TestDataList {

	TrainingValue v;
	TrainingValue p;

	public TestDataList(TrainingValue v1, TrainingValue v2) {
		this.v = v1;
		this.p = v2;
	}
	@Override
	public String toString() {
		return ("PassengerClass : " + this.v.getV2().getNumValue() +
				" Prediction survive Value :" + this.p.getV2().getNumValue() +
				"\n"
				);


	}


}
