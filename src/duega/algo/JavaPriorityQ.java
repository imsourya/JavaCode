package duega.algo;

import java.util.Collections;
import java.util.PriorityQueue;

public class JavaPriorityQ {
    
	public static void main(String[] args) {
		PriorityQueue<Integer> Q = new PriorityQueue<Integer>(5, Collections.reverseOrder());
		display(Q);
		
		Q.add(5);
		Q.add(10);
		Q.add(11);
		Q.add(12);
		Q.add(13);
		Q.add(14);
		Q.add(15);
		display(Q);
	}

	private static void display(PriorityQueue<Integer> q) {
		System.out.println("================================"+(q.isEmpty()?"Empty":""));
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}
