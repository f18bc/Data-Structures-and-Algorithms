class Solution {
    // Time (E*(logE - logd))
    // Space (V + E)
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> targets = new HashMap<>();
        for (List<String> ticket : tickets) {
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        List<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) {
                stack.push(targets.get(stack.peek()).poll());
            }
            route.add(0, stack.pop());
        }
        return route;
    }
}
/*
class Solution {
    // Time (E^d), where E = the number of total flights, d = the maximum number of flights from an airport
    // Space (V + E), where V = the number of airports
    int max;
    int n;
    List<List<String>> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, new Comparator<List<String>>() {
           public int compare(List<String> l1, List<String> l2) {
               if (l1.get(0).equals(l2.get(0))) {
                   return l1.get(1).compareTo(l2.get(1));
               } else {
                   return l1.get(0).compareTo(l2.get(0));
               }
           } 
        });
        n = tickets.size();
        max = n + 1;
        boolean[] visited = new boolean[n];
        ans = new ArrayList<>();
        
        List<String> start = new ArrayList<>();
        start.add("JFK");
        dfs(tickets, "JFK", visited, start);
        return ans.get(0);
    }
    public void dfs(List<List<String>> tickets, String from, boolean[] visited, List<String> path) {
        if (ans.size() == 1) {
            return ;
        }
        if (max == path.size()) {
            ans.add(new ArrayList<>(path));
            return ;
        }
        for (int i = 0; i < n; i++) {
            if (!tickets.get(i).get(0).equals(from) || visited[i]) {
                continue;
            }
            visited[i] = true;
            String to = tickets.get(i).get(1);
            path.add(tickets.get(i).get(1));
            dfs(tickets, to, visited, path);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
*/