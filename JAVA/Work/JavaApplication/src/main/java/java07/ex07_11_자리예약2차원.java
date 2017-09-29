package java07;

public class ex07_11_자리예약2차원 {
    
    public static void main(String[] args) {
        int[] seat1 = new int[20];
        int[][] seat2 = new int[4][6];
        
        seat1[0] = (int)(20*Math.random() + 1);
        
        for (int i = 1;i < 20;i++) {
            int n = 0;
            for (;;) {
                int f = 0;
                n = (int)(20*Math.random() + 1);
                for (int j = 0;j < i;j++) {
                    if (n == seat1[j]) {
                        f = 1;
                    }
                }
                if (f != 1)
                    break;
            }
            seat1[i] = n;
        }
        int k = 0;
        for (int i = 0;i < 4;i++) {
            for (int j = 0;j < 6;j++) {
                if ((i == 2 && j == 0) || (i == 3) &&(j <= 2)) {
                    seat2[i][j] = -1;
                    continue;
                }
                else {
                    seat2[i][j] = seat1[k];
                    k++;
                }
            }
        }
        
        System.out.format("                        |-------------------|                     \n" );
        System.out.format("                        |      스크린       |                     \n" );
        System.out.format("                        |-------------------|                     \n" );
        System.out.format("                                                                  \n" );
        System.out.format("|---------|---------|---------|    |---------|---------|---------|\n" );
        System.out.format("|    %3d  |   %3d   |   %3d   |    |   %3d   |   %3d   |   %3d   |\n", seat2[0][0], seat2[0][1], seat2[0][2], seat2[0][3], seat2[0][4], seat2[0][5]);
        System.out.format("|---------|---------|---------|    |---------|---------|---------|\n" );
        System.out.format("|    %3d  |   %3d   |   %3d   |    |   %3d   |   %3d   |   %3d   |\n", seat2[1][0], seat2[1][1], seat2[1][2], seat2[1][3], seat2[1][4], seat2[1][5]);
        System.out.format("|---------|---------|---------|    |---------|---------|---------|\n" );
        System.out.format("          |   %3d   |   %3d   |    |   %3d   |   %3d   |   %3d   |\n", seat2[2][1], seat2[2][2], seat2[2][3], seat2[2][4], seat2[2][5]);
        System.out.format("          |---------|---------|    |---------|---------|---------|\n" );
        System.out.format("                                   |   %3d   |   %3d   |   %3d   |\n", seat2[3][3], seat2[3][4], seat2[3][5] );
        System.out.format("                                   |---------|---------|---------|\n" );    }
}
