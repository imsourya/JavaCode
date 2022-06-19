package duega.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedundantConnection {
    // using dfs
	private static boolean dfs(Map<Integer, List<Integer>> adjList, int start, int end, boolean visited[]) {
		
		visited[start] = true;
		
		if(start == end) return true;
		
		for(int v : adjList.get(start)) {
			if(!visited[v] && dfs(adjList, v, end, visited)) {
				return true;
			}
		}
		return false;
	}
	
	public int[] findRedundantConnection(int[][] edges) {
		
		boolean visited[] = new boolean[edges.length+1];
		Map<Integer, List<Integer>> mp = new HashMap<Integer, List<Integer>>();
		
		for(int i=0;i<edges.length;i++) {
			
			int u = edges[i][0];
			int v = edges[i][1];
			
			for(int j=0; j<(edges.length+1); j++) {
				visited[j]=false;
			}
			
			if(mp.containsKey(u) && mp.containsKey(v) && dfs(mp, u,v, visited)) {
				return edges[i];
			}
			
			if(mp.containsKey(u)) {
				mp.get(u).add(v);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(v);
				mp.put(u, list);
			}
			
			if(mp.containsKey(v)) {
				mp.get(v).add(u);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(u);
				mp.put(v, list);
			}
		}
		
		return new int[2];
	}
	
	public static void main(String[] args) {
		RedundantConnection r = new RedundantConnection();
		int edge[][] = {{1,2},{2,3},{3,4},{1,4},{1,5}};
		int result[] = r.findRedundantConnection(edge);
		System.out.println("["+result[0]+","+result[1]+"]");
	}
}
