package algorithm;

import java.util.Scanner;

public class Main14629 {
	static long input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String inputNum  = scan.nextLine();
		input = Long.parseLong(inputNum);
		int min=0,max=9;
		if(input>9876543210L) {
			System.out.println("9876543210");
		}else {
			long first = up(input);
			long second = down(input);
			long res = (first-input>input-second) ? second : first;
			System.out.println(res);
		}
	}
	public static long up(long first) {
		boolean firstB=false;
		while(true) {
			boolean[] arr = new boolean[10];
			int count=0;
			for(int i=0;i<Long.toString(first).length();i++) {
				if(arr[Character.getNumericValue(Long.toString(first).charAt(i))]) {
					first = (long) (first + (Math.pow(10, Long.toString(first).length()-(i+1))));
					first=first-Long.parseLong(Long.toString(first).substring(i+1, Long.toString(first).length()));
					first= down(first);
				}else {					
					count++;
					arr[Character.getNumericValue(Long.toString(first).charAt(i))]=true;
				}
				if(count==Long.toString(input).length()) {
					firstB=true;
				}
			}
			if(firstB) {
				break;
			}
			first++;
		}
		return first;
	}
	public static long down(long second) {
		boolean secondB=false;
		while(true) {
			boolean[] arr = new boolean[10];
			int count=0;
			for(int i=0;i<Long.toString(second).length();i++) {
				if(arr[Character.getNumericValue(Long.toString(second).charAt(i))]) {
					second = (long) (second - (Math.pow(10, Long.toString(second).length()-(i+1))));
					second=second+Long.parseLong(Long.toString(second).substring(i+1, Long.toString(second).length()));
					second= up(second);
				}else {					
					count++;
					arr[Character.getNumericValue(Long.toString(second).charAt(i))]=true;
				}
				if(count==Long.toString(input).length()) {
					secondB=true;
				}
			}
			if(secondB) {
				break;
			}
			second--;
		}
		return second;
	}
}
//			String result = "";
//			int i=0;
//			while(i!=inputNum.length()) {
//				if(!arr[Character.getNumericValue(inputNum.charAt(i))]) {//¾È¾¸
//					result += inputNum.charAt(i);
//					arr[Character.getNumericValue(inputNum.charAt(i))]=true;
//					if(Character.getNumericValue(inputNum.charAt(i))==max) {
//						while(max>=0) {
//							if(!arr[max]) {
//								break;
//							}
//							max--;
//						}
//					}
//					if(Character.getNumericValue(inputNum.charAt(i))==min) {
//						while(min<10) {
//							if(!arr[min]) {
//								break;
//							}
//							min++;
//						}
//					}
//				}else {//½èÀ½
//					String first=result,second=result;
//					boolean[] firstArr = new boolean[10];
//					boolean[] secondArr = new boolean[10];
//					for(int p=0;p<10;p++) {
//						firstArr[p]=arr[p];
//						secondArr[p]=arr[p];
//					}
//					while(true) {
//						
//					}
////					for(int j=Character.getNumericValue(inputNum.charAt(i));first.length()!=inputNum.length();j++) {
////						if(j==10) {
////							j=0;
////							if(!arr[i+1]) {
////								long temp = Long.parseLong(first);
////								temp++;
////								for(int t=0;t<first.length();t++) {
////									firstArr[Character.getNumericValue(first.charAt(t))]=false;
////								}
////								first = Long.toString(temp);
////								for(int t=0;t<first.length();t++) {
////									firstArr[Character.getNumericValue(first.charAt(t))]=true;
////								}
////							}
////						}
////						if(!firstArr[j]) {
////							firstArr[j]=true;
////							first += Integer.toString(j);
////							for(int k=min;first.length()!=inputNum.length();k++) {
////								if(!firstArr[k]) {
////									first += k;
////								}
////							}
////							
////						}else {
////							continue;
////						}
////					}
//					for(int j=Character.getNumericValue(inputNum.charAt(i));second.length()!=inputNum.length();j--) {
//						if(j==-1) {
//							j=9;
//							if(!arr[i-1]) {
//								long temp = Long.parseLong(second);
//								temp--;
//								for(int t=0;t<first.length();t++) {
//									secondArr[Character.getNumericValue(first.charAt(t))]=false;
//								}
//								second = Long.toString(temp);
//								for(int t=0;t<first.length();t++) {
//									secondArr[Character.getNumericValue(second.charAt(t))]=true;
//								}
//							}
//						}
//						if(!secondArr[j]) {
//							secondArr[j]=true;
//						
//							second += Integer.toString(j);
//							
//							for(int k=max;second.length()!=inputNum.length();k--) {
//								if(!secondArr[k]) {
//									second += k;
//								}
//							}
//						}else {
//							continue;
//						}
//					}
//					long res = (Long.parseLong(first)-input>input-Long.parseLong(second)) ? Long.parseLong(second) : Long.parseLong(first);
//					
//					result = Long.toString(res);
//					break;
//				}
//				i++;
//			}
//			System.out.println(result);
//		}
//	}
//
//}
