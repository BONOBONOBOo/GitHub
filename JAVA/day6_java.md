객체지향 특성
1. 상속 - 코드의 재사용을 높이는 것
2. 캡슐화 - 구현예) private 속성 선언, public ~get/set 인터페이스 메소드
3. 다형성 - 다양한 형태를 가질 수 있다 예) overload, override, 다형성 객체(부모타입으로 선언하고 자식타입으로 생성)

객체지향 장점
1. 코드의 재사용성이 높다
2. 코드의 관리가 용이하다
3. 신뢰성이 높은 프로그램 구현이 가능

클래스를 단위로 소스코드 생성
클래스 - 속성(상태, data)과 기능(동작)으로 구성된 객체를 생성하기 위한 설계도
객체 - 현실세계의 모든(유형, 무형) 것, 메모리에 생성되는 클래스의 인스턴스

클래스 구성 요소
1. 클래스 선언
2. 멤버 필드  - 인스턴스변수, 상수, 클래스변수
3. 생성자 메서드 - 객체를 생성할때 객체의 초기화를 수행
4. 멤버 메서드 - 기능 수행, 인스턴스 메서드, 클래스 메서드



1. 클래스 선언
AccessModifer [Modifier] class 이름 [extends 부모클래스] [implements 인터페이스, 인터페이스, ..]{  }
클래스는 단일 상속
인터페이스는 다중 상속 가능
AccessModifer - public, (default)
Modifier - abstract, final


AccessModifer class 이름  { ......}


2. 멤버 필드 
AccessModifer [Modifier] 타입 이름 [= 초기값];
AccessModifer - public > protected > (default) > private
Modifier - final 선언 상수는 반드시 초기값 할당이 필요함
           static 는 동일한 클래스로부터 생성된 객체들간의 공유 변수, 1번만 메모리에 생성됩니다.(Constant영역, Method Area)
인스턴스 변수는 생성되는 객체마다 서로 다른 그 객체의 고유한 값을 가지는 변수


3. 생성자 메서드
AccessModifer 클래스이름([매개변수,...]) {}
클래스의 생성자 메서드는 1개 이상 선언(정의)가능합니다.
※ 생성자 메서드의 매개변수의 개수, 타입, 순서는 하나는 반드시 달라야 합니다. - overload(중복정의)
※ 클래스를 정의할 때 생성자 메소드를 명시적으로 정의하지 않으면 JDK가 컴파일시에 자동으로 default 생성자가 생성됩니다
※ 명시적 생성자를 정의하면 JDK가 컴파일시에 자동으로 default 생성자가 생성하지 않습니다.
생성자 메서드에서 클래스내에 정의된 다른 생성자 메서드 호출이 가능합니다
생성자 메서드를 다른 생성자에서 호출할때 이름으로 호출 불가능하며, this();로 호출합니다.
생성자 메서드를 다른 생성자에서 호출할때 첫번째 라인에서 한번만 호출 가능합니다.

4. 멤버 메서드
AccessModifer [Modifier] 리턴타입 메서드이름([매개변수 리스트]) [throws 예외클래스, ....] { }
AccessModifer - public > protected > (default) > private
Modifier - abstract, final, static, synchronized, native
리턴타입 - void, primitive data type(8개), reference type(class, interface, enum, 배열)

local 변수 - 메서드 내부에서 선언된 변수
[final] 타입 변수 = 초기값;



※메서드내에 선언된 local변수는 메모리에 메서드가 호출될때 생성되고,
※메서드 수행이 종료되면 GC되므로, local변수는 메서드 외부에서 참조 불가합니다.


JVM이 호출된 메서드를 실행시킵니다.
메서드의 파라미터 타입이 primitive data type이면 변수를 전달할때 값을 복사해서 전달합니다. call by value
메서드의 파라미터 타입이 reference data type이면 변수를 전달할때 변수의 주소값을 전달합니다. call by reference


# 가변인자 파라미터는 메서드의 매개변수 순서상 가장 뒤에 오거나 단독으로 사용 가능


====================Account.java=======================


package com.workshop2.account;

public class Account {
private String custId;
private String custName;
private String accountNumber;
int balance; //예금 잔액
public Account() {
	
}
public Account(String custId, String custName, String accountNumber, int balance) {	
	this.custId = custId;
	this.custName = custName;
	this.accountNumber = accountNumber;
	if(balance<1) {
		System.out.println("잔액 오류입니다.: 0 원");
		System.exit(0);
	}
	this.balance = balance;
}
public String getCustId() {
	return custId;
}
public void setCustId(String custId) {
	this.custId = custId;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}

public void addBalance(int amount) {
	if(amount<1) {
		System.out.println("금액 오류입니다.: 0 원");		
	}else if(amount >=1) {
		balance += amount;
	}
	
}
public void subtractBalance(int amount) {
	if(amount<1) {
		System.out.println("금액 오류입니다.: 0 원");		
	}else if(amount >=1) {
		if( balance>=amount) {
			balance -= amount;
	    }else {
	    	System.out.println("출금 불가!! 잔금 부족입니다.");	
	    }
	}
}
public void printAccount() {
	System.out.println("===========================");
	System.out.println("고객번호 : "+custId);
	System.out.println("고객명 : "+custName);
	System.out.println("계좌번호 : "+accountNumber);
	System.out.println("잔액 : "+balance);
	System.out.println("===========================");
}
}

=================TestAccount.java=========================
package com.workshop2.account;

import java.util.Scanner;

public class TestAccount {

	public static void main(String[] args) {
		Account  sj = new Account("CUST01", "소지섭", "1-22-333", 100000);
		int amount = 0;
		int menu =0;	
		sj.printAccount();
		while((menu =getMenuItem())!=9) {
		switch(menu) {
		case 1 : 
			System.out.print("금액 : ");		
		    amount = getAmount();
		    sj.addBalance(amount);
		    System.out.println(amount+"원을 입금했습니다."); 
		    System.out.println("==================");
		    System.out.println("현재 잔액:"+sj.getBalance());
		    System.out.println("==================");
		    break;
		case 2 :
			System.out.print("금액 : ");		
		    amount = getAmount();
		    sj.subtractBalance(amount);
		    System.out.println(amount+"원을 출금했습니다."); 
		    System.out.println("==================");
		    System.out.println("현재 잔액:"+sj.getBalance());
		    System.out.println("==================");
		    break;
		}//switch end
		} //while end
		System.out.println("Bye~~~");
	}//main end
	
	/* 금액을 입력 받습니다. */
	public static int getAmount() {
		//static 메소드에서는 non-static 변수, 객체, 메소드 사용 불가
	    return getUserInput();  
	}
	
	/*메뉴 번호 또는 금액 입력 받습니다.*/
	public static int getUserInput() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	/* 메뉴 출력하고 메뉴 입력 받기 */
	public static int getMenuItem() {
		System.out.println("[ Menu ]");
		System.out.println("1.입금");
		System.out.println("2.출금");
		System.out.println("3.종료");
		System.out.print("==>Menu선택 :");
		return getUserInput();		
	}


}


# 객체마다 고유한 값, 상태를 저장하는 속성인 인스턴스 변수의 값을 변경, 처리하는 기능을 수행하는 메소드가 인스턴스 메서드

#static변수는 non-static메소드(인스턴스 메서드)에서 참조, 사용 가능
#static메서드는 static변수를 처리하기 위한 메서드이므로, non-static 변수는 참조, 사용 불가




[메서드 overload 중복정의]
AccessModifer 리턴타입 메서드이름([매개변수 리스트]) {}
AccessModifer는 동일하지 않아도 됩니다.
리턴타입은 동일하지 않아도 됩니다.
메서드이름은 반드시 동일해야 합니다.
매개변수의 순서, 개수, 타입 중 최소 하나는 달라야 합니다.