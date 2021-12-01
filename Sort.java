public class Sort {
	//Hw5. 202014132 ������
		
	public void printArray(int a[]) {		//�迭 ��� �޼ҵ�
		for (int i = 0; i < a.length; i++)		// i = 0~a-1 ���� �ݺ��� ����
			System.out.printf("%d ", a[i]);		// a[i] ���
		System.out.println();
	}
	
	private int mergedArray[] = new int [30];		//���չ迭 ���� 
	
	public void merge(int a[], int begin, int end) {	//���� �޼ҵ�
		
		int middle = (begin + end)/2;		//���۰� ���� ���� ���� ������ ����
		int i = begin;			//  ���� ����
		int j = middle + 1;		//	�߰� ���� +1, ������ �ΰ��϶��� ������(��������� ū) ���� , 4�� �̻��϶��� ����(��������� ����) �����̴�.   
		int k = begin;			//	���� ����
		
		while(i <= middle && j <= end) {		// i <= middle  �׸��� j <= end �� ��� ���� ����
			if (a[i] <= a[j]) {			//a[i]<= a[j] �� ���
				mergedArray[k++] = a[i++];		// ���� �迭[k] �� a[i]���� �ְ� k+1 , i+1 ��Ŵ 
			} else {		//�ƴ� ���
				mergedArray[k++] = a[j++];		// ���� �迭[k] �� a[j]���� �ְ� k+1 , j+1 ��Ŵ
			}
		}
		
		if(i > middle) {			//i> middle �� ���
			for (int t = j; t <= end; k++, t++) {	//t = j~ end ���� �ݺ��� ���� , k�� �ݺ��� ���ൿ�� ���� +1�� ��
				mergedArray[k] = a[t];		//���չ迭[k] �� a[t] �� ����
			}	
		} else {		//�ƴ� ���
			for (int t = i; t <= middle; k++, t++) {		////t = i~ middle ���� �ݺ��� ���� , k�� �ݺ��� ���ൿ�� ���� +1�� ��
				mergedArray[k] = a[t]; 		//���չ迭[k] �� a[t] �� ����
			}			
		}
		
		for (int t = begin; t <= end; t++) {		//t = begin ���� ���� end �������� �ݺ��� ����
			a[t] = mergedArray[t];			//a[t] �� ���չ迭 �� ����
		}
		
		System.out.printf("���� ���� : ");		// "���� ����: " ���
		printArray(a);			//�迭 a ���
	}
	
	public void mergeSort(int a[], int begin, int end) {		//�������� �޼ҵ�
		if (begin < end) {		//begin < end�� �� ���
			int middle = (begin + end)/2;		//middle = (begin + end)/2 ���� ���� 
			mergeSort(a, begin, middle);		//mergeSort ����Լ��� �̿��ؼ� ������ ���� 
			mergeSort(a, middle+1, end);		//mergeSort ����Լ��� �̿��ؼ� ������ ���� 
			merge(a, begin, end);				//merge ����  
		}
	}

	public int partition(int a[], int begin, int end) {		//�� ���� �Ǻ��� ���ϴ� �޼ҵ�
		int L = begin;		//���� ���� = ���� ���� �� ����
		int R = end;		//������ ���� = �� ���� �� ����
		int pivot = (begin + end) / 2;		//�Ǻ� = (���� ���� + �� ����)/2 �� ���� 
		System.out.printf("[������ ���� : pivot=%d] ", a[pivot]);	//������ ����: �Ǻ�=�Ǻ��� �� ���
		while (L < R) {		//���� ���� < ������ ���� �� ��� => L == R �� �� ������ ���� ����
			while ((a[L] < a[pivot]) && (L < R))		//a[L]< a[pivot] �׸��� L<R �� ��� ���ѷ���
				L++;		// L +1
			while ((a[R] >= a[pivot]) && (L < R))		// a[R] >= a[pivot] �׸��� L<R �� ��� ���ѷ��� 
				R--;		//R-1
			if (L < R) {	//L<R �ϰ��
				int temp = a[L];	//���� �����ϱ� ���� temp = a[L] �� ����
				a[L] = a[R];		// a[L] �� a[R] �� ����
				a[R] = temp;		// a[R] = temp�� �־�� a[L] �� ����
			}
		}
		int temp = a[pivot];		// ���� �����ϱ� ���� temp �� a[pivot] �� ����
		a[pivot] = a[R];		// a[pivot] �� a[R]  �� ����
		a[R] = temp;		// a[R] �� temp�� �־�� a[pivot] ������
		printArray(a);		// �迭 a ��� 
		return L;		//L ���ϵ�
	}

	public void quickSort(int a[], int begin, int end) {		//�� ���� �޼ҵ�
		if (begin < end) {		//���� ����< �� ���� �� ���
			int p = partition(a, begin, end);		//�Ǻ� ���� ���ϱ� ���� 
			quickSort(a, begin, p - 1);		//����Լ� ȣ�� quickSort �޼ҵ带 begin ~ �Ǻ��� ��ĭ �ձ���  
			quickSort(a, p + 1, end);		//����Լ� ȣ�� quickSort �޼ҵ带 begin ~ �Ǻ��� ��ĭ �ڱ���
		}
	}

	public void insertionSort(int a[]) {	//���� ���� �޼ҵ�
		System.out.printf("���� ���� ���� : ");			// "���� ���� ���� : " ���
		printArray(a);		//������ ���� ���� �迭 ���
		int size = a.length;		//�迭�� ũ�� ���� ����
		for (int i = 1; i < size; i++) {		// i = 1 ~ size ���� �ݺ��� ����
			int temp = a[i];	//temp = a[i]�� ����
			int j = i;		//j �� i �� ���� 
			while ((j > 0) && (a[j - 1] > temp)) {		//j>0 ũ�� a[j-1]> temp �� ���
				a[j] = a[j - 1];		//a[j] �� a[j-1] �� ����
				j--;	//j-1
			}
			a[j] = temp;		//a[j] �� temp�� �����ص� a[i] �� ���� 
			System.out.printf("�������� %d �ܰ� : ", i);		//"�������� i �ܰ� : " ���
			printArray(a);		//���� ���� i �ܰ迡 �ִ� �迭 ���
		}
	}

	public void bubbleSort(int a[]) {		//���� ���� �޼ҵ�
		System.out.printf("���� ���� ���� : ");		//"���� ���� ���� : " ���
		printArray(a);		//������ ���� ���� �迭 ���
		int size = a.length;		//�迭�� ũ�� ���� ����
		for (int i = size - 1; i > 0; i--) {		//i = size-1~ 0 ���� �������� �ݺ��� ����
			System.out.printf("���� ���� %d �ܰ� : \n", size - i);		// "����  ���� size-i �ܰ� " ���
			for (int j = 0; j < i; j++) {		// j= 0~ i-1 ���� �ݺ��� ����
				if (a[j] > a[j + 1]) {		//a[j] > a[j+1] �� ��� => a[j]�� ������ ���� ��
					int temp = a[j];		//�����ϱ� ���� temp�� a[j] �� ����
					a[j] = a[j + 1];		// a[j] �� a[j+1] ����
					a[j + 1] = temp;		// a[j+1] �� temp�� �־�� a[j] �� ����
				}
				printArray(a);		// ���� �迭 ���
			}
		}
	}

	public void selectionSort(int a[]) {		//���� ���� �޼ҵ�
		System.out.printf("���� ���� ���� : ");		//"���� ���� ����:" ���
		printArray(a);							//������ ���� ���� �迭 ���
		for (int i = 0; i < a.length - 1; i++) {	//i = 0~a�� �迭ũ��-1 ���� �ݺ�
			int min = i;		//�ּ� ��, i�� ������ ������ ������ġ�� ��ó������ ���۵�����  
			for (int j = i + 1; j < a.length; j++) {		// j= i+1~ a�� �迭ũ��-1 ���� �迭
				if (a[j] < a[min])		//a[j] < a[min] �� ���
					min = j;		//min�� j���Է�
			}
			int temp = a[i];		// ���� �ٲ��ֱ� ���� temp�� a[i] ������
			a[i] = a[min];		// a[i] �� a[min] �� ����
			a[min] = temp;		// a[min]�� temp�� �����ص� a[i] �� ���� 
			System.out.printf("���� ���� %d �ܰ� : ", i + 1); 		// "���� ���� i+1 �ܰ�: " ��� ���  
			printArray(a);		//i+1 �ܰ迡 ���ĵ� �迭 ���  
		}
	}
}
