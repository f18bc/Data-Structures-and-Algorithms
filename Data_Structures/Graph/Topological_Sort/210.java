class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Time O(M+N) edges + nodes
        // Space O(M+N)
        // 20 mins
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        int[] parentCount = new int[numCourses];
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            parentCount[prerequisite[0]]++;
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (parentCount[i] == 0) {
                queue.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int visited = 0;
        int in = 0;
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            visited++;
            order[in++] = course;
            for (int child : adj.get(course)) {
                parentCount[child]--;
                if (parentCount[child] == 0) {
                    queue.offer(child);
                }
            }
        }
        
        if (visited != numCourses) {
            return new int[] {};
        } else {
            return order;
        }
        
    }
}