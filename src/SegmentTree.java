
public class SegmentTree {

	int[] st;

	public SegmentTree(int[] arr, int n) {

		int x = (int) Math.ceil(Math.log(n) / Math.log(2));
		int max_size = 2 * (int) Math.pow(2, x) - 1;
		st = new int[max_size];
	}

	int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

	public int constructSegmentTreeUtilForSumGivenRange(int[] arr, int ss, int se, int si) {

		if (ss == se) {
			st[si] = arr[ss];
			return st[ss];
		}
		int mid = getMid(ss, se);
		st[si] = constructSegmentTreeUtilForSumGivenRange(arr, ss, mid, si * 2 + 1)
				+ constructSegmentTreeUtilForSumGivenRange(arr, mid + 1, se, si * 2 + 2);
		return st[si];
	}

	public int getSum(int n, int qs, int qe) {

		if (qs < 0 || qe > n - 1 || qs > qe) {
			System.out.println("invalid input");
			return -1;
		}
		return getSumUtil(0, n - 1, qs, qe, 0);
	}

	private int getSumUtil(int ss, int se, int qs, int qe, int si) {

		if (qs <= ss && qe >= se)
			return st[si];

		// If segment of this node is outside the given range
		if (se < qs || ss > qe)
			return 0;

		// If a part of this segment overlaps with the given range
		int mid = getMid(ss, se);
		return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;
		SegmentTree tree = new SegmentTree(arr, n);
		tree.constructSegmentTreeUtilForSumGivenRange(arr, 0, n - 1, 0);
		System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3));

		// Update: set arr[1] = 10 and update corresponding segment
		// tree nodes
		tree.updateValue(arr, n, 1, 10);
		// Find sum after the value is updated
		System.out.println("Updated sum of values in given range = " + tree.getSum(n, 1, 3));
	}

	public void updateValue(int[] arr, int n, int i, int newValue) {

		if (i > n - 1 || i < 0) {
			System.out.println("invalid input");
			return;
		}
		int diff = newValue - arr[i];
		arr[i] = newValue;
		// Update the values of nodes in segment tree
		updateValueUtil(0, n - 1, i, diff, 0);
	}

	private void updateValueUtil(int ss, int se, int i, int diff, int si) {

		if (i < ss || i > se) {
			return;
		}
		st[si] = st[si] + diff;
		if (se != ss) {
			int mid = getMid(ss, se);
			updateValueUtil(ss, mid, i, diff, 2 * si + 1);
			updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
		}
	}

}
