# 1. 이진탐색

### 1) 이진탐색 개념

- 정렬된 리스트에서 검색 범위를 줄여 나가면서 검색 값을 찾는 알고리즘
- 정렬된 리스트에만 사용해야 하는 단점, 검색이 반복될 때마다 검색 범위가 절반으로 줄기 때문에 속도가 빠르다는 장점

### 2) 동작 방식

1. 배열의 중간값을 가져온다
2. 중간값과 검색값을 비교한다
    1. 중간 값이 검색 값과 같다면 종료
    2. 중간 값보다 검색 값이 크다면 중간값 기준 배열의 오른쪽 구간을 대상으로 탐색 (mid < key)
    3. 중간 값보다 검색 값이 작다면 중간 값 기준 배열의 왼쪽 구간을 대상으로 탐색
3. 값을 찾거나 간격이 비어있을 때까지 반복한다.

### 3) 구현 코드

- 순환 호출

```java
int binarySearch1(int key, int low, int high) {
	int mid;

	if(low <= high) {
		mid = (low + high) / 2;

		if(key == arr[mid]) { // 탐색 성공 
			return mid;
		} else if(key < arr[mid]) {
			// 왼쪽 부분 arr[0]부터 arr[mid-1]에서의 탐색 
			return binarySearch1(key ,low, mid-1);  
		} else {
			// 오른쪽 부분 - arr[mid+1]부터 arr[high]에서의 탐색 
			return binarySearch1(key, mid+1, high); 
		}
	}

	return -1; // 탐색 실패 
}
```

- 반복

```java
int binarySearch2(int key, int low, int high) {
	int mid;

	while(low <= high) {
		mid = (low + high) / 2;

		if(key == arr[mid]) {
			return mid;
		} else if(key < arr[mid]) {
			high = mid - 1;
		} else {
			low = mid + 1;
		}
	}

	return -1; // 탐색 실패 
}
```

---

# 2. DP (동적계획법)

### 1) dp 개념

- 크고 복잡한 문제를 여러 개의 작고 간단한 문제들로 분리하여 문제를 해결하는 방법
- 답을 찾아가는 과정에서 작은 문제들을 계산한 결과를 기록하고, 재활용하며 문제의 답을 구하는 방식

### 2) 동작 방식

- dp를 사용하려면
    - 큰 문제를 작은 문제 여러 개로 나눌 수 있어야 한다
- 구현 방법
    - 메모이제이션 방법: 모든 작은 문제들을 한번만 계산해서 dp 테이블에 저장하여, 그 값들을 재사용하는 방법 - 탑다운
    - 타뷸레이션 방법: 작은 문제부터 순차적으로 계산하며 상위로 올라가는 방법 - 바텀업

### 3) 구현 코드

1. 탑다운 = 메모이제이션

```java
public class DP_TopDown{
    static int[] DP;

    public static void main(String[] args) {
        //피보나치 수열
        int n = 7;
        DP = new int[n + 1];
        for (int i = 0; i < DP.length; i++) {
            DP[i] = -1;
        }
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n){
        if(n <= 2){
            return 1;
        }
        if(DP[n] != -1){
            return DP[n];
        }
        DP[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return DP[n];
    }
}

```

1. 바텀업 = 타뷸레이션

```java
public class DP_Bottom_up {
    //타뷸레이션(바텀 업) 방식으로 풀이
    public static void main(String[] args) {
        //피보나치 수열
        int n = 7;
        System.out.println(fibonacci(n));
    }
    public static int fibonacci(int n) {
        int[] DP = new int[n < 2 ? 2 : n+1];
        DP[1] = 1;
        DP[2] = 1;

        for (int i = 3; i <= n; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }
        return DP[n];
    }
}
```
