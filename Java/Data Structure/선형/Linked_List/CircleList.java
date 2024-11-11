class CircularLinkedList {
    private Node last; // 마지막 노드를 가리키는 변수

    private static class Node {
        int data; // 데이터
        Node next; // 다음 노드를 가리키는 포인?터

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        last = null;
    }

    // 리스트에 노드 추가하는 메서드
    public void add(int data) {
        Node newNode = new Node(data);
        if (last == null) { // 리스트가 비어있는 경우-> 즉 첫번째 노드일 경우!
            newNode.next = newNode; // 첫 번째 노드는 자기 자신을 가리키게 설정 (원형이여야 해서)
            last = newNode;
        } else {
            newNode.next = last.next; // 새 노드는 첫 번째 노드를 가리키게
            last.next = newNode; // 마지막 노드의 next가 새 노드를 가리키게
            last = newNode; // 마지막 노드를 새 노드로 갱신
        }
    }

    // 리스트를 출력하는 메서드
    public void printList() {
        if (last == null) {
            System.out.println("리스트가 비어 있습니다.");
            return;
        }

        Node current = last.next;  // 첫 번째 노드부터 시작
        boolean firstIter = true;  // 첫 번째 순회인지 여부를 체크하는 변수 
        
  
        while (firstIter || current != last.next) {
            System.out.print(current.data);  // 현재 노드의 데이터 출력
            System.out.print(" (" + current.next.data + ")");  // 다음 노드의 데이터 출력

            // 다음 노드로 이동
            current = current.next;

            // 첫 번째 순회가 끝났다면 false로 설정
            firstIter = false;

            // 1번만 순회하기 위해 break
            if (current == last.next) {
                break;
            }
            
            System.out.print(" -> ");  // 노드 사이에 화살표 출력
        }

    }

}

public class CircleList {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        
        System.out.println("리스트 목록 : ");
        list.printList();
        
    }
}
