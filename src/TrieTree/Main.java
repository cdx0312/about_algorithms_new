package TrieTree;

import java.util.HashMap;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-20 22:42
 **/
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("I");
        trie.insert("Love");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("xiaoliang");
        trie.insert("xiaoliang");
        trie.insert("man");
        trie.insert("handsome");
        trie.insert("love");
        trie.insert("chinaha");
        trie.insert("her");
        trie.insert("know");

        HashMap<String,Integer> map=trie.getAllWords();

        for(String key:map.keySet()){
            System.out.println(key+" 出现: "+ map.get(key)+"次");
        }


        map=trie.getWordsForPrefix("chin");

        System.out.println("包含chin（包括本身）前缀的单词及出现次数：");
        for(String key:map.keySet()){
            System.out.println(key+" 出现: "+ map.get(key)+"次");
        }

        if(!trie.isExist("xiaoming")){
            System.out.println("字典树中不存在：xiaoming ");
        }
    }
}
