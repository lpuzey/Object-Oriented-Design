import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class Examples {

	HeapTester HT = new HeapTester();
	
	IHeap heap1 = new DataHeap(4, new MtHeap(), new MtHeap());
	IHeap empty = new MtHeap();
	DataHeap heap2 = new DataHeap(4, 
			new DataHeap(6, new MtHeap(), 
					new DataHeap(7, new MtHeap(), new MtHeap())), 
			new DataHeap(5, new MtHeap(), new MtHeap()));
	DataHeap bh2 = new DataHeap(7, 
			new DataHeap(6, new MtHeap(), 
					new DataHeap(5, new MtHeap(), new MtHeap())), 
			new MtHeap());
	DataHeap wh2 = new DataHeap(4, 
			new DataHeap(6, new MtHeap(), 
					new MtHeap()), 
			new DataHeap(5, new MtHeap(), new MtHeap()));
	DataHeap heap3 = new DataHeap(0, 
			new DataHeap(3, 
					new DataHeap(5, 
							new DataHeap(7, new MtHeap(), new MtHeap()), new MtHeap()),
					new DataHeap(9, new MtHeap(), new DataHeap(12, new MtHeap(),
							new DataHeap(13, new MtHeap(), new MtHeap())))),
			new DataHeap(1, 
					new DataHeap(3, new MtHeap(), 
							new DataHeap(4, new MtHeap(), new MtHeap())), 
					new DataHeap(3, 
							new DataHeap(4, new MtHeap(), new MtHeap()),
							new DataHeap(5, new MtHeap(), new MtHeap()))));
	LinkedList<Integer> four = new LinkedList<Integer>();
	
	@Before
	public void construct() {
		four.add(4);
	}
	
	//addEltTester
	
	//adds same element to 1-elt heap
	@Test
	public void aet1() {
		assertTrue(HT.addEltTester(heap1, 4, heap1.addElt(4)));
	}
	
	//add elt smaller than root
	@Test
	public void aet2() {
		assertTrue(HT.addEltTester(heap2, 2, heap2.addElt(2)));
	}
	
	//add elt larger than any existing elts
	@Test
	public void aet3() {
		assertTrue(HT.addEltTester(heap2, 9, heap2.addElt(9)));
	}
	
	//add elt to empty heap
	@Test
	public void aet4() {
		assertTrue(HT.addEltTester(empty,4,heap1));
	}
	
	//add repeat elt to multi-elt heap
	@Test
	public void aet5() {
		assertTrue(HT.addEltTester(heap2, 6, heap2.addElt(6)));
	}
	
	//add non-repeat elt within existing range of values
	@Test
	public void aet6() {
		assertTrue(HT.addEltTester(heap3, 8, heap3.addElt(8)));
	}
	
	//remMinEltTester
	
	//remove only elt
	@Test
	public void rmet1() {
		assertTrue(HT.remMinEltTester(heap1, empty));
	}
	
	//remove min elt from medium heap
	@Test
	public void rmet2() {
		assertTrue(HT.remMinEltTester(heap2, heap2.remMinElt()));
	}
	
	//remove min elt from large heap
	@Test
	public void rmet3() {
		assertTrue(HT.remMinEltTester(heap3, heap3.remMinElt()));
	}
	
	//remove min elt from empty heap
	@Test
	public void rmet4() {
		assertTrue(HT.remMinEltTester(empty, empty));
	}
	
	//failed test where wrong elt is removed
	@Test
	public void rmet5() {
		assertFalse(HT.remMinEltTester(heap2, wh2));
	}
	
	//failed test where the result is not a proper minHeap
	@Test
	public void rmet6() {
		assertTrue(HT.remMinEltTester(heap2, bh2));
	}

}

