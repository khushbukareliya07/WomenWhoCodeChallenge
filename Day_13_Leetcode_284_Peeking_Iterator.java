// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

//we'll use native iterator. 
/*
Approach: 
1. Peek method: 
if top is not null, we'l return top. 
if top is null, check if hasNext() is true; if so, we store itr.next in top. 

2. Next method
if top != null; i.e. we previosuly advanced pointer, at the time of peeking. 
so, dont move pointer, just return the top value, and reset the top. 
if top is null, check hasNext(); if next element is available, just return the itr.next() value.
else return -1.

3. hasNext() method
this method just check the immediate enxt element i te list, if available returns true, otherwise false.
*/
//For all 3 methods TC: O(1); SC: O(1) 
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> itr;
    Integer top;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.itr = iterator;
        top = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (top == null && hasNext()) {
            top = itr.next();
        }
        return top;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.

    @Override
    public Integer next() {
        if (top != null) {
            Integer temp = top;
            top = null;
            return temp;
        }
        if (hasNext()) {
            return itr.next();
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        if (top == null && !itr.hasNext())
            return false;
        return true;
    }
}