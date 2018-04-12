package DSA.Design.SnakeGame;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)

设计贪吃蛇
数据结构：
走路只有Deque可以满足
不能碰到自己 用HashSet来存

变量：
int score
吃饭food的index：foodIndex

move算法：
case 1： 撞墙，吃自己
case 2： 吃东西
case 3：不吃东西，正常走路

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

 */
public class SnakeGame {
    HashSet<Integer> set; // 位置
    Deque<Integer> deque;
    int score;
    int foodIndex;
    int width;
    int height;
    int[][] food;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        deque = new LinkedList<>();
        score = 0;
        foodIndex = 0;
        set.add(0);
        deque.offerLast(0);
    }

    public int move(String direction) {
        if (score == -1) {
            return -1;
        }

        // 坐标转化
        int rowHead = deque.peekFirst() / width;
        int colHead = deque.peekFirst() % width;

        switch (direction) {
            case "U" : rowHead--;
                break;
            case "D" : rowHead++;
                break;
            case "L" : colHead--;
                break;
            default : colHead++;
        }
        // find the new head
        int head = rowHead * width + colHead;
        // delete the tail
        set.remove(deque.peekLast());
        // case 1
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }
        // add to data structor
        set.add(head);
        deque.offerFirst(head);
        // if eat
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            foodIndex++;
            ++score;
            set.add(deque.peekLast());
            return score;
        }
        deque.pollLast();
        return score;
    }
}
