class A{
}	
class B extends A{
}	
let	int foo(A o1, A o2) 1;				
     	int foo(A o1, B o2) 2;				
     	int foo(B o1, A o2) 3;				
     	int foo(B o1, B o2) 4;				
		bool flag = false;				
 
A obj = (if flag then {new A()} else {new B()}); 
do print obj.foo(obj) + 6;					
