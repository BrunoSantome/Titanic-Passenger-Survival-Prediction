package Values;

import java.util.Objects;
/**
 *
 * @author Bruno Santome Antolin
 */
public class TrainingValue {

	TextualTrainingValue v1;
	NumericalTrainingValue v2;
	public TrainingValue(String value) {

		this.v1 = new TextualTrainingValue(value);
	}

	public TrainingValue(int  value) {
		this.v2 = new NumericalTrainingValue(value);
	}
	public TrainingValue() {

	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 37 * hash + Objects.hashCode(this.v2.getNumValue());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TrainingValue other = (TrainingValue) obj;
		if (!Objects.equals(this.v2.getNumValue(),other.v2.getNumValue())) {
			return false;
		}
		return true;
	}




	public TextualTrainingValue getV1() {
		return v1;
	}

	public void setV1(TextualTrainingValue v1) {
		this.v1 = v1;
	}

	public NumericalTrainingValue getV2() {
		return v2;
	}

	public void setV2(NumericalTrainingValue v2) {
		this.v2 = v2;
	}
}