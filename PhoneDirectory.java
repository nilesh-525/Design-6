class PhoneDirectory {
  
    /*
      Time : 
            - get()     | O(1)
            - check()   | O(1)
            - release() | O(1)
      Space : O(N) | at any time there will be maximum of  N element stored in ( inUseSet + queue)
    */
    HashSet<Integer> inUseSet = new HashSet<>();
    int counter;
    int maxNumbers;
    Queue<Integer> que = new LinkedList<>();
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        counter = 0;
        this.maxNumbers = maxNumbers;
        
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(!que.isEmpty()){
            int ret = que.poll();
            inUseSet.add(ret);
            return ret;
        }else
        if(counter < maxNumbers){
            int ret = counter;
            inUseSet.add(ret);
            counter++;
            return ret;
        }
        
        
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !inUseSet.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(inUseSet.contains(number)){
            inUseSet.remove(number);
            que.add(number);
        }
        
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
