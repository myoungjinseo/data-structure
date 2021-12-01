
public class Heap {
	
		// Hw4. 202014132 서명진
		private int heapSize;		//힙 사이즈
		private int itemHeap[];		// 원소를 저장하기 위한 배열
		
		public Heap() {		//생성자 Heap
			heapSize = 0;	//초기 값 0 대입
			itemHeap = new int[50];		//배열 최댓 값 50으로 설정
		}
		
		public int getHeapSize() {		//배열을 출력위한 get메소드
			return this.heapSize;		//현재 heapSize(힙사이즈) 출력
		}
		
		public void printHeap() {		//힙을 출력해주는 메소드
			System.out.printf("\nHeap >>>");		//>>> = unsigned, 오른쪽으로 이동 / 출력물
			for(int i=1; i<=heapSize; i++)			// 1부터 힙사이즈(원소)까지 반복문 진행
				System.out.printf("[%d] ",itemHeap[i]);		//itemHeap 배열 1부터 힙사이즈(원소)까지 넣어주고 출력
		}
		
		public void insertHeap(int item) {			//힙에 item 값을 넣어준다 
			int idx = ++heapSize;			// idx = 1 + heapSize => 	먼저 1증가하고 그 값을 사용한다.
			itemHeap[idx] =item;		//itemHeap 배열 idx값 = item / item을 넣어(바꿔)준다.
			
			while(idx>1) {			//idx>1 이면 무한루프 / idx =1 이 되면 멈춘다. 
				int parentIdx = idx/2;		//정수형이기 때문에 오른쪽 자식노드의 .5는 생략되어서 => 부모의 인덱스 
				
				if(itemHeap[idx]>=itemHeap[parentIdx]) {		//힙의 특징으로 배열의 부모인덱스의 값은 배열의 자식 인덱스값보다 무조건 값이 작다.	
					break;		// 같거나 작을 경우 멈춘다.
				} else {			//itemHeap[idx] < itemHeap[parentIdx] 일 경우
					int temp = itemHeap[parentIdx];		//temp 을 이용해서 바꿔준다.		
					itemHeap[parentIdx] =itemHeap[idx];		//배열의 부모 인덱스의 값에 인덱스 값 대입
					itemHeap[idx] =temp;			// temp에 담겨진 배열의 부모 인덱스의 값을배열의 인덱스 값에 넣어준다. 
					idx = parentIdx;		//바꿔진 값인 부모 인덱스은 idx에 대입 => idx은 다시 while문으로 올라가서 idx =1이 될때까지 무한루프는 계속진행된다.
				}
			}
		}
		
		public int deleteHeap() {		//힙을 제거해주는 메소드
			int item = itemHeap[1];		//힙은 루트노드만 삭제할 수 있다. 삭제할 루트노드를 itmp 변수에 넣어준다.
			int idx =1;					//인덱스를 1로 설정
			itemHeap[idx] =itemHeap[heapSize];		//배열의 1의 값(루트노드의 값) 을 마직막 노드의 값을 대입
			heapSize--;		//힙사이즈 감소
			
			while(idx <= heapSize/2) {		//인덱스가 힙사이즈나누기 2보다 작아질 때까지 무한루프 =>
				int childIdx;		//자식 인덱스
				int leftChildIdx =idx*2;		//왼쪽 자식인덱스
				int rightChildIdx = idx *2+1;		//오른쪽 자식인덱스
				
				if ((rightChildIdx <= heapSize) && (itemHeap[leftChildIdx] > itemHeap[rightChildIdx])) {		//오른쪽 자식인덱스가 힙사이즈보다 작고 배열의 왼쪽 자식인덱스가 배열의 오른쪽 자식인덱스보다 클 경우
					childIdx = rightChildIdx;		//자식 인덱스에 오른쪽 자식인덱스 대입
				} else {		//아닐 경우 배열의 왼쪽 자식인덱스의 값이 더 작을 경우 =>  부모 노드의 값은 경우 자식 노드의 값보다 작아야하므로 
					childIdx = leftChildIdx;		//자식 인덱스에 왼쪽자식인덱스 대입
				}
				if(itemHeap[idx]<=itemHeap[childIdx]) {		//인덱스의 값 중 바꿔진 자식 인덱스보다 작은 경우
					break;		//멈춘다.
				} else {		//인덱스의 값 중 자식 인덱스보다 큰 경우 
					int temp = itemHeap[childIdx];		//temp의 배열의 자식인덱스 값을 대입
					itemHeap[childIdx] = itemHeap[idx];		// 배열의 자식인덱스의 값에 배열의 인덱스 값 대입
					itemHeap[idx] =temp;		//배열의 인덱스값을 저장해둔 자식의 인덱스 값을 넣어줌으로 값을 바꿔준다.
					idx = childIdx;		//인덱스 값은 자식 인덱스 값을 변경되면서 무한 루프를 계속 진행
				}
			}
			return item;		//while 문이 끝나고 저장해둔 item 값(루트 노드)을 리턴해준다.
		}	
	}


