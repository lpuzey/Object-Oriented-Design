import java.util.Collections;
import java.util.LinkedList;

public class HeapTester {

	/**
	 * checking if the result heap is the original heap with the specified element added
	 * @param hOrig
	 * @param elt
	 * @param hAdded
	 * @return boolean
	 */

	public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		boolean result = false;
		LinkedList<Integer> origList = new LinkedList<Integer>();
		if (((DataHeap) hAdded).smallerElts()) {
			
				origList = ((IHeap) hOrig).extractElts();
			
			origList.add(elt);
			LinkedList<Integer> addedList = ((DataHeap) hAdded).extractElts();
			Collections.sort(addedList);
			Collections.sort(origList);
			if (origList.equals(addedList)) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * Checks whether the binary tree is a valid result of performing remMinElt()
	 * @param hOrig
	 * @param hRemoved
	 * @return boolean
	 */
	boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		boolean result = false;
		LinkedList<Integer> origList = new LinkedList<Integer>();
		if (((IHeap) hRemoved).smallerElts() == true) {
			origList = hOrig.extractElts();
			LinkedList<Integer> removedList = ((IHeap) hRemoved).extractElts();
			Collections.sort(removedList);
			Collections.sort(origList);
			if (origList.size() > 0) {
				origList.remove(0);
			}
			if (origList.equals(removedList)) {
				result = true;
			}
		}
		return result;
	}

}
