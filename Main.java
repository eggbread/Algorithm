package algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
//		File file = new File("C:\\Users\\gyeongmin\\Pictures\\Saved Pictures\\hyewon1.jpg");
//		byte[] byteFile = new byte[(int)file.length()];
//		try {
//			byteFile=Files.readAllBytes(Paths.get("C:\\Users\\gyeongmin\\Pictures\\Saved Pictures\\hyewon1.jpg"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			Files.write(Paths.get("hyewon1.jpg"),byteFile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println((byte) 128&0xff);
		
		int temp = 32896;
		
		byte a = (byte) ((temp>>24)&0xff);
		byte b = (byte)((temp>>16)&0xff);
		byte c = (byte) ((temp>>8)&0xff);
		byte d = (byte)(temp&0xff);
		int result = ((((int)a & 0xff) << 24) |
				((b & 0xff) << 16) |
				(((int)c & 0xff) << 8) |
				(((int)d & 0xff)));
	}

	public enum TokenType {
		ID(3), INT(2);

		private final int finalState;

		TokenType(int finalState) {
			this.finalState = finalState;
		}
	}

	public static class Token {
		public final TokenType type;
		public final String lexme;

		Token(TokenType type, String lexme) {
			this.type = type;
			this.lexme = lexme;
		}

		@Override
		public String toString() {
			return String.format("%s: %s", type.toString(), lexme);
		}
	}

	public static class Scanner {
		private int transM[][];
		private String source;
		private StringTokenizer st;

		public Scanner(String source) {
			this.transM = new int[4][128];
			this.source = source == null ? "" : source;
			this.st = new StringTokenizer(this.source, " ");
			initTM();
		}

		private void initTM() {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 128; j++) {
					if (i == 0) {
						switch (j) {
						case 48:
						case 49:
						case 50:
						case 51:
						case 52:
						case 53:
						case 54:
						case 55:
						case 56:
						case 57:
							this.transM[i][j] = 2;//���ڰ� �Է� �� ��
							break;
						case '-':
							this.transM[i]['-'] = 1;//-�� �Է� �� ��
							break;
						default:
							if(j>64&&j<123&&!(j>90&&j<97)){//���ĺ��� �Է� �� ��
								this.transM[i][j]=3;
							}else {
								this.transM[i][j]=-1;//�������� -1�� �ʱ�ȭ
							}
						}
					} else if (i == 1) {
						switch (j) {
						case 48:
						case 49:
						case 50:
						case 51:
						case 52:
						case 53:
						case 54:
						case 55:
						case 56:
						case 57:
							this.transM[i][j] = 2;//-�Է� �� ���ڰ� ������ 2�� �̵�
							break;
						default:
							this.transM[i][j]=-1;//�� �̿� �Է��� -1
						}
					} else if (i == 2) {
						switch (j) {
						case 48:
						case 49:
						case 50:
						case 51:
						case 52:
						case 53:
						case 54:
						case 55:
						case 56:
						case 57:
							this.transM[i][j] = 2;//���ڰ� ������ �״�� 2�� ����
							break;
						default:
							this.transM[i][j]=-1;//�������� -1
						}
					} else {
						switch (j) {
						case 48:
						case 49:
						case 50:
						case 51:
						case 52:
						case 53:
						case 54:
						case 55:
						case 56:
						case 57:
							this.transM[i][j] = 3;//3�� ���� ���ڰ� ���͵� 3���� ����
							break;
						default:
							if(j>64&&j<123&&!(j>90&&j<97)){
								this.transM[i][j]=3;//���ĺ��̸� 3���� ����
							}else {
								this.transM[i][j]=-1;//�������� -1
							}
						}
					}
				}
			}
		}

		private Token nextToken() {
			int stateOld = 0, stateNew;
			if (!st.hasMoreTokens())// ��ū�� �� �ִ��� �˻�
				return null;
			String temp = st.nextToken();// �� ���� ��ū�� ����
			Token result = null;
			for (int i = 0; i < temp.length(); i++) {
				stateNew=this.transM[stateOld][temp.charAt(i)];//���� ���¸� ����
				if(stateNew==-1) {//�ùٸ� �Է��� �ƴϸ� ����� null����
					System.out.println("�ùٸ��� ���� �Է��Դϴ�.");
					return null;
				}
				stateOld=stateNew;//�ٲ� ���¸� ������Ʈ
			}
			for (TokenType t : TokenType.values()) {
				if (t.finalState == stateOld) {
					result = new Token(t, temp);
					break;
				}
			}
			return result;
		}

		public List<Token> tokenize() {
			List<Token> list = new LinkedList<Token>();//Token�� ������ ����Ʈ ����
			while(true) {//������ ��ȯ	
				list.add(this.nextToken());//����Ʈ�� ����
				if(!st.hasMoreTokens())break;//��ū�� ���̻������ ��ȯ
				
			}
			return list;//����Ʈ ��ȯ
		}
	}
}