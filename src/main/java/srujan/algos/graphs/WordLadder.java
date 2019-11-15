package srujan.algos.graphs;

import java.util.*;

import srujan.algos.numbers.NumberSequences;

public class WordLadder {
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> dict = new HashSet();
        Queue<String> que = new  LinkedList<>(); 
        Set<String> visited = new HashSet();
        int level = 0;
        String dummy = "DUMMY";
        for(String word : wordList)
            dict.add(word);
        que.add(beginWord);que.add(dummy);
        while(!que.isEmpty())
        {
            String curWord = que.remove();
            if(curWord.equals(dummy)){
                level++;
                if(!que.isEmpty())
                	que.add(dummy);
                else
                	return 0;
                continue;
            }
            else if(curWord.equals(endWord))
            {
                level++;
                return level;
            }
            else{
                for(int i = 0 ;i < curWord.length() ;i++){
                    char[] charArray = curWord.toCharArray();
                    char c ='a';
                    while(c <= 'z'){
                        charArray[i] = c;
                        String formedWord = new String(charArray);
                        if(dict.contains(formedWord) && !visited.contains(formedWord))
                        {
                            //dict.remove(formedWord);
                            visited.add(formedWord);
                            que.add(formedWord);
                        }
                        c++;
                    }
                }
            }
        }
        return 0;
        
    }

public static void main(String args[])
{
    List<String> wordList = new ArrayList<String>() {
    		{add("hot");add("dot");add("dog");add("lot");add("log");add("cog");}};
   System.out.println(new WordLadder().ladderLength("hit","cog",wordList));
}
}
