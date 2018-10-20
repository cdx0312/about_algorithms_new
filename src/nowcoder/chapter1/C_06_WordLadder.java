package nowcoder.chapter1;

import java.util.*;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-24 14:56
 **/
public class C_06_WordLadder {
    public static void main(String[] args) {
        List<String> worldList = new ArrayList<>();
        worldList.add("hot");
        worldList.add("dot");
        worldList.add("dog");
        worldList.add("lot");
        worldList.add("log");
        worldList.add("cog");
        List<List<String>> res = findLadders("hit", "cog", worldList);
        for (List<String> list : res)
            System.out.println(list);
    }

    private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        HashMap<String, ArrayList<String>> nexts = getNexts(wordList);
        HashMap<String, Integer> distances = getDistances(beginWord, nexts);
        LinkedList<String> pathList = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        getShortestPath(beginWord, endWord, nexts, distances, pathList, res);
        return res;
    }
    // 获取最短路径
    private static void getShortestPath(String beginWord, String endWord, HashMap<String, ArrayList<String>> nexts, HashMap<String, Integer> distances, LinkedList<String> pathList, List<List<String>> res) {
        pathList.add(beginWord);
        if (endWord.equals(beginWord))
            res.add(new LinkedList<>(pathList));
        else {
            for (String s : nexts.get(beginWord)) {
                if (distances.get(s) == distances.get(beginWord) + 1)
                    getShortestPath(s, endWord, nexts, distances, pathList, res);
            }
        }
        pathList.pollLast();
    }

    // 获取所有单词的邻居
    private static HashMap<String, ArrayList<String>> getNexts(List<String> words) {
        Set<String> dict = new HashSet<>(words);
        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
        for (String word : words) {
            nexts.put(word, getNext(word, dict));
        }
        System.out.println("=====所有单词的邻居为：");
        System.out.println(nexts);
        return nexts;
    }
    // 获取指定的单词的邻居
    private static ArrayList<String> getNext(String word, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (char cur = 'a'; cur <= 'z'; cur++) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != cur) {
                    char tmp = chars[i];
                    chars[i] = cur;
                    if (dict.contains(String.valueOf(chars)))
                        res.add(String.valueOf(chars));
                    chars[i] = tmp;
                }
            }
        }
        return res;
    }

    // 获取字典中的字符与指定字符串之间的距离
    private static HashMap<String, Integer> getDistances(String begin, HashMap<String, ArrayList<String>> nexts) {
        HashMap<String, Integer> distances = new HashMap<>();
        distances.put(begin, 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        HashSet<String> isVisited = new HashSet<>();
        isVisited.add(begin);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String str : nexts.get(cur)) {
                if (!isVisited.contains(str)) {
                    distances.put(str, distances.get(cur) + 1);
                    queue.offer(str);
                    isVisited.add(str);
                }
            }
        }
        System.out.println("=====所有单词的距离为：");
        System.out.println(distances);
        return distances;
    }
}
