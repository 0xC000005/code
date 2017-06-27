class A{
 	int x = 5 ; 
 }	
class B extends A{
	int x = 3; 
	int y = 2;
}
let A a = new B; do print a.x;

// result: 3
