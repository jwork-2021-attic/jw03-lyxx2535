package example;

public class ShellSorter implements Sorter {

    private int[] a;
    private String plan = "";

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    @Override
    public void sort() {
        int len;
        if (a == null || (len = a.length) == 0 || len == 1) {
            return;
        }
        shellSort(a);
    }

    public void shellSort(int[] arr) {
        // 1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        // 2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);// 将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);// 重新对堆进行调整
        }
    };

    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];// 先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {// 从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {// 如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {// 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;// 将temp值放到最终的位置
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        plan += "" + arr[a] + "<->" + arr[b] + "\n";
    }

    @Override
    public String getPlan() {
        return this.plan;// 排序的顺序
    }

}
