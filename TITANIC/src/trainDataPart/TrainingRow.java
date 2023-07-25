package trainDataPart;

import java.util.HashMap;
import java.util.Map;

import Values.TrainingValue;
/**
 *
 * @author Bruno Santome Antolin
 */
public class TrainingRow {
	private int rowid;
	private Map<TrainingValue, TrainingValue> RowMap;

	public TrainingRow(int Row, Map<TrainingValue, TrainingValue> p) {
		this.rowid = Row;
		this.RowMap = p;
		p= new HashMap<TrainingValue, TrainingValue>();
	}

	public Map<TrainingValue, TrainingValue> getRowMap() {
		return RowMap;
	}

	public void setRowMap(Map<TrainingValue, TrainingValue> rowMap) {
		RowMap = rowMap;
	}

	public int getRowid() {
		return rowid;
	}

	public void setRowid(int rowid) {
		this.rowid = rowid;
	}



}
