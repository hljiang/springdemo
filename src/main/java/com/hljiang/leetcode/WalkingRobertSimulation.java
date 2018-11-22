package com.hljiang.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/***
 *  模拟行走机器人
 *  greedy algorithm
 *  贪心算法
 * #874
 * Example 1:
 *
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 * Example 2:
 *
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 */
public class WalkingRobertSimulation {
    /**
     * @param commands
     * @param obstacles
     * @return -2: turn left 90 degrees
     * -1: turn right 90 degrees
     * 1 <= x <= 9: move forward x units
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands.length < 0 || obstacles.length < 0 || commands.length > 10000 || obstacles.length > 10000) {
            return 0;
        }
        Axis currentAxis = new Axis(0, 0);
        Orientation direction = Orientation.UP_Y;

        Set<Axis> obstacleSet = this.convertObstacles(obstacles);
        int ans = 0;
        for (int cmd : commands) {
            if (cmd == -2) {
                //逆时针方向旋转
                int ori = (direction.getCode() - 1) < 0 ? 3 : (direction.getCode() - 1);
                direction = Orientation.getOrientation(ori);
            }
            if (cmd == -1) {
                //顺时针旋转
                int ori = (direction.getCode() + 1) > 3 ? 0 : (direction.getCode() + 1);
                direction = Orientation.getOrientation(ori);
            }
            if (cmd >= 1 && cmd <= 9) {
                currentAxis = this.checkForObstacles(currentAxis, cmd, direction, obstacleSet);
            }
            int distance = currentAxis.getX() * currentAxis.getX() + currentAxis.getY() * currentAxis.getY();
            ans = Math.max(ans, distance);
        }
        return ans;

    }

    private Set<Axis> convertObstacles(int[][] obstacle) {
        Set<Axis> obstacleSet = new HashSet<>();
        for (int i = 0; i < obstacle.length; i++) {
            Axis axis = new Axis(obstacle[i][0], obstacle[i][1]);
            obstacleSet.add(axis);
        }
        return obstacleSet;
    }

    private Axis checkForObstacles(Axis currentAxis, int step, Orientation direction, Set<Axis> obstacleSet) {
        for (int i = 0; i < step; i++) {
            Axis lastAxis = new Axis(currentAxis.getX(), currentAxis.getY());
            switch (direction) {
                case UP_X:
                    currentAxis = new Axis(currentAxis.getX() + 1, currentAxis.getY());
                    break;
                case DOWN_X:
                    currentAxis = new Axis(currentAxis.getX() - 1, currentAxis.getY());
                    break;
                case UP_Y:
                    currentAxis = new Axis(currentAxis.getX(), currentAxis.getY() + 1);
                    break;
                case DOWN_Y:
                    currentAxis = new Axis(currentAxis.getX(), currentAxis.getY() - 1);
                    break;
            }
            if (obstacleSet.contains(currentAxis)) {
//                System.out.println("next position:" + lastAxis + ";  obstacle:" +
//                        currentAxis + ";  direction:" + direction.name());
                //System.out.println("---------------------------------------------------");
                return lastAxis;
            }
        }
        //System.out.println("next position:" + currentAxis + ";  direction:" + direction.name());
        //System.out.println("----------------------------------------------------");
        return currentAxis;
    }

    public class Axis {
        private int x;
        private int y;

        public Axis(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String toString() {
            return "Axis[x: " + getX() + "; y: " + getY() + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Axis axis = (Axis) o;
            return x == axis.x &&
                    y == axis.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public enum Orientation {
        UP_Y(0, "向上+y"),
        UP_X(1, "向上+x"),
        DOWN_Y(2, "向下-y"),
        DOWN_X(3, "向下-x");
        private int code;
        private String desc;

        Orientation(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public static Orientation getOrientation(int ordinal) {
            return values()[ordinal];
        }
    }

    public static void main(String[] args) {
        WalkingRobertSimulation simulation = new WalkingRobertSimulation();
        int[][] obstacles = new int[][]{{-3, 2}, {-2, 1}, {0, 1}, {-2, 4}, {-1, 0}, {-2, -3}, {0, -3}, {4, 4}, {-3, 3}, {2, 2}};
        int[] commands = new int[]{7, -2, -2, 7, 5};
        int result = simulation.robotSim(commands, obstacles);
        System.out.println(result);
    }
}
