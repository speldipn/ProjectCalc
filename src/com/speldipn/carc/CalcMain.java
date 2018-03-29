package com.speldipn.carc;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalcMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean runStatus = true;
		while(runStatus) {
			// 1. 키보드에서 입력을 받는다. 35  * 6 - 2
			System.out.print("식을 입력하세요: ");
			String str = scanner.nextLine();
			
			if(str.equals("exit")) {
				runStatus = false;
			} else {
				// 문자열을 계산해주는(식으로 만들어주는) 라이브러리를 사용
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine engine = manager.getEngineByName("javascript"); // javascript eval() > "문자열을 코드처럼 처리해준다
				// ex) "String a = '567'
				
				try {
					// 2.  입력받은 문자열을 계산한다.
					Object object = engine.eval(str);
					// 3. 결과값을 출력한다.
					System.out.println(object);
				} catch(ScriptException e) {
//					e.printStackTrace();
					System.out.println("입력한 식이 잘못되었습니다.");
				}
			}
		} // while
		
		System.out.println("계산기를 종료하였습니다.");
	}

}
