package boj.july;

import java.util.LinkedList;

class Node {
    int index;
    int priority;

    public Node(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public int getPriority() {
        return priority;
    }
}

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        int result = solution(priorities, location);
        System.out.println(result);
    }

    public static int solution(int[] priorities, int location) {
        LinkedList<Node> list = new LinkedList<>();
        // 우선순위가 높은 노드를 먼저 출력
        for (int i = 0; i < priorities.length; i++) {
            Node node = new Node(i, priorities[i]);
            list.add(node);
        }
        Node first;
        int time = 1;
        while (true) {
            first = list.pop();
            boolean check = true;
            for (Node node : list) {
                if (node.getPriority() > first.getPriority()) {
                    list.addLast(first);
                    check = false;
                    break;
                }
            }

            if (check) {
                if (location == first.getIndex()) {
                    break;
                }
                time++;
            }
        }

        return time;
    }
}
