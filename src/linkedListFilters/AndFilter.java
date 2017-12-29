package linkedListFilters;

import myObjects.Checks;

public class AndFilter implements filter{
	private filter _f1, _f2;
	public AndFilter(filter f1, filter f2) {
		_f1 = f1;
		_f2 = f2;
	}

	public boolean test(Checks rec) {
		return _f1.test(rec) && _f2.test(rec);
	}
	public String toString() {
		return "("+_f1+" and "+_f2+")";
	}
}