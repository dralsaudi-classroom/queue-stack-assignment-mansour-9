package com.example.project;

public class QueueStackTester {

    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq) {
        splitHelper(q, oq, eq, 1);
    }

    private static <T> void splitHelper(Queue<T> q, Queue<T> oq, Queue<T> eq, int index) {
        if (q.empty()) return;
        
        T element = q.dequeue();
        if (index % 2 != 0) {
            oq.enqueue(element);
        } else {
            eq.enqueue(element);
        }
        
        splitHelper(q, oq, eq, index + 1);
        q.enqueue(element);
    }

    public static <T> void remove(LinkedPQ<T> pq, int p) {
        if (pq.empty()) return;
        
        T element = pq.dequeue();
        if (pq.priority(element) >= p) {
            pq.enqueue(element, pq.priority(element));
        }
        
        remove(pq, p);
    }

    public static <T> boolean search(Stack<T> st, T e) {
        if (st.empty()) return false;

        T element = st.pop();
        if (element.equals(e)) {
            st.push(element);
            return true;
        }

        boolean found = search(st, e);
        st.push(element);
        return found;
    }
}
