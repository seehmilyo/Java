package test97;
import java.util.*;
class Node{
	int val;
	Node next;
	Node random;
}
public class Solution {
public static class StringComparator implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		// TODO �Զ����ɵķ������
		return o1.compareTo(o2);
	}
	
}

Map<String, Integer> count(String[] words) {
    Map<String, Integer> wordToCount = new HashMap<>();
    for (String word : words) {
        int c = wordToCount.getOrDefault(word, 0);
        wordToCount.put(word, c + 1);
    }

    return wordToCount;
}

Map<Integer, List<String>> remap(Map<String, Integer> wordToCount) {
    Map<Integer, List<String>> countToWordList = new HashMap<>();
    for (Map.Entry<String, Integer> e : wordToCount.entrySet()) {
        String word = e.getKey();
        int count = e.getValue();

        List<String> wordList = countToWordList.get(count);
        if (wordList == null) {
            wordList = new ArrayList<>();
            countToWordList.put(count, wordList);
        }

        wordList.add(word);
    }

    return countToWordList;
}

public List<String> topKFrequent(String[] words,int k){
//������map����һһ��Ӧ��ϵ����һ������ʵ��
	Map<String,Integer> map=count(words);
//��תmap�Ķ�Ӧ��ϵ,��һ������ʵ��
	Map<Integer, List<String>> map2=remap(map);
//��������˵�һ�ڶ���������������ѡȡk��Ԫ��
	//��ô�����������ȷ�תmapʱû�а�������key��������
	//key����󣬻�����ĿҪ������ĸ˳���ڽ������������������ȼ����ȱȽ�key���ڱȽ�value����ĸ
	Set<Integer> set=map2.keySet();//�ȱȽ�key���ԣ���ȡkey����
	int[] counts=new int[set.size()];
	int i=0;
	for(int n:set) {
		counts[i++]=n;
	}
	//�������飨����key��������
	Arrays.sort(counts);//1 2 3����
	//�ر�Ҫע����Ǵ�Ž���set�Ժ󲻻����ظ���Ԫ�أ�����keyֵ��ȣ�����Ҳ��������ظ�������

	//����������ĸ����
	List<String> result=new ArrayList<>();
	int j=0;//��¼ȡ����
	int index=counts.length-1;//�Ӻ���ǰȡԪ��
	Comparator<String> comparator=new StringComparator();
	while(j<k) {
		int c=counts[index--];
		List<String> wordlist=map2.get(c);//��ȡ��ͬkeyֵ������value
		wordlist.sort(comparator);//value���԰���ĸ��������
		if(map2.size()<k-j) {
			result.addAll(wordlist);
			j+=wordlist.size();
		}
		//��һ�㣨key�㣩��������
		else {
			result.addAll(wordlist.subList(0, k-j));
			j=k;//����ѭ��
		}
	}
	return result;
}

public static void main(String[] args) {
	String[] words= {
			"i","love","you",
			"i","love","z"
	};
	List<String> l=new Solution().topKFrequent(words, 3);
	System.out.println(l);

}
}