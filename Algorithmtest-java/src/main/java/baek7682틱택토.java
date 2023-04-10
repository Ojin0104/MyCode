import java.io.*;

public class baek7682틱택토 {

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String str=bufferedReader.readLine();
            if(str.equals("end"))break;

            char[] chs=str.toCharArray();

            if(check(chs))
                bw.write("valid\n");
            else
                bw.write("invalid\n");
        }
        bw.flush();
    }
    static boolean check(char[] chs) {
        int Ocount = 0;
        int Xcount = 0;
        boolean Obingo=false;
        boolean Xbingo=false;
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = chs[i * 3 + j];
            }
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == 'O') Ocount++;
                else if (board[i][j] == 'X') Xcount++;
                else continue;
                if (i == 0) {
                    if (board[1][j] == board[0][j] && board[2][j] == board[0][j]) {
                        if (board[1][j] == 'O') Obingo = true;
                        else
                            Xbingo = true;

                    }
                }
                if (j == 0) {
                    if (board[i][j] == board[i][1] && board[i][2] == board[i][0]) {
                        if (board[i][0] == 'O') Obingo = true;
                        else
                            Xbingo = true;
                    }
                }

                if (i == 0 && j == 0) {
                    if (board[i][0] == board[1][1] && board[2][2] == board[i][0]) {
                        if (board[i][0] == 'O') Obingo = true;
                        else
                            Xbingo = true;
                    }
                }
                if (i == 2 && j == 0) {
                    if (board[i][0] == board[1][1] && board[0][2] == board[i][0]) {
                        if (board[i][0] == 'O') Obingo = true;
                        else
                            Xbingo = true;
                    }
                }
            }

        }
        if(Obingo&&Xbingo)return false;
        if(!Obingo&&!Xbingo&&Ocount+Xcount<9)return false;
        if(Ocount>Xcount||Xcount-Ocount>=2)return false;
        if(Xbingo&&!Obingo&&Ocount==Xcount)return false;
        if(Obingo&&!Xbingo&&Ocount!=Xcount)return false;
        return true;
    }
}
