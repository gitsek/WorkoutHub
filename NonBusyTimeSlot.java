package workoutPkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class NonBusyTime {

	static class TimeSlot implements Comparable{
		int stTime;
		int endTime;
		
		TimeSlot(int st, int end) {
			stTime = st;
			endTime = end;
		}

		@Override
		public int compareTo(Object o) {
			TimeSlot ts = (TimeSlot) o;
			if (stTime == ts.stTime) {
				return 0;
			} else if (stTime < ts.stTime) {
				return -1;
			} else
				return 1;
		}
	}

	public static void FindCommonNonBusyTimeSlot( ArrayList<TimeSlot> p1, ArrayList<TimeSlot> p2) {
		ArrayList<TimeSlot> availTimeSlots = new ArrayList<TimeSlot>();
		ArrayList<TimeSlot> mergedList = mergeLists(p1,p2);
		Iterator<TimeSlot> itr = mergedList.iterator();
		
		TimeSlot t1 = itr.next();

		while(itr.hasNext()) {
			TimeSlot t2 = itr.next();
			int diffTime = t2.stTime - t1.endTime;
			if (diffTime > 0 ) {
				TimeSlot ts = new TimeSlot((t1.endTime + 1), (t1.endTime + diffTime));
				availTimeSlots.add(ts);
			}
			t1 = t2;
		}
		if(availTimeSlots.size() > 0 ) {
			System.out.println("Available Time Slots " + availTimeSlots);
			for(TimeSlot ts : availTimeSlots){
				System.out.println( "(" + ts.stTime + " ," + ts.endTime + ")");
			}
		} else {
			System.out.println("No non-busy time slots");
		}
		
	}
	
	public static ArrayList<TimeSlot> mergeLists(ArrayList<TimeSlot> p1, ArrayList<TimeSlot> p2) {
		ArrayList<TimeSlot> mergedList = new ArrayList<>();
		mergedList.addAll(p1);
		mergedList.addAll(p2);
		System.out.println(mergedList);
		
		Collections.sort(mergedList);
		
		System.out.println(mergedList);
		return mergedList;
	}
	
	public static void main(String[] args) {
		ArrayList<TimeSlot> p1List = new ArrayList<>();
		ArrayList<TimeSlot> p2List = new ArrayList<>();
		
		p1List.add(new TimeSlot(0,5));
		p1List.add(new TimeSlot(15,30));
		p1List.add(new TimeSlot(45,60));

		p2List.add(new TimeSlot(5,15));
		p2List.add(new TimeSlot(30,40));

		NonBusyTime.FindCommonNonBusyTimeSlot(p1List, p2List);
	}

}
