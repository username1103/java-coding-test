package implement;

public class implement7 {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        boolean result = solution(key, lock);
        System.out.println(result);
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean result = false;
        int lockLength = lock.length;
        int keyLength = key.length;

        int[][] extensionLock = new int[lockLength + (keyLength - 1) * 2][lockLength + (keyLength - 1) * 2];
        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                extensionLock[i + (keyLength - 1)][j + (keyLength - 1)] = lock[i][j];
            }
//            System.arraycopy(lock[i], 0, extensionLock[i + (keyLength - 1)], 0 + (keyLength - 1), lockLength);
        }

        for (int i = 0; i < extensionLock.length - (keyLength - 1); i++) {
            for (int j = 0; j < extensionLock.length - (keyLength - 1); j++) {
                for (int time = 0; time < 4; time++) {
                    int[][] cloneExtensionLock = deepCopy(extensionLock);

                    // 키 매칭
                    for (int k = 0; k < key.length; k++) {
                        for (int l = 0; l < key.length; l++) {
                            cloneExtensionLock[i + k][j + l] += key[k][l];
                        }
                    }

                    // 확인
                    boolean isSuccess = true;
                    for (int k = 0; k < lockLength; k++) {
                        for (int l = 0; l < lockLength; l++) {
                            if (cloneExtensionLock[k + (keyLength - 1)][l + (keyLength - 1)] != 1) {
                                isSuccess = false;
                                break;
                            }
                        }
                        if (!isSuccess) {
                            break;
                        }
                    }

                    if (!isSuccess) {
                        key = rotate90(key);
                    } else {
                        result = true;
                        break;
                    }
                }

                if (result) {
                    break;
                }
            }
            if (result) {
                break;
            }
        }

        return result;
    }

    // 90도 회전 코드
    public static int[][] rotate90(int[][] key) {
        int rowLength = key.length;
        int colLength = key[0].length;
        int[][] newKey = new int[colLength][rowLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                newKey[j][rowLength - i - 1] = key[i][j];
            }
        }
        return newKey;
    }

    // 자바에서 2차원 배열을 복사하기 위해선 단순히 clone()으로 되지 않는다.
    // 이중 반복문을 통해 초기화하거나 반복문 + System.arraycopy()를 사용해야한다.
    public static int[][] deepCopy(int[][] array) {
        int[][] copiedArray = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                copiedArray[i][j] = array[i][j];
            }
//          (원본, 원본시작위치, 복사본, 복사본시작위치, 복사할 수)
//          System.arraycopy(array[i], 0, copiedArray[i], 0, array.length);
        }
        return copiedArray;
    }
}
