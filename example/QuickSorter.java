package example;

public class QuickSorter implements Sorter {
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
        quickSort(a, 0, len - 1);
    }

    public void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                plan += "" + array[i] + "<->" + array[j] + "\n";
            }
        }

        // 将基准数放到中间的位置（基准数归位）

        if (base != array[i]) {
            plan += "" + base + "<->" + array[i] + "\n";
            array[left] = array[i];
            array[i] = base;
        }

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    };

    @Override
    public String getPlan() {
        return this.plan;// 排序的顺序
    }
}
