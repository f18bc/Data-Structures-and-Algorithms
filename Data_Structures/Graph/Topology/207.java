class Solution {
    // Time O(M+N), M = prerequsite courses, N = numCourses
    // Space O(M+N)
    // 40 mins
    List<List<Integer>> edges;
    //in degree
    int[] indeg;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
            
        }
        indeg = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            indeg[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        
        int visited = 0;
        
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            visited++;
            for (int cl : edges.get(pre)) {
                indeg[cl]--;
                if (indeg[cl] == 0) {
                    queue.offer(cl);
                }
            }
        }
        return visited == numCourses;
    }
}