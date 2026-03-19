package AISD_homeworks.HW4;


class BinarySearch {
    public int findFirst(int[] arr, int input) {
        int low = 0;
        int high = arr.length;
        int result = -1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < input) {
                low = mid + 1;
            } else if (arr[mid] > input) {
                high = mid;
            } else {
                result = mid;
                high = mid;
            }
        }
        return result;
    }

    public int findLast(int[] arr, int input) {
        int low = 0;
        int high = arr.length;
        int result = -1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < input) {
                low = mid + 1;
            } else if (arr[mid] > input) {
                high = mid;
            } else {
                result = mid;
                low = mid + 1;
            }
        }
        return result;
    }
}
