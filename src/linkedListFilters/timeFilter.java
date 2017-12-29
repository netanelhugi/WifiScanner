package linkedListFilters;

import myObjects.*;

/**
	 * This class represents a simple time filter based on a 1D time window range
	 * @author Boaz
	 *
	 */
public class timeFilter implements filter{
	
	public timeFilter(String start, String end) {
			_start = start;
			_end = end;
	}

	
	public boolean test(Checks rec) {
		boolean ans = false;
		if(rec!=null) {
			String t = rec.getTime();
			System.out.println(t);
			int ts = _start.compareTo(t);
			System.out.println("ts: " + ts);
			int te = _end.compareTo(t);
			System.out.println("te: " + te);
	//		System.out.println(_start+"  <  "+t+"   <  "+_end+"  "+ts+"  "+te);
			// t0.compareTo(t)<0 && t1.compareTo(t)>0
			if(ts<=0 && te>0) {
				ans = true;
				}
		}
		return ans;
	}

	public String toString() {
		return ""+this.getClass().getName()+" ["+this._start+","+this._end+"]";
	}
		
	/********** Private data can be located anywhere *************/
	private String _start, _end;
}