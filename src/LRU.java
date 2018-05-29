import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author abhishek.patyal
 *
 */
class LruNode {
	int key;
	int value;
	LruNode previous;
	LruNode next;

	public LruNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class LRU {

	private int capacity;
	private Map<Integer, LruNode> map = new HashMap<Integer, LruNode>();
	private LruNode head = null;
	private LruNode tail = null;

	public LRU(int capacity) {
		this.capacity = capacity;
	}

	public void setHead(LruNode n) {
		n.next = head;
		n.previous = null;
		if (head != null)
			head.previous = n;
		head = n;
		if (tail == null)
			tail = head;
	}

	public void removeNode(LruNode n) {
		if (n.previous != null)
			n.previous.next = n.next;
		else
			head = n.next;

		if (n.next != null)
			n.next.previous = n.previous;
		else
			tail = n.previous;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			LruNode n = map.get(key);
			removeNode(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}

	public void set(int key, int value) {
		
		if (map.containsKey(key)) {
			LruNode oldNode = map.get(key);
			oldNode.value = value;
			removeNode(oldNode);
			setHead(oldNode);
		} else {
			LruNode newNode = new LruNode(key, value);
			if (map.size() >= capacity) {
				map.remove(tail.key);
				removeNode(tail);
				setHead(newNode);
			} else {
				setHead(newNode);
			}
			map.put(key, newNode);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int capacity = Integer.parseInt(br.readLine());
			LRU lru = new LRU(capacity);
			int queries = Integer.parseInt(br.readLine());
			// for(int i =0;i<queries;i++){
			String query = br.readLine();
			String[] queryArr = query.split(" ");
			for (int m = 0; m < queryArr.length;) {
				if (queryArr[m].equals("SET")) {
					m++;
					int x = Integer.parseInt(queryArr[m]);
					m++;
					int y = Integer.parseInt(queryArr[m]);
					m++;
					lru.set(x, y);
				} else if (queryArr[m].equals("GET")) {
					m++;
					int x = Integer.parseInt(queryArr[m]);
					m++;
					System.out.println(lru.get(x));
				}
			}
			// }
		}
	}
}
