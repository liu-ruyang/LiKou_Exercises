package org.example.other;

public class Solution {
    public static void main(String[] args) {
        // int[][] edges = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        // int[][] edges = {{0, 3, 7}, {2, 4, 1}, {0, 1, 5}, {2, 3, 10}, {1, 3, 6}, {1, 2, 1}};
        // int[][] edges = {{6, 26, 7065}, {18, 26, 6087}, {3, 16, 5717}, {1, 13, 6287}, {11, 31, 6741}, {12, 27, 7147}, {
        //         15, 32, 6031}, {13, 15, 8995}, {5, 16, 3375}, {13, 19, 3206}, {32, 33, 1070}, {2, 17, 2373}, {20, 24, 3900}, {
        //         26, 32, 3932}, {18, 25, 342}, {23, 37, 3950}, {16, 23, 6449}, {13, 23, 7484}, {7, 16, 7222}, {10, 28, 9303}, {
        //         5, 37, 1563}, {11, 29, 888}, {15, 35, 2824}, {22, 40, 8639}, {3, 28, 125}, {19, 30, 727}, {12, 31, 7049}, {25, 38, 4563}, {
        //         18, 31, 6807}, {15, 23, 2176}, {9, 34, 3862}, {17, 19, 6134}, {5, 7, 6795}, {8, 20, 5601}, {21, 42, 9585}, {14, 42, 775}, {
        //         39, 41, 8296}, {19, 20, 7447}, {25, 41, 2118}, {3, 17, 8572}, {0, 6, 5965}, {0, 3, 9581}, {8, 27, 985}, {6, 40, 5724}, {
        //         5, 41, 1921}, {25, 29, 4022}, {1, 25, 2041}, {10, 18, 7156}, {8, 32, 2437}, {23, 31, 313}, {38, 41, 5988}, {5, 38, 2129}, {
        //         19, 38, 2466}, {7, 30, 4723}, {14, 16, 406}, {16, 22, 7740}, {38, 42, 439}, {15, 26, 7915}, {4, 22, 1100}, {3, 27, 9661}, {
        //         26, 31, 7062}, {2, 16, 1505}, {18, 23, 7698}, {6, 39, 8915}, {21, 33, 9875}, {22, 23, 8214}, {12, 41, 1588}, {
        //         11, 33, 2109}, {21, 35, 8826}, {0, 21, 6449}, {5, 12, 9864}, {3, 8, 8928}, {20, 40, 6720}, {1, 26, 3962}, {20, 26, 8575}, {
        //         0, 42, 6224}, {3, 9, 7825}, {37, 40, 5198}, {23, 26, 7174}, {6, 33, 1914}, {33, 41, 1102}, {19, 32, 3452}, {0, 15, 9697}, {
        //         9, 22, 6051}, {2, 40, 1710}, {23, 25, 1576}, {2, 23, 5815}, {0, 1, 1732}, {3, 20, 3210}, {0, 13, 1821}, {4, 38, 9681}, {
        //         2, 10, 1434}, {5, 15, 59}, {12, 24, 8395}, {5, 25, 7076}, {7, 10, 3842}, {28, 40, 1499}, {0, 30, 5036}, {7, 15, 7989}, {
        //         1, 38, 1013}, {13, 21, 9396}, {7, 13, 7030}, {7, 31, 9183}, {11, 26, 4887}, {24, 37, 6424}, {15, 42, 671}, {
        //         24, 34, 9753}, {0, 23, 475}, {10, 11, 4535}, {15, 19, 7838}, {27, 40, 7175}, {22, 38, 3587}, {14, 40, 4402}, {
        //         9, 35, 5270}, {0, 29, 7827}, {9, 23, 7236}, {18, 22, 8750}, {13, 41, 897}, {13, 27, 4406}, {4, 26, 8417}, {1, 12, 2848}, {
        //         24, 42, 7176}, {10, 14, 7464}, {2, 32, 4845}, {14, 15, 9588}, {32, 42, 9666}, {7, 19, 2992}, {8, 11, 5259}, {
        //         8, 16, 8356}, {6, 38, 6518}, {36, 41, 6780}, {5, 14, 9175}, {15, 29, 9780}, {3, 26, 6528}, {4, 24, 7822}, {1, 22, 3616}, {
        //         1, 11, 5020}, {27, 34, 281}, {33, 37, 1035}, {14, 36, 2423}, {3, 33, 8087}, {24, 36, 1898}, {9, 37, 5892}, {4, 19, 4247}, {
        //         30, 39, 5068}, {11, 42, 8868}, {9, 30, 4965}, {28, 30, 2270}, {4, 20, 1751}, {12, 20, 8223}, {26, 42, 2261}, {
        //         15, 34, 7457}, {3, 35, 623}, {23, 42, 7304}, {3, 18, 7695}, {6, 34, 9335}, {13, 25, 5337}, {7, 20, 8880}, {16, 35, 6084}, {
        //         17, 38, 2051}, {12, 39, 240}, {16, 34, 8811}, {14, 39, 3302}, {9, 17, 4402}, {1, 40, 1062}, {28, 29, 7569}, {
        //         10, 30, 4642}, {16, 31, 197}, {32, 34, 4357}, {1, 37, 8224}, {5, 28, 355}, {17, 24, 9269}, {35, 42, 6578}, {
        //         14, 20, 1836}, {2, 21, 1604}, {5, 17, 5280}, {36, 40, 9920}, {3, 24, 9386}, {19, 40, 7330}, {8, 42, 1500}, {
        //         30, 36, 8166}, {34, 35, 8680}, {12, 34, 5632}, {13, 16, 9651}, {21, 36, 716}, {21, 23, 3080}, {0, 40, 2779}, {
        //         14, 29, 911}, {14, 28, 1906}};
        new Solution().findTheCity(4, edges, 4);
        // new Solution().findTheCity(5, edges, 2);
        // new Solution().findTheCity(6, edges, 417);
        // new Solution().findTheCity(43, edges, 700);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        // 将一维的edge，转为二维
        int[][] roads = new int[n][n];
        for (int i = 0; i < roads.length; i++) {
            for (int i1 = 0; i1 < roads[i].length; i1++) {
                roads[i][i1] = Integer.MAX_VALUE / 2;
            }
        }
        for (int[] edge : edges) {
            roads[edge[0]][edge[1]] = edge[2];
            roads[edge[1]][edge[0]] = edge[2];
        }

        // 使用弗洛伊德算法，算出每两个节点之间的最短距离
        // k是中间节点
        for (int k = 0; k < n; k++) {
            // i是起始节点
            for (int i = 0; i < n; i++) {
                // j是目标节点
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        if (roads[i][k] + roads[k][j] < roads[i][j]) {
                            roads[i][j] = roads[i][k] + roads[k][j];
                        }
                    }
                }
            }
        }

        // for (int i = 0; i < roads.length; i++) {
        //     for (int j = 0; j < roads[i].length; j++) {
        //         System.out.print("\t" + roads[i][j]);
        //     }
        //     System.out.println();
        // }

        int result = 0;
        int resultCount = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < roads.length; i++) {
            count = 0;
            for (int j = 0; j < roads[i].length; j++) {
                if (i != j && roads[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= resultCount) {
                result = i;
                System.out.println(i + " - " + count);
                resultCount = count;
            }
        }

        return result;
    }
}