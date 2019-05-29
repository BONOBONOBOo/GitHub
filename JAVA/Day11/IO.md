# File I/0

```java
//diretory와 file size 출력

package lab.java;

import java.io.File;

public class FileEx {

	public static void main(String[] args) {
		String filepath = "C:\\";
		File f1 = new File(filepath);
		
		String list[] = f1.list();
		
		for(int i = 0 ; i<list.length;i++) {
			
			File f2 = new File(filepath,list[i]);
			if(f2.isDirectory()) {
				System.out.printf("%s : 디렉토리 \n",list[i]);
			}
			else
				System.out.printf("%s :파일(%,d byte)\n",list[i],f2.length());
		}
	}
}
```

```java
//입력 스트림을 이용한 출력
public static void main(String[] args) throws IOException {
		
		System.out.println("입력하세요.");
		int _byte;
		while((_byte=((System.in).read()))!=-1) {
			if(_byte=='q'||_byte=='Q')break;
			if(_byte=='\n')continue;
			
			System.out.println(_byte);
		}
		
	}
```

```java
//파일의 100byte만큼 내용 읽기

public class FileEx {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = null;
		byte _read[] = new byte[100];
		byte console[] = new byte[100];
		
		try {
			System.out.println("파일명");
			System.in.read(console);//파일 경로 입력
			String file = new String(console).trim();
			fis = new FileInputStream(file);
			fis.read(_read,0,_read.length);
			
			System.out.println(new String(_read).trim());
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fis != null) fis.close();
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}	
	}
}
```

```java
//디렉토리 찾아서 없으면 만들고 파일 없으면 파일 만들고 쓰기 
public class FileEx {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = null;
		try {
			File f = new File("C:/test");
			if(!f.exists()) {
				f.mkdir();
			}
			fos = new FileOutputStream("C:/test/fileout.txt");
			String message = "Hello FileOutputStream";
			fos.write(message.getBytes());
			System.out.println("file 쓰기 완료");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fos != null) {
					fos.close();
				}
			}
			catch(IOException io) {
				io.printStackTrace();
			}}}}

```

```java
//파일 복사하기
public static void main(String[] args) throws IOException {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		byte _read[] = new byte[100];
		byte console[] = new byte[100];
		
		try {
			
			System.out.println("파일명");
			System.in.read(console);//파일 경로 입력
			String file = new String(console).trim();
			
			
			StringTokenizer st = new StringTokenizer(file, "\\");
			String filename ="";
			while(st.hasMoreElements()) {
				filename = st.nextToken();
			}
			
			System.out.println(file);
			file = file.replace(filename, filename+"2.txt");
			fos = new FileOutputStream(file);
			fis = new FileInputStream(file);
			fos.write(fis.read(_read,0,_read.length));

			System.out.println(new String(_read).trim());
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fis != null) fis.close();
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}}
```

```java
//파일에 변수값 저장하기
public static void main(String[] args) throws IOException {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("c:/test/dataOut.txt");
			dos = new DataOutputStream(fos);
			dos.writeBoolean(true);
			dos.writeInt(20000);
			
			System.out.println("저장!");
			
			fis = new FileInputStream("c:/test/dataOut.txt");
			dis = new DataInputStream(fis);
			
			System.out.println(dis.readBoolean());
			System.out.println(dis.readInt());
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fis != null) {
					fis.close();
					fos.close();
					dis.close();
					dos.close();
				}
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}}
```

