package TrieTree;

import java.util.HashMap;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-20 21:22
 **/
public class Trie {
    private class Node {
        private int dumpliNum;
        private int prefixNum;
        private Node childs[];
        private boolean isLeaf;

        public Node() {
            // 子串的重复数量
            this.dumpliNum = 0;
            // 以该子串为前缀的子串数
            this.prefixNum = 0;
            this.childs = new Node[26];
            this.isLeaf = false;
        }
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String words) {
        insert(this.root, words);
    }

    /**
     * 插入节点
     * @param root
     * @param words
     */
    private void insert(Node root, String words) {
        words = words.toLowerCase();
        char[] chars = words.toCharArray();

        for (int i = 0, length = chars.length; i < length; i++) {
            int index = chars[i] - 'a';
            if (root.childs[index] != null)
                root.childs[index].prefixNum++;
            else {
                root.childs[index] = new Node();
                root.childs[index].prefixNum++;
            }
            if (i == length - 1) {
                root.childs[index].isLeaf = true;
                root.childs[index].dumpliNum++;
            }
            root = root.childs[index];
        }
    }

    /**
     * 查找所有节点及其数量
     * @return
     */
    public HashMap<String, Integer> getAllWords() {
        return preTraversal(this.root, "");
    }

    private HashMap<String, Integer> preTraversal(Node root, String prefix) {
        HashMap<String, Integer> map = new HashMap<>();
        if (root != null) {
            if (root.isLeaf)
                map.put(prefix, root.dumpliNum);

            for (int i = 0; i < root.childs.length; i++) {
                if (root.childs[i] != null) {
                    char ch = (char) (i + 'a');
                    String tmp = prefix+ch;
                    map.putAll(preTraversal(root.childs[i], tmp));
                }
            }
        }
        return map;
    }

    /**
     * 查询子串是否在字典树中
     * @param words
     * @return
     */
    public boolean isExist(String words) {
        return search(this.root, words);
    }

    private boolean search(Node root, String words) {
        char[] chars = words.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (root.childs[index] == null)
                return false;
            root = root.childs[index];
        }
        return true;
    }

    public HashMap<String, Integer> getWordsForPrefix(String prefix) {
        return getWordsForPrefix(this.root, prefix);
    }

    private HashMap<String, Integer> getWordsForPrefix(Node root, String prefix) {
        HashMap<String, Integer> map = new HashMap<>();
        char[] chars = prefix.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (root.childs[index] == null)
                return null;
            root = root.childs[index];
        }
        return preTraversal(root, prefix);
    }
}
