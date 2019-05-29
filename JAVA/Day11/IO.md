# I/O



InputStream in = new InputStream()X

InputStream in = new FileInputStream();

InputStream in= System.in()



OutputStream out = new OutputStream()X

OutputStream out = new FileOutputStream();

OutputStream out= System.out()

## File

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
package lab.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

