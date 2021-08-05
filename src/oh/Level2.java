package oh;

public class Level2 {
	public static void main(String[] args) {
	int a = 12,b = 10;
	if( a>b) {
		System.out.println(">"); }
		else if (a<b) {
			System.out.println("<");
		}else {
			System.out.println("==");
		};
		System.out.println(a>b ? "a가크다" : "b가 크다.");
		System.out.println("============");
		
		for(int i=0;i<10; i++) {
			if(i<10 ) System.out.print("변한 값"+ i); 
			System.out.print("이후 값" + i);
			System.out.println();
				
				}
			
		}

		
	};




