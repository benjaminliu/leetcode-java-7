package com.ben.linkedlist.traverse;

import com.ben.common.PrintUtil;

import java.util.*;

public class _0332_h_Reconstruct_Itinerary {

    public static void main(String[] args) {
//        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(List.of("MUC", "LHR"));
//        tickets.add(List.of("JFK", "MUC"));
//        tickets.add(List.of("LHR", "SFO"));

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK","SFO"));
        tickets.add(List.of("JFK","ATL"));
        tickets.add(List.of("SFO","ATL"));
        tickets.add(List.of("ATL","JFK"));
        tickets.add(List.of("ATL","SFO"));



        PrintUtil.printList(new Solution().findItinerary(tickets));
    }

    static
    class Solution {

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        LinkedList<String> route = new LinkedList<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
            }

            dfs("JFK");

            return route;
        }

        private void dfs(String airport) {
            PriorityQueue<String> destinations = graph.get(airport);
            if (destinations != null) {
                while (!destinations.isEmpty()) {
                    dfs(destinations.poll());
                }
            }
            route.addFirst(airport);
        }
    }
}
