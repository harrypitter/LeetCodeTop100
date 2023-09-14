package TOP1_10;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Top4 {

    private static void moveData(int[] num){
        /*我们创建两个指针 i 和 j，第一次遍历的时候指针 j 用来记录当前有多少 非0 元素。即遍历的时候每遇到一个 非0 元素就将其往数组左边挪，第一次遍历完后，j 指针的下标就指向了最后一个 非0 元素下标。
第二次遍历的时候，起始位置就从 j 开始到结束，将剩下的这段区域内的元素全部置为 0。
        */
        if(num.length==0)
        {
            return;
        }

        int j = 0;

        for(int i=0;i<num.length;i++){
            if(num[i]!=0){
                num[j]=num[i];
                j++;
            }
        }

        for(int i =j;i<num.length;i++){
            num[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] num = {1,0,2,3,4,0,5,9,0,7,8,0};
        moveData(num);
        for(int i = 0;i<num.length;i++){
            System.out.println(num[i]);
        }
        System.out.println("---------");
        int[] num2 = {5,0,2,3,4,0,5,9,0,7,8,0};
        moveDataTwo(num2);
        for(int i = 0;i<num2.length;i++){
            System.out.println(num2[i]);
        }
    }


    private static void moveDataTwo(int[] num){
        /*这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点 x，然后把所有小于等于 x 的元素放到 x 的左边，大于 x 的元素放到其右边。
        这里我们可以用 0 当做这个中间点，把不等于 0(注意题目没说不能有负数)的放到中间点的左边，等于 0 的放到其右边。
        这的中间点就是 0 本身，所以实现起来比快速排序简单很多，我们使用两个指针 i 和 j，只要 nums[i]!=0，我们就交换 nums[i] 和 nums[j]
        */

        if(num.length==0){
            return;
        }
        int j=0;
        for(int i=0;i<num.length;i++){
            if(num[i]!=0){
                int temp = num[i];
                num[i] = num[j];
                num[j++] = temp;
            }
        }
    }

}
