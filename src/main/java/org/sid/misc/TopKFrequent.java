package org.sid.misc;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.Map.*;
import java.util.stream.Collectors;

public class TopKFrequent {

    public static void main(String[] args) {
        topKFrequentUsingHeap(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

    // HashMap and sorting
    public static int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>(nums.length);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        LinkedHashMap<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        var x = sortedMap.keySet().stream().limit(k).toArray(Integer[]::new);

        int[] returnVal = new int[k];

        for (int j = 0; j < x.length; j++) {
            returnVal[j] = x[j];
        }

        return returnVal;
    }


    // PriorityQueue
    public static int[] topKFrequentUsingHeap(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>(nums.length);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        var pairs = map.entrySet().stream().map(e -> new Pair(e.getKey(), e.getValue())).collect(Collectors.toList());
        System.out.println(pairs);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(pairs);
        System.out.println(pq);

        int[] returnVal = new int[k];
        int counter = 0;
        while(counter < k && !pq.isEmpty()){
            returnVal[counter] = pq.poll().num;
            counter++;
        }
        System.out.println(Arrays.toString(returnVal));
        return returnVal;
    }
}

class Pair implements Comparable<Pair> {
    Integer num;
    Integer count;

    Pair(Integer num, Integer count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public String toString() {
        return "{ num = " + num + ", count = " + count + "}";
    }

    @Override
    public int compareTo(Pair p) {
        return Integer.compare(this.count, p.count);
    }
}
