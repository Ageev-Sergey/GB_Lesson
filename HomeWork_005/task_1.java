package HomeWork_005;

import java.util.LinkedList;
import java.util.Queue;

public class task_1 {
    public static void main(String[] args) {
        var map = getMap();
        // System.out.println(rawData(getMap()));
        int[] startPos = new int []{5, 3};
        System.out.println(mapColor(getMap()));

        WaveAlgorithm(map, startPos);
        System.out.println(rawData(map));

    }

    static int[][] getMap() {
        return new int[][] {
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1, 00, -1, -1, -1, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
                { -1, -1, -1, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, -1, -1, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
        };
    }

    static String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%3d", map[row][col]));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    static String mapColor(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                switch (map[row][col]) {
                    case 0:
                        sb.append(".");
                        break;
                    case -1:
                        sb.append("#");
                        break;
                    case -2:
                        sb.append("-2");
                        break;
                    case -3:
                        sb.append("-3");
                        break;
                    default:
                        break;
                }
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void WaveAlgorithm(int[][] map, int[] startPos) {

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(startPos);
        map[startPos[0]][startPos[1]] = 1;

        while (queue.size() != 0) {
          int[] current_Position = queue.remove();
          int posX = current_Position[0];
          int posY = current_Position[1];

          if (map[posX - 1][posY] == 0) {
            int[] temp = new int[] { posX - 1, posY };
            queue.add(temp);
            map[posX - 1][posY] = map[posX][posY] + 1;
          }
          if (map[posX][posY - 1] == 0) {
            int[] temp = new int[] { posX, posY - 1 };
            queue.add(temp);
            map[posX][posY - 1] = map[posX][posY] + 1;
          }
          if (map[posX + 1][posY] == 0) {
            int[] temp = new int[] { posX + 1, posY };
            queue.add(temp);
            map[posX + 1][posY] = map[posX][posY] + 1;
          }
          if (map[posX][posY + 1] == 0) {
            int[] temp = new int[] { posX, posY + 1 };
            queue.add(temp);
            map[posX][posY + 1] = map[posX][posY] + 1;
          }
        }
      }
}
