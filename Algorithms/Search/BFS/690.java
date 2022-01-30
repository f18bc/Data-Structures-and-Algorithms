/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    // Time O(n)
    // Space O(n)
    // 20mins
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> hmap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Employee employee : employees) {
            hmap.put(employee.id, employee);
        }

        queue.offer(id);
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Employee e = hmap.get(queue.poll());
                ans += e.importance;

                if (e.subordinates.size() != 0) {
                    for (int j = 0; j < e.subordinates.size(); j++) {
                        queue.offer(e.subordinates.get(j));
                    }
                }
            }
        }
        return ans;
    }
}