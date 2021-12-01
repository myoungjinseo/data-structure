public class Sort {
	//Hw5. 202014132 서명진
		
	public void printArray(int a[]) {		//배열 출력 메소드
		for (int i = 0; i < a.length; i++)		// i = 0~a-1 까지 반복문 실행
			System.out.printf("%d ", a[i]);		// a[i] 출력
		System.out.println();
	}
	
	private int mergedArray[] = new int [30];		//병합배열 생성 
	
	public void merge(int a[], int begin, int end) {	//병합 메소드
		
		int middle = (begin + end)/2;		//시작과 끝에 절반 값을 가지는 변수
		int i = begin;			//  시작 변수
		int j = middle + 1;		//	중간 변수 +1, 변수가 두개일때는 오른쪽(상대적으로 큰) 변수 , 4개 이상일때는 왼쪽(상대적으로 작은) 변수이다.   
		int k = begin;			//	시작 변수
		
		while(i <= middle && j <= end) {		// i <= middle  그리고 j <= end 일 경우 무한 루프
			if (a[i] <= a[j]) {			//a[i]<= a[j] 일 경우
				mergedArray[k++] = a[i++];		// 병합 배열[k] 에 a[i]값을 넣고 k+1 , i+1 시킴 
			} else {		//아닌 경우
				mergedArray[k++] = a[j++];		// 병합 배열[k] 에 a[j]값을 넣고 k+1 , j+1 시킴
			}
		}
		
		if(i > middle) {			//i> middle 일 경우
			for (int t = j; t <= end; k++, t++) {	//t = j~ end 까지 반복문 실행 , k도 반복문 실행동안 같이 +1이 됨
				mergedArray[k] = a[t];		//병합배열[k] 에 a[t] 값 대입
			}	
		} else {		//아닐 경우
			for (int t = i; t <= middle; k++, t++) {		////t = i~ middle 까지 반복문 실행 , k도 반복문 실행동안 같이 +1이 됨
				mergedArray[k] = a[t]; 		//병합배열[k] 에 a[t] 값 대입
			}			
		}
		
		for (int t = begin; t <= end; t++) {		//t = begin 변수 부터 end 변수까지 반복문 실행
			a[t] = mergedArray[t];			//a[t] 에 병합배열 값 대입
		}
		
		System.out.printf("병합 정렬 : ");		// "병합 정렬: " 출력
		printArray(a);			//배열 a 출력
	}
	
	public void mergeSort(int a[], int begin, int end) {		//병합정렬 메소드
		if (begin < end) {		//begin < end가 될 경우
			int middle = (begin + end)/2;		//middle = (begin + end)/2 변수 생성 
			mergeSort(a, begin, middle);		//mergeSort 재귀함수를 이용해서 반으로 분해 
			mergeSort(a, middle+1, end);		//mergeSort 재귀함수를 이용해서 반으로 분해 
			merge(a, begin, end);				//merge 실행  
		}
	}

	public int partition(int a[], int begin, int end) {		//퀵 정렬 피봇을 구하는 메소드
		int L = begin;		//왼쪽 변수 = 시작 변수 로 생성
		int R = end;		//오른쪽 변수 = 끝 변수 로 생성
		int pivot = (begin + end) / 2;		//피봇 = (시작 변수 + 끝 변수)/2 값 대입 
		System.out.printf("[퀵정렬 시행 : pivot=%d] ", a[pivot]);	//퀵정렬 시행: 피봇=피봇의 값 출력
		while (L < R) {		//왼쪽 변수 < 오른쪽 변수 일 경우 => L == R 일 될 때까지 무한 루프
			while ((a[L] < a[pivot]) && (L < R))		//a[L]< a[pivot] 그리고 L<R 일 경우 무한루프
				L++;		// L +1
			while ((a[R] >= a[pivot]) && (L < R))		// a[R] >= a[pivot] 그리고 L<R 일 경우 무한루프 
				R--;		//R-1
			if (L < R) {	//L<R 일경우
				int temp = a[L];	//값을 변경하기 위해 temp = a[L] 값 대입
				a[L] = a[R];		// a[L] 에 a[R] 값 대입
				a[R] = temp;		// a[R] = temp에 넣어둔 a[L] 값 대입
			}
		}
		int temp = a[pivot];		// 값을 변경하기 위해 temp 에 a[pivot] 값 대입
		a[pivot] = a[R];		// a[pivot] 에 a[R]  값 대입
		a[R] = temp;		// a[R] 에 temp에 넣어둔 a[pivot] 값대입
		printArray(a);		// 배열 a 출력 
		return L;		//L 리턴됨
	}

	public void quickSort(int a[], int begin, int end) {		//퀵 정렬 메소드
		if (begin < end) {		//시작 변수< 끝 변수 일 경우
			int p = partition(a, begin, end);		//피봇 값을 구하기 위해 
			quickSort(a, begin, p - 1);		//재귀함수 호출 quickSort 메소드를 begin ~ 피봇의 한칸 앞까지  
			quickSort(a, p + 1, end);		//재귀함수 호출 quickSort 메소드를 begin ~ 피봇의 한칸 뒤까지
		}
	}

	public void insertionSort(int a[]) {	//삽입 정렬 메소드
		System.out.printf("삽입 정렬 시작 : ");			// "삽입 정렬 시작 : " 출력
		printArray(a);		//정렬이 되지 않은 배열 출력
		int size = a.length;		//배열의 크기 변수 생성
		for (int i = 1; i < size; i++) {		// i = 1 ~ size 까지 반복문 실행
			int temp = a[i];	//temp = a[i]에 대입
			int j = i;		//j 에 i 값 대입 
			while ((j > 0) && (a[j - 1] > temp)) {		//j>0 크고 a[j-1]> temp 일 경우
				a[j] = a[j - 1];		//a[j] 에 a[j-1] 값 대입
				j--;	//j-1
			}
			a[j] = temp;		//a[j] 에 temp에 저장해둔 a[i] 값 대입 
			System.out.printf("삽입정렬 %d 단계 : ", i);		//"삽입정렬 i 단계 : " 출력
			printArray(a);		//삽입 정렬 i 단계에 있는 배열 출력
		}
	}

	public void bubbleSort(int a[]) {		//버블 정렬 메소드
		System.out.printf("버블 정렬 시작 : ");		//"버블 정렬 시작 : " 출력
		printArray(a);		//정렬이 되지 않은 배열 출력
		int size = a.length;		//배열의 크기 변수 생성
		for (int i = size - 1; i > 0; i--) {		//i = size-1~ 0 까지 역순으로 반복문 실행
			System.out.printf("버블 정렬 %d 단계 : \n", size - i);		// "버블  정렬 size-i 단계 " 출력
			for (int j = 0; j < i; j++) {		// j= 0~ i-1 까지 반복문 실행
				if (a[j] > a[j + 1]) {		//a[j] > a[j+1] 일 경우 => a[j]에 인접한 원소 비교
					int temp = a[j];		//변경하기 위해 temp에 a[j] 값 대입
					a[j] = a[j + 1];		// a[j] 에 a[j+1] 대입
					a[j + 1] = temp;		// a[j+1] 에 temp에 넣어둔 a[j] 값 대입
				}
				printArray(a);		// 현재 배열 출력
			}
		}
	}

	public void selectionSort(int a[]) {		//선택 정렬 메소드
		System.out.printf("선택 정렬 시작 : ");		//"선택 정렬 시작:" 출력
		printArray(a);							//정렬이 되지 않은 배열 출력
		for (int i = 0; i < a.length - 1; i++) {	//i = 0~a의 배열크기-1 까지 반복
			int min = i;		//최솟 값, i로 설정한 이유는 기준위치가 맨처음부터 시작됨으로  
			for (int j = i + 1; j < a.length; j++) {		// j= i+1~ a의 배열크기-1 까지 배열
				if (a[j] < a[min])		//a[j] < a[min] 일 경우
					min = j;		//min에 j값입력
			}
			int temp = a[i];		// 값을 바꿔주기 위해 temp에 a[i] 값저장
			a[i] = a[min];		// a[i] 에 a[min] 값 대입
			a[min] = temp;		// a[min]에 temp에 저장해둔 a[i] 값 대입 
			System.out.printf("선택 정렬 %d 단계 : ", i + 1); 		// "선택 정렬 i+1 단계: " 라고 출력  
			printArray(a);		//i+1 단계에 정렬된 배열 출력  
		}
	}
}
