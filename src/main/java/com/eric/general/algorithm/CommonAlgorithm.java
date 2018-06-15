package com.eric.general.algorithm;

import com.eric.general.model.ListNode;
import com.eric.general.model.TreeNode;

import java.util.*;

/**
 * 描述:
 *
 * @author eric
 * @create 2018-05-23 下午4:11
 */
public class CommonAlgorithm {

    public static void main(String[] args) {
        int[] numbers = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findContinuousSubArrayMaxSum(numbers));
    }

    /**
     * 判断二维数组中是否包含某个数字
     *
     * @param array
     * @param targetNumber
     * @return
     */
    public static boolean findNumber(int[][] array, int targetNumber) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;

        while (row < array.length && column >= 0) {
            if (array[row][column] == targetNumber) {
                return true;
            }
            if (array[row][column] > targetNumber) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * 从头到尾打印链表
     * 利用栈的特性实现
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHeadWithStack(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) {
            return arrayList;
        }
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode);
            listNode = listNode.nextNode;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop().value);
        }
        return arrayList;
    }

    public static void printListFromTailToHeadWithRecursion(ListNode listNode) {
        if (listNode.nextNode != null) {
            printListFromTailToHeadWithRecursion(listNode.nextNode);
        }
        System.out.println(listNode.value);
    }

    /**
     * 重建二叉树
     * <p>
     * 前序遍历结果{1,2,4,7,3,5,6,8}
     * 中序遍历结果{4,7,2,1,5,3,8,6}
     *
     * @param pre
     * @param middle
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] middle) {
        if (pre == null || middle == null || pre.length == 0 || middle.length == 0) {
            return null;
        }

        if (pre.length != middle.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == middle[i]) {
                // 递归
                root.leftTreeNode = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(middle, 0, i));
                root.rightTreeNode = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(middle, i + 1, middle.length));
            }
        }
        return root;
    }

    /**
     * 找出旋转数组中最小的数字
     *
     * @param array
     * @return
     */
    public static int findMinNumberInSortArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int middle = 0;
        while (array[left] >= array[right]) {
            if (right - left <= 1) {
                middle = right;
                break;
            }
            // 二分查找法
            middle = (left + right) / 2;
            // 特殊情况处理 如果三个位置值相同 需要遍历数组查询最小值
            if (array[left] == array[middle] && array[middle] == array[right]) {
                int minNumber = array[left];
                for (int i = left + 1; i <= right; i++) {
                    if (minNumber > array[i]) {
                        minNumber = array[i];
                    }
                }
                return minNumber;
            } else {
                if (array[left] <= array[middle]) {
                    left = middle;
                } else {
                    right = middle;
                }
            }
        }
        return array[middle];
    }

    /**
     * 求斐波拉契函数的第N项的值
     *
     * @param n
     * @return
     */
    public static long fibonacci(int n) {
        int result = 0;
        int fibOne = 0;
        int fibTwo = 1;
        if (n <= 0) {
            return fibOne;
        }
        if (n == 1) {
            return fibTwo;
        }
        for (int i = 2; i <= n; i++) {
            result = fibOne + fibTwo;
            fibOne = fibTwo;
            fibTwo = result;
        }
        return result;
    }

    /**
     * 统计指定数字的二进制中1的个数
     *
     * @param n
     * @return
     */
    public static int numberOfTimes(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    /**
     * 计算数值base的exponent次方的值
     *
     * @param base     数值
     * @param exponent 指数
     * @return
     */
    public static double power(double base, int exponent) {
        double result;

        // 使用doubleToLongBits方法转换double数值来比较大小
        if (Double.doubleToLongBits(base) == Double.doubleToLongBits(0)) {
            return 0;
        }
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent > 0) {
            result = mutiply(base, exponent);
        } else {
            result = mutiply(1 / base, -exponent);
        }
        return result;
    }

    public static double mutiply(double base, int exponent) {
        double sum = 1;
        for (int i = 0; i < exponent; i++) {
            sum = sum * base;
        }
        return sum;
    }


    /**
     * 打印1到最大的n位数
     * <p>
     * 考虑到大数问题 这里使用数组和递归来实现
     *
     * @param n
     */
    public static void printToMaxOfNDigits(int n) {
        // 初始化长度为n的数组
        int[] array = new int[n];
        if (n <= 0) {
            return;
        }
        printArray(array, 0);
    }

    private static void printArray(int[] array, int n) {
        // 每个位置的数值都是0到9的数字
        for (int i = 0; i < 10; i++) {

            if (n != array.length) {
                array[n] = i;
                printArray(array, n + 1);
            } else {
                boolean isFirstNo0 = false;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] != 0) {
                        System.out.print(array[j]);
                        if (!isFirstNo0) {
                            isFirstNo0 = true;
                        }
                    } else {
                        if (isFirstNo0) {
                            System.out.print(array[j]);
                        }
                    }
                }
                System.out.println();
                return;
            }
        }
    }

    /**
     * 删除List中指定节点  时间复杂度为O(1)
     *
     * @param headNode
     * @param deleteAssignNode
     */
    public void deleteAssignNode(ListNode headNode, ListNode deleteAssignNode) {
        if (headNode == null || deleteAssignNode == null) {
            return;
        }

        if (deleteAssignNode.nextNode != null) {
            // 要删除节点不是尾节点
            ListNode nextNode = deleteAssignNode.nextNode;
            deleteAssignNode.nextNode = nextNode.nextNode;
            deleteAssignNode.value = nextNode.value;
        } else if (deleteAssignNode == headNode) {
            // 要删除节点是尾节点 且链表中只有一个节点
            headNode = null;
        } else {
            // 要删除节点是尾节点 且链表中有多个节点
            ListNode listNode = headNode;
            while (listNode.nextNode != deleteAssignNode) {
                listNode = listNode.nextNode;
            }
            listNode.nextNode = null;
        }
    }


    /**
     * 数组排序
     * 将数组分为前后两部分  前半部分为奇数  后半部分为偶数
     *
     * @param array
     */
    public static void resortArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex < endIndex) {
            // 当前位置数组元素不是偶数 则移动索引
            while (startIndex < endIndex && array[startIndex] % 2 != 0) {
                startIndex++;
            }
            // 当前位置数组元素不是奇数 则移动索引
            while (startIndex < endIndex && array[endIndex] % 2 == 0) {
                endIndex--;
            }
            // 交换前半部分偶数和后半部分奇数的位置
            if (startIndex < endIndex) {
                int temp = array[endIndex];
                array[endIndex] = array[startIndex];
                array[startIndex] = temp;
            }
        }
    }

    /**
     * 返回链表的倒数第K个节点
     *
     * @param headNode 链表头结点
     * @param k        倒数第K个节点
     * @return
     */
    public ListNode findAssignListNodeFromTail(ListNode headNode, int k) {
        if (headNode == null || k == 0) {
            return null;
        }
        ListNode preNode = headNode;
        ListNode behindNode;

        for (int i = 0; i < k - 1; i++) {
            if (preNode.nextNode != null) {
                preNode = preNode.nextNode;
            } else {
                // K不在链表中
                return null;
            }
        }
        behindNode = headNode;
        while (preNode.nextNode != null) {
            preNode = preNode.nextNode;
            behindNode = behindNode.nextNode;
        }
        return behindNode;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = null;
        while (head != null) {
            ListNode listNode = head.nextNode;
            head.nextNode = temp;
            temp = head;
            head = listNode;
        }
        return temp;
    }

    /**
     * 合并两个递增排序的链表
     * 使合并之后的链表也是递增排序
     *
     * @param firstListNode
     * @param twoListNode
     * @return
     */
    public static ListNode mergeListNode(ListNode firstListNode, ListNode twoListNode) {
        if (firstListNode == null) {
            return twoListNode;
        } else if (twoListNode == null) {
            return firstListNode;
        }
        ListNode mergeListNode;
        if (firstListNode.value < twoListNode.value) {
            mergeListNode = firstListNode;
            mergeListNode.nextNode = mergeListNode(firstListNode.nextNode, twoListNode);
        } else {
            mergeListNode = twoListNode;
            mergeListNode.nextNode = mergeListNode(twoListNode.nextNode, firstListNode);
        }
        return mergeListNode;
    }

    /**
     * 判断二叉树子结构树
     *
     * @param firstTreeRoot  第一棵二叉树
     * @param secondTreeRoot 第二棵二叉树
     * @return
     */
    public static boolean hasSubTree(TreeNode firstTreeRoot, TreeNode secondTreeRoot) {
        boolean hasSunTree = false;
        if (firstTreeRoot != null && secondTreeRoot != null) {
            // 判断根节点
            hasSunTree = isTreeFirstContainTreeSecond(firstTreeRoot, secondTreeRoot);
            // 判断左子节点
            if (!hasSunTree) {
                hasSunTree = hasSubTree(firstTreeRoot.leftTreeNode, secondTreeRoot);
            }
            // 判断右子节点
            if (!hasSunTree) {
                hasSunTree = hasSubTree(firstTreeRoot.rightTreeNode, secondTreeRoot);
            }
        }
        return hasSunTree;
    }


    private static boolean isTreeFirstContainTreeSecond(TreeNode firstTreeRoot, TreeNode secondTreeRoot) {
        if (secondTreeRoot == null) {
            return true;
        }
        if (firstTreeRoot == null || firstTreeRoot.value != secondTreeRoot.value) {
            return false;
        }
        return isTreeFirstContainTreeSecond(firstTreeRoot.leftTreeNode, secondTreeRoot.rightTreeNode)
                && isTreeFirstContainTreeSecond(firstTreeRoot.rightTreeNode, secondTreeRoot.rightTreeNode);
    }

    /**
     * 返回二叉树的镜像树
     *
     * @param treeNode
     * @return
     */
    public static void mirrorForTreeNode(TreeNode treeNode) {
        // 结点为空或者结点为叶子结点则不用处理
        if (treeNode == null || (treeNode.leftTreeNode == null && treeNode.rightTreeNode == null)) {
            return;
        }
        TreeNode tempTreeNode = treeNode.rightTreeNode;
        treeNode.rightTreeNode = treeNode.leftTreeNode;
        treeNode.leftTreeNode = tempTreeNode;
        if (treeNode.leftTreeNode != null) {
            mirrorForTreeNode(treeNode.leftTreeNode);
        }
        if (treeNode.rightTreeNode != null) {
            mirrorForTreeNode(treeNode.rightTreeNode);
        }
    }

    /**
     * 从外向里打印矩形
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return list;
        }
        int start = 0;
        while (matrix[0].length > start * 2 && matrix.length > start * 2) {
            printOneCircle(matrix, start, list);
            start++;
        }
        return list;
    }


    private void printOneCircle(int[][] matrix, int start, ArrayList<Integer> list) {
        // 终止列
        int endX = matrix[0].length - 1 - start;
        // 终止行
        int endY = matrix.length - 1 - start;
        // 从左往右
        for (int i = start; i <= endX; i++) {
            list.add(matrix[start][i]);
        }
        // 从上往下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(matrix[i][endX]);
            }
        }
        // 从右往左（判断是否会重复打印）
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(matrix[endY][i]);
            }
        }
        // 从下往上（判断是否会重复打印）
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                list.add(matrix[i][start]);
            }
        }
    }

    /**
     * 给定一个栈的压入序列和一个栈的弹出序列，判断该弹出序列是否属于该栈
     *
     * @param pushArray 压入序列
     * @param popArray  弹出序列
     * @return
     */
    public static boolean isPopArray(int[] pushArray, int[] popArray) {
        if (pushArray == null || popArray == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        // 弹出元素序列索引
        int index = 0;
        // 根据压入序列进行入栈操作，当栈顶元素等于弹出序列元素，则弹出栈顶元素
        for (int i = 0; i < pushArray.length; i++) {
            stack.push(pushArray[i]);
            while (!stack.isEmpty() && stack.peek() == popArray[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 按照层级关系打印二叉树
     * 每层按照从左到右的顺序
     *
     * @param treeNode
     */
    public static void printBinaryTreeWithHierarchical(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue<Integer> printQueue = new ArrayDeque<>();

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(treeNode);
        while (!linkedList.isEmpty()) {
            TreeNode binaryTree = linkedList.poll();
            printQueue.add(binaryTree.value);
            if (binaryTree.leftTreeNode != null) {
                linkedList.add(binaryTree.leftTreeNode);
            }
            if (binaryTree.rightTreeNode != null) {
                linkedList.add(binaryTree.rightTreeNode);
            }
        }
        while (!printQueue.isEmpty()) {
            System.out.println(printQueue.poll());
        }
    }

    /**
     * 根据输入的数组 判断数组是否是二叉搜索树的后续遍历序列的结果
     *
     * @param binaryTreeArray
     * @return
     */
    public boolean judgeBinaryTreeErgodic(int[] binaryTreeArray) {
        if (binaryTreeArray == null || binaryTreeArray.length < 0) {
            return false;
        }
        // 二叉搜索树中最后一个节点就是根节点
        int rootValue = binaryTreeArray[binaryTreeArray.length - 1];
        // 二叉搜索树中右子树的节点值大于根节点的值
        int i;
        for (i = 0; i < binaryTreeArray.length - 1; i++) {
            if (binaryTreeArray[i] > rootValue) {
                break;
            }
        }
        // 判断是否符合二叉搜索树
        int j = i;
        for (; j < binaryTreeArray.length - 1; j++) {
            if (binaryTreeArray[j] < rootValue) {
                return false;
            }
        }
        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > 0) {
            left = judgeBinaryTreeErgodic(Arrays.copyOfRange(binaryTreeArray, 0, i));
        }
        // 判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < binaryTreeArray.length - 1) {
            right = judgeBinaryTreeErgodic(Arrays.copyOfRange(binaryTreeArray, i, binaryTreeArray.length - 1));
        }
        return (left && right);
    }


    public static void findBinaryTreeSumPath(TreeNode root, int expectedSum) {
        List<Integer> pathList = new ArrayList<>();
        int currentSum = 0;
        findTreePath(root, pathList, expectedSum, currentSum);
    }

    private static void findTreePath(TreeNode root, List<Integer> pathList, int expectedSum, int currentSum) {
        currentSum += root.value;
        pathList.add(root.value);
        // 判断是否叶子结点
        boolean isLeafNode = root.leftTreeNode == null && root.rightTreeNode == null;
        // 路径和相等
        if (isLeafNode && expectedSum == currentSum) {
            for (Integer nodeValue : pathList) {
                System.out.print(nodeValue + " ");
            }
            System.out.println();
        }
        if (root.leftTreeNode != null) {
            findTreePath(root.leftTreeNode, pathList, expectedSum, currentSum);
        }
        if (root.rightTreeNode != null) {
            findTreePath(root.rightTreeNode, pathList, expectedSum, currentSum);
        }
        // 返回父节点之前 删除不符合要求的节点值
        currentSum -= root.value;
        pathList.remove((Integer) root.value);
    }

    /**
     * 转换二叉搜索树为排序的双向链表
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode convert(TreeNode pRootOfTree) {
        // 定义尾结点
        TreeNode lastlist = covertNode(pRootOfTree, null);
        // 遍历获取头结点
        TreeNode pHead = lastlist;
        while (pHead != null && pHead.leftTreeNode != null) {
            pHead = pHead.leftTreeNode;
        }
        return pHead;
    }

    /**
     * 递归左右子树 排序双向链表
     *
     * @param root
     * @param lastList
     * @return
     */
    private TreeNode covertNode(TreeNode root, TreeNode lastList) {
        if (root == null) {
            return null;
        }
        TreeNode currentTreeNode = root;
        if (currentTreeNode.leftTreeNode != null) {
            lastList = covertNode(currentTreeNode.leftTreeNode, lastList);
        }
        currentTreeNode.leftTreeNode = lastList;
        if (lastList != null) {
            lastList.rightTreeNode = currentTreeNode;
        }
        lastList = currentTreeNode;
        if (currentTreeNode.rightTreeNode != null) {
            lastList = covertNode(currentTreeNode.rightTreeNode, lastList);
        }
        return lastList;
    }

    /**
     * 求字符串的所有排列
     *
     * @param str
     * @return
     */
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> temp = new TreeSet<>();
        permutation(chars, 0, temp);
        result.addAll(temp);
        return result;
    }

    private static void permutation(char[] chars, int index, TreeSet<String> result) {
        if (chars == null || chars.length == 0) {
            return;
        }
        if (index < 0 || index > chars.length - 1) {
            return;
        }
        if (index == chars.length - 1) {
            result.add(String.valueOf(chars));
        } else {
            for (int i = index; i <= chars.length - 1; i++) {
                swap(chars, index, i);
                permutation(chars, index + 1, result);
                // 回退
                swap(chars, index, i);
            }
        }
    }

    private static void swap(char[] c, int index, int recursionIndex) {
        char temp = c[index];
        c[index] = c[recursionIndex];
        c[recursionIndex] = temp;
    }


    public static int findAppearMaxTimesNumInArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int times = 1;
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (times == 0) {
                result = numbers[i];
                times = 1;
            } else if (numbers[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        // 判断数字是否满足出现次数大于数组长度的一半
        int appearTimes = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (result == numbers[i]) {
                appearTimes++;
            }
        }
        if (appearTimes * 2 < numbers.length) {
            return 0;
        }
        return result;
    }

    /**
     * 找出数组中前K个最小的数
     *
     * @param inputArray
     * @param k
     * @return
     */
    public static ArrayList<Integer> findLeastNumbersInArray(int[] inputArray, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (inputArray == null || k <= 0 || k > inputArray.length) {
            return list;
        }
        int[] kArray = Arrays.copyOfRange(inputArray, 0, k);
        // 创建最大堆
        buildMaxHeap(kArray);
        for (int i = k; i < inputArray.length; i++) {
            if (inputArray[i] < kArray[0]) {
                kArray[0] = inputArray[i];
                maxHeap(kArray, 0);
            }
        }

        for (int i = kArray.length - 1; i >= 0; i--) {
            list.add(kArray[i]);
        }
        return list;
    }

    private static void buildMaxHeap(int[] input) {
        for (int i = input.length / 2 - 1; i >= 0; i--) {
            maxHeap(input, i);
        }
    }

    private static void maxHeap(int[] array, int i) {
        int left = 2 * i + 1;
        int right = left + 1;
        int largest;

        if (left < array.length && array[left] > array[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < array.length && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeap(array, largest);
        }
    }

    /**
     * 找出整型数组中连续子数组最大的和
     *
     * @param array
     * @return
     */
    public static int findContinuousSubArrayMaxSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int maxSum = 0;
        int currentSum = 0;
        for (int number : array) {
            if (currentSum <= 0) {
                currentSum = number;
            } else {
                currentSum += number;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

}
