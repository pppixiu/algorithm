package sort.heapsort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname HeapGreater
 * @Description TODO
 * @Date 2021/6/13 10:54 上午
 * @Created by apple
 */
public class HeapGreater<T> {
    private List<T> heap;
    private HashMap<T, Integer> indexMap;
    private int heapSize;
    private Comparator<T> comparator;

    public HeapGreater(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heap = new ArrayList<>();
        this.indexMap = new HashMap<>();
        this.heapSize = 0;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }

    public T peek() {
        return heap.get(0);
    }


    public void push(T obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        heapInsert(heapSize++);
    }

    public T pop() {
        swap(0, --heapSize);
        T result = heap.remove(heapSize);
        indexMap.remove(result);
        heapify(0);
        return result;
    }

    /**
     * remove the given obj
     * find the {last element} of heap
     * then remove the {target element} by indexMap
     * then put the {last element} into the place of {target element}
     * then resign eht {last element}
     */
    public void remove(T obj) {
        T replaceObj = heap.remove(--heapSize);
        int removeIndex = indexMap.get(obj);
        indexMap.remove(obj);
        if (replaceObj != obj) {
            heap.set(removeIndex, replaceObj);
            indexMap.put(replaceObj, removeIndex);
            resign(replaceObj);
        }

    }

    /**
     * let the given obj turns to the right index
     */
    public void resign(T obj) {
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }


    public List<T> getAllElements() {
        return new ArrayList<>(heap);
    }

    /**
     * let heap(index) up
     *
     * @param index
     */
    private void heapInsert(int index) {
        while (innerCompare(index, fa(index))) {
            swap(index, fa(index));
            index = fa(index);
        }
    }

    /**
     * let heap(index) down
     *
     * @param index
     */
    private void heapify(int index) {
        int left = leftSon(index);
        while (left < heapSize) {
            int right = left + 1;
            int better = right < heapSize && innerCompare(left, right) ? left : right;
            better = innerCompare(better, index) ? better : index;
            if (better == index) {
                break;
            }
            swap(better, index);
            index = better;
            left = leftSon(index);
        }
    }

    /**
     * 比较
     *
     * @param i index i
     * @param j index j
     * @return whether heap(i) smaller than heap(j)
     * heap(i) < heap(j) true
     * heap(i) ?= heap(j) false
     */
    private boolean innerCompare(int i, int j) {
        return comparator.compare(heap.get(i), heap.get(j)) < 0;
    }

    private int fa(int index) {
        return (index - 1) / 2;
    }

    private int leftSon(int index) {
        return index * 2 + 1;
    }

    /**
     * swap the given two elements
     * and change the mapping of indexMap also
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T objI = heap.get(i);
        T objJ = heap.get(j);
        heap.set(i, objJ);
        heap.set(j, objI);
        indexMap.put(objI, j);
        indexMap.put(objJ, i);
    }
}
