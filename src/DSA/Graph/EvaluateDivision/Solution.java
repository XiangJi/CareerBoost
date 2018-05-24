package DSA.Graph.EvaluateDivision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

// 汇率转换 G 面经
 * DFS
 * 高频
 * follow up 使得query时间最优:
 * Union find
 */
class Solution {
    HashMap<String, List<GraphNode>> map;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!map.containsKey(equation[0])) {
                map.put(equation[0], new ArrayList<>());
            }
            map.get(equation[0]).add(new GraphNode(equation[1], values[i]));
            if (!map.containsKey(equation[1])) {
                map.put(equation[1], new ArrayList<>());
            }
            map.get(equation[1]).add(new GraphNode(equation[0], 1 / values[i]));
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = find(queries[i][0], queries[i][1], 1, new HashSet<>());
        }
        return res;
    }

    private double find(String start, String end, double value, HashSet<String> visited) {
        if (visited.contains(start)) return -1;
        if (!map.containsKey(start)) return -1;

        if (start.equals(end)) return value;
        visited.add(start);
        for (GraphNode next : map.get(start)) {
            double sub = find(next.den, end, value * next.val, visited);
            if (sub != -1.0) return sub;
        }
        visited.remove(start);
        return -1;
    }

    class GraphNode {
        String den;
        double val;
        GraphNode(String den, double val) {
            this.den = den;
            this.val = val;
        }
    }
}

//O(1) check
class SolutionUnionFind {
    Map<String, Integer> dict;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        dict = new HashMap<>();
        int index = 0;
        for(int i = 0; i < equations.length; i++) {
            if(!dict.containsKey(equations[i][0])) {
                dict.put(equations[i][0], index);
                index++;
            }
            if(!dict.containsKey(equations[i][1])) {
                dict.put(equations[i][1], index);
                index++;
            }
        }

        UnionFind uf = new UnionFind(equations, values);

        double[] results = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            if(!dict.containsKey(queries[i][0]) || !dict.containsKey(queries[i][1])) {
                results[i] = -1.0;
            } else {
                if(uf.find(dict.get(queries[i][0])) != uf.find(dict.get(queries[i][1]))) {
                    results[i] = -1.0;
                } else {
                    double dividend = uf.valueArray[dict.get(queries[i][0])];
                    double divisor = uf.valueArray[dict.get(queries[i][1])];
                    results[i] = dividend / divisor;
                }
            }
        }

        return results;
    }

    class UnionFind {
        int[] parents;
        double[] valueArray;

        public UnionFind(String[][] equations, double[] values) {
            parents = new int[dict.size()];
            valueArray = new double[dict.size()];

            for(int i = 0; i < parents.length; i++) {
                parents[i] = i;
                valueArray[i] = 1;
            }

            for(int i = 0; i < equations.length; i++) {
                union(equations[i][0], equations[i][1], values[i]);
            }
        }

        public void union(String num1, String num2, double value) {
            int root = find(dict.get(num1));
            parents[root] = dict.get(num2);
            valueArray[root] = value / valueArray[dict.get(num1)];
        }

        public int find(int node) {
            if(parents[node] == node) {
                return node;
            }
            int root = find(parents[node]);
            valueArray[node] = valueArray[node] * valueArray[parents[node]];
            parents[node] = root;
            return parents[node];
        }
    }
}