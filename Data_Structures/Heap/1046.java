class Solution {
    public int lastStoneWeight(int[] stones) {
        // Time O(N*logN)
        // Space O(N)
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones) heap.add(stone);
        while(heap.size()>1){
            int s1 = heap.poll();
            int s2 = heap.poll();
            if(s1!=s2)heap.add(s1-s2);
        }
        return  heap.isEmpty() ? 0 : heap.poll();
    }
}