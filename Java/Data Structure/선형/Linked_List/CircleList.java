public class CircleList {
    public static void main(String[] args) {
        CircularLinkedList<Integer> intList = new CircularLinkedList<>();
        
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);
        intList.add(50);
        intList.add(60);
        
        System.out.println("리스트 목록 : ");
        intList.printList(); // 리스트 출력

       
        CircularLinkedList<String> stringList = new CircularLinkedList<>();
        
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Cherry");
        
        System.out.println("\n문자열 리스트 : ");
        stringList.printList(); // 문자열 리스트 출력
    }
}

class CircularLinkedList<T> {
    private Node<T> tail; // 마지막 노드를 가리키는 변수
    private int size;

    private static class Node<T> {
        T data;   
        Node<T> next; 

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        tail = null;
        size = 0;
    }

    //get
    public T get(int index){
        if (tail == null) {
            System.out.println("리스트가 비어 있습니다.");
            return null;
        }
        Node<T> currentNode = tail.next; //처음 데이터부터 시작
        int cricleIndex = 0;

        while (currentNode != tail && cricleIndex < index) {
            currentNode = currentNode.next; //다음 노드로 이동
            cricleIndex ++; //순회하면서 ++ 
        }
        if (cricleIndex == index){ 
            return currentNode.data;
        }
        return null; 
    }

    //getFirst
    public T getFirst(){
        return (tail != null) ? tail.next.data : null; 
    }

    //getLast
    public T getLast(){
        return (tail != null) ? tail.data : null; 
    }

    //add
    public void add(T data) {
        if(contains(data)){
            System.out.println("이미 중복된 값이 존재합니다.");
            return;
        }
        Node<T> newNodeToAdd = new Node<>(data); 
        if (tail == null) { 
            newNodeToAdd.next = newNodeToAdd; 
            tail = newNodeToAdd;
        } else {
            newNodeToAdd.next = tail.next; 
            tail.next = newNodeToAdd; 
            tail = newNodeToAdd; 
        }
        size++;
    }

    //addFirst
    //addLast

    // remove (value)
    // remove (index)

    // removeFirst
    public void removeFirst() {
        if (tail == null) {  
            System.out.println("리스트가 비어 있습니다.");
            return;
        }
        if (tail.next == tail) { 
            tail = null;  
        } else { 
            tail.next = tail.next.next;  // 첫 번째 노드를 삭제하고, tail.next를 두 번째 노드로 변경
        }
        size--;  
    }
    
    // removeLast
    public void removeLast() {
        if (tail == null) {  
            System.out.println("리스트가 비어 있습니다.");
            return;
        }
        if (tail.next == tail) { 
            tail = null;  
        } else { 
            Node<T> currentNode = tail.next;  
            while (currentNode != tail) {  //현재 tail 바로 전까지 반복
                currentNode = currentNode.next;
            }
            currentNode.next = tail.next; //끝 두번째 포인터를 첫번째 노드로 지정
            tail = currentNode; //이제 끝은 지금 노드! (끝 두)
        }
        size--;  
    }

    // clear
    public void clear() {
        if (tail == null) {  
            return;
        }
        Node<T> currentNode = tail.next;  // 첫 번째 노드부터 시작
        Node<T> nextNode;
    
        // 리스트를 순회하면서 모든 노드를 삭제
        while (currentNode != tail) {
            nextNode = currentNode.next;  // 다음 노드를 기억
            currentNode.next = null;      // 현재 노드의 next를 null로 설정하여 연결 끊기
            currentNode = nextNode;       // 다음 노드로 이동
        }
    
        // 마지막 노드 (tail)도 제거
        tail.next = null;
        tail = null;  // tail을 null로 설정하여 리스트를 비움
    
        size = 0;  // 리스트 크기도 0으로 설정
    }
    
    // contains 
    public boolean contains(T data) {
        if (tail == null) {
            return false;
        }
        Node<T> currentNode = tail.next;
        while (currentNode != tail) {  
            if (currentNode.data.equals(data)) {  
                return true; //일차하는거 바로 찾으면 true 반환
            }
            currentNode = currentNode.next;
        }
        return currentNode.data.equals(data); //tail 확인
    }
    
    // size
    public int size(){
        return size;
    }

    public void printList() {
        if (tail == null) {
            System.out.println("리스트가 비어 있습니다.");
            return;
        }
    
        Node<T> currentNode = tail.next;  // 첫 번째 노드부터 시작
    
        while (currentNode != tail) {
            System.out.print(currentNode.data);  // 데이터 출력
            System.out.print(" (" + currentNode.next.data + ")");
    
            currentNode = currentNode.next; // 다음 노드로 이동
    
            if (currentNode != tail) {
                System.out.print(" -> "); // 노드 사이에 화살표 출력
            }
        }
        System.out.print(currentNode.data);  // 데이터 출력
    }
    
}


