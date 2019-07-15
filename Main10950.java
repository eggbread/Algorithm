package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main10950 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(scan.readLine());
		for(int i=0;i<n;i++) {
			String[] temp = scan.readLine().split(" ");
			if(temp.length==1) {
				String[] temp2 = scan.readLine().split(" ");
				buf.write(Integer.toString(Integer.parseInt(temp[0])+Integer.parseInt(temp2[0]))+"\n");
			}else {
				buf.write(Integer.toString(Integer.parseInt(temp[0])+Integer.parseInt(temp[1]))+"\n");
			}
		}
		buf.flush();
		buf.close();
	}

}
