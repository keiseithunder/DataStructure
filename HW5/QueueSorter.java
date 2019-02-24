import java.util.LinkedList;
import java.util.Queue;

class QueueSorter {
    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<Integer>();
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(1);
        System.out.println(list.peek());
        list = sortQueue2(list);

        // System.out.println(list.peek());
        while (list.isEmpty() == false) {
            System.out.print(list.peek() + " ");
            list.poll();
        }
    }

    public static int findMin(Queue<Integer> x) {
        int min = x.peek();
        Queue<Integer> temp = new LinkedList<Integer>();
        while (!x.isEmpty()) {
            if (x.peek() < min) {
                min = x.peek();
            }
            temp.add(x.remove());
        }
        while (!temp.isEmpty()) {
            x.add(temp.remove());
        }
        return min;
    }

    public static Queue<Integer> sortQueue(Queue<Integer> x) {
        Queue<Integer> temp = new LinkedList<Integer>();
        Queue<Integer> Output = new LinkedList<Integer>();
        while (!x.isEmpty()) {
            int min = findMin(x);
            while (!x.isEmpty()) {
                if (x.peek() == min) {
                    Output.add(x.remove());
                } else {
                    temp.add(x.remove());
                }
            }
            while (!temp.isEmpty()) {
                x.add(temp.remove());
            }
        }
        return Output;
    }

    public static int findMin2(Queue<Integer> x) {
        int min = x.peek();
        Queue<Integer> temp = new LinkedList<Integer>();
        while (!x.isEmpty()) {
            if (x.peek() < min) {
                min = x.peek();
            }
            temp.add(x.remove());
        }
        while (!temp.isEmpty()) {
            x.add(temp.remove());
        }
        return min;
    }

    public static Queue<Integer> sortQueue2(Queue<Integer> x) {
        Queue<Integer> Output = new LinkedList<Integer>();
        while (!x.isEmpty()) {
            int min = x.peek();
            for (int j = 0; j < x.size(); j++) {
                if (x.peek() < min) {
                    min = x.peek();
                }
                x.add(x.remove());
            }
            for (int k = 0; k < x.size(); k++) {
                if (x.peek() == min) {
                    Output.add(x.remove());
                } else {
                    x.add(x.remove());
                }
            }
        }
        return Output;
    }
}
