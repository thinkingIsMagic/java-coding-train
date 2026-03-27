package leetcode.medium;

public class Tree_leetcode208 {

    /**
    * 核心思路：每个节点是一个长度 26 的数组(指向子节点的指针数组 children)。
    * 插入：就是沿着字符一路往下建节点，最后一个节点标记 isEnd = true。
    * 查询：就是沿着字符往下走，走不通就是不存在。
    * search 和 startsWith 唯一的区别：最后一个字符是不是end节点
    * 
    * 复杂度：时间 O(n)，空间O(n * 26) ，n是word长度
    */
    class Trie {
        private Trie[] children;
        private boolean isEnd;
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
        
        public void insert(String word) {
            Trie node = this;
            for(int i=0; i<word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(node.children[index]==null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
        
        public boolean search(String word) {
            Trie node = searchWordEnd(word);

            // 最后一个字符节点不为空 && 是end节点
            return node!=null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = searchWordEnd(prefix);
            return node!=null;
        }

        // 找到word最后一个字符的节点
        private Trie searchWordEnd(String word) {
            Trie node = this;
            for(int i=0; i<word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(node.children[index]==null) return null;

                node = node.children[index];
            }
            return node;
        }
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}