package GUI;

import java.util.LinkedList;

import myObjects.Checks;

public class counters {
	
	
	public int boolCount(LinkedList<Checks> a){
		
		int cou = 0;
		
		for(int i=0; i<a.size(); i++){
			
			if(a.get(i).isBool()){
				cou++;
			}
		}
		return cou;
		
	}

}
