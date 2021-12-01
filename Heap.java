
public class Heap {
	
		// Hw4. 202014132 ������
		private int heapSize;		//�� ������
		private int itemHeap[];		// ���Ҹ� �����ϱ� ���� �迭
		
		public Heap() {		//������ Heap
			heapSize = 0;	//�ʱ� �� 0 ����
			itemHeap = new int[50];		//�迭 �ִ� �� 50���� ����
		}
		
		public int getHeapSize() {		//�迭�� ������� get�޼ҵ�
			return this.heapSize;		//���� heapSize(��������) ���
		}
		
		public void printHeap() {		//���� ������ִ� �޼ҵ�
			System.out.printf("\nHeap >>>");		//>>> = unsigned, ���������� �̵� / ��¹�
			for(int i=1; i<=heapSize; i++)			// 1���� ��������(����)���� �ݺ��� ����
				System.out.printf("[%d] ",itemHeap[i]);		//itemHeap �迭 1���� ��������(����)���� �־��ְ� ���
		}
		
		public void insertHeap(int item) {			//���� item ���� �־��ش� 
			int idx = ++heapSize;			// idx = 1 + heapSize => 	���� 1�����ϰ� �� ���� ����Ѵ�.
			itemHeap[idx] =item;		//itemHeap �迭 idx�� = item / item�� �־�(�ٲ�)�ش�.
			
			while(idx>1) {			//idx>1 �̸� ���ѷ��� / idx =1 �� �Ǹ� �����. 
				int parentIdx = idx/2;		//�������̱� ������ ������ �ڽĳ���� .5�� �����Ǿ => �θ��� �ε��� 
				
				if(itemHeap[idx]>=itemHeap[parentIdx]) {		//���� Ư¡���� �迭�� �θ��ε����� ���� �迭�� �ڽ� �ε��������� ������ ���� �۴�.	
					break;		// ���ų� ���� ��� �����.
				} else {			//itemHeap[idx] < itemHeap[parentIdx] �� ���
					int temp = itemHeap[parentIdx];		//temp �� �̿��ؼ� �ٲ��ش�.		
					itemHeap[parentIdx] =itemHeap[idx];		//�迭�� �θ� �ε����� ���� �ε��� �� ����
					itemHeap[idx] =temp;			// temp�� ����� �迭�� �θ� �ε����� �����迭�� �ε��� ���� �־��ش�. 
					idx = parentIdx;		//�ٲ��� ���� �θ� �ε����� idx�� ���� => idx�� �ٽ� while������ �ö󰡼� idx =1�� �ɶ����� ���ѷ����� �������ȴ�.
				}
			}
		}
		
		public int deleteHeap() {		//���� �������ִ� �޼ҵ�
			int item = itemHeap[1];		//���� ��Ʈ��常 ������ �� �ִ�. ������ ��Ʈ��带 itmp ������ �־��ش�.
			int idx =1;					//�ε����� 1�� ����
			itemHeap[idx] =itemHeap[heapSize];		//�迭�� 1�� ��(��Ʈ����� ��) �� ������ ����� ���� ����
			heapSize--;		//�������� ����
			
			while(idx <= heapSize/2) {		//�ε����� ����������� 2���� �۾��� ������ ���ѷ��� =>
				int childIdx;		//�ڽ� �ε���
				int leftChildIdx =idx*2;		//���� �ڽ��ε���
				int rightChildIdx = idx *2+1;		//������ �ڽ��ε���
				
				if ((rightChildIdx <= heapSize) && (itemHeap[leftChildIdx] > itemHeap[rightChildIdx])) {		//������ �ڽ��ε����� ��������� �۰� �迭�� ���� �ڽ��ε����� �迭�� ������ �ڽ��ε������� Ŭ ���
					childIdx = rightChildIdx;		//�ڽ� �ε����� ������ �ڽ��ε��� ����
				} else {		//�ƴ� ��� �迭�� ���� �ڽ��ε����� ���� �� ���� ��� =>  �θ� ����� ���� ��� �ڽ� ����� ������ �۾ƾ��ϹǷ� 
					childIdx = leftChildIdx;		//�ڽ� �ε����� �����ڽ��ε��� ����
				}
				if(itemHeap[idx]<=itemHeap[childIdx]) {		//�ε����� �� �� �ٲ��� �ڽ� �ε������� ���� ���
					break;		//�����.
				} else {		//�ε����� �� �� �ڽ� �ε������� ū ��� 
					int temp = itemHeap[childIdx];		//temp�� �迭�� �ڽ��ε��� ���� ����
					itemHeap[childIdx] = itemHeap[idx];		// �迭�� �ڽ��ε����� ���� �迭�� �ε��� �� ����
					itemHeap[idx] =temp;		//�迭�� �ε������� �����ص� �ڽ��� �ε��� ���� �־������� ���� �ٲ��ش�.
					idx = childIdx;		//�ε��� ���� �ڽ� �ε��� ���� ����Ǹ鼭 ���� ������ ��� ����
				}
			}
			return item;		//while ���� ������ �����ص� item ��(��Ʈ ���)�� �������ش�.
		}	
	}


