package DSA.DFS.RobotRoomCleaner;

/*
 *
Given a robot cleaner in a room modeled as a grid.

Each cell in the grid can be empty or blocked.

The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.

When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.

Design an algorithm to clean the entire room using only the 4 given APIs shown below.

interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}
Example:

Input:
room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3

Explanation:
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.
Notes:

The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
The robot's initial position will always be in an accessible cell.
The initial direction of the robot will be facing up.
All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
Assume all four edges of the grid are all surrounded by wall.

LC489 升级版
 */

public class iRobot {
    Robot robot;
    int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 },
            { 1, 0 } };
    int direction;

    /* 不必保留 当前 posX， posY的位置，位置信息只在检查下一点是否可行时有用，DFS 中带入即可 */
    public void sweep(int[][] map, int[] start) {
        this.robot = new Robot();
        boolean[][] visited = new boolean[map.length
                + 1][map[0].length + 1];
        dfs(start[0], start[1], visited);
    }

    public void changeDirectionTo(int direction) {
        /* clockwise turn -- > direction increases */
        if (direction == this.direction)
            return; // 不用改
        int delta = direction - this.direction > 0
                ? direction - this.direction
                : direction - this.direction + 4;
        for (int i = 0; i < delta; i++) {
            robot.turnRight();
        }
        this.direction = direction;
    }

    public void moveBack() {
        changeDirectionTo(this.direction + 2);
        robot.move();
        changeDirectionTo(this.direction + 2);
    }

    public void dfs(int x, int y, boolean[][] visited) {
        robot.clean(); // 成功进入 x,y 扫地
        /* 首先保存原有方向，便于退出时恢复 */
        int prevDirection = this.direction;
        /*
         * 有四个方向可选，当前方向继续 + 向右转 1， 2， 3 次 其中向右转2次相当于回退，由于 visited 必然标记为访问过，则必定不成功
         */
        /* 下一步未访问过，且下一步访问成功 */
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];
            changeDirectionTo(this.direction + 1); // 转向
            if (!visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                /* 不可移动的就跳下一轮循环 */
                if (robot.move()) {
                    /* 可以挪到下一个，在下一个继续 DFS, 注意此时进入下一层 DFS 的是新的 direction */
                    dfs(nextX, nextY, visited);
                }
            }
        }
        changeDirectionTo(prevDirection); // 重要，恢复成原来进入该格子时候的 方向，再做 moveback
        moveBack(); // moveback里 两次转向保证了退回上一格仍然是进入该格子的方向
    }
}

class Robot {
    boolean move() {
        /*
         * Default method by moving one step on the current direction will return true
         * if move successfully
         */
        return true;
    }

    void turnLeft() {
        /* change direction to +90 */
    }

    void turnRight() {
        /* change direction to -90 */
    }

    void clean() {
        /* Do clean */
    }
}
