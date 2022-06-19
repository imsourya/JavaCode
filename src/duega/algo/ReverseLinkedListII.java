package duega.algo;


class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int left, int right) {

		ListNode pointer = head;
		int mov = left;
		while(mov>2) { 
			pointer = pointer.next; 
			mov--;
		}

		ListNode firstPointer = null;
		ListNode prev = null;
		ListNode curr = null;
		ListNode next = null;

		if(mov==1) {
			prev=null;
			firstPointer = null;
		}
		else {
			prev = pointer;
			firstPointer = pointer;
		}
		if(prev == null) curr = head;
		else curr=prev.next;
		next = curr.next;

		while(left <= right) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = curr!=null ?curr.next:null;
			if(left == right) {
				if(firstPointer != null) {
					firstPointer.next.next = curr;
					firstPointer.next = prev;
				}
				else {
					head.next = curr;
					head = prev;
				}
			}
			left ++;
		}

		return head;
	}
	
	static ListNode createListNode(int N, int Max) {
		if(N==(Max+1)) return null;
		return new ListNode(N, createListNode(N+1,Max));
	}

	public static void main(String[] args) {
		ReverseLinkedListII r = new ReverseLinkedListII();
		// head = [1,2,3,4,5], left = 2, right = 4
		//ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode head = createListNode(1, 10);
		int left = 1;
		int right = 9;
		head = r.reverseBetween(head, left, right);

		ListNode point = head;
		
		while(point!=null) {
			System.out.print(point.val+" ");
			point= point.next;
		}
	}
}
