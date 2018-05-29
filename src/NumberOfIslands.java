
public class NumberOfIslands {

	public static void main(String[] args) {
		int[][] a = new int[][] {
								{1, 1, 0, 0, 0},
            					{0, 1, 0, 0, 1},
					            {1, 0, 0, 1, 1},
					            {0, 0, 0, 0, 0},
					            {1, 0, 1, 0, 1}
								};
								
           System.out.println("Number of Islands is: " +countIslands(a));
      
	}

	private static int countIslands(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		boolean[][] visited = new boolean[m][n];
		int count = 0;
		for( int i=0;i<m;i++){
			for( int j=0;j<n;j++){
				if(a[i][j] == 1 && visited[i][j]==false){
					DFSUtil(a,visited,i,j);
					count++;
				}
			}
		}
		return count;
	}

	private static void DFSUtil(int[][] a, boolean[][] visited, int i, int j) {
		visited[i][j] = true;
		int[] row = new int[]{-1, -1, -1,  0, 0,  1, 1, 1};
		int[] col = new int[]{-1,  0,  1, -1, 1, -1, 0, 1};
		
		for(int k=0;k<8;k++){
			if(isSafe(a,i+row[k],j+col[k],visited)){
				DFSUtil(a, visited, i+row[k], j+col[k]);
			}
		}
	}

	private static boolean isSafe(int[][] a, int i, int j, boolean[][] visited) {
		return (i>=0 && j>=0) && (i<a.length)&&(j<a[0].length)&&a[i][j]==1&&visited[i][j]==false;
	}
}
