grammar Tiny;

prog   	: (block )+ ;

block	: body		#codeBody
       		| varasm	#globalVar
       		| defcls		#classDef
       		;

body   	: exp			#singleExp
       		| let exp	#letInExp
       		;

defcls 	: CLASS ID supers? CLPAR slots CRPAR;

supers : EXTENDS ID ;

slots  	: (slotd SEMIC)* ;

slotd  	: vardec		#slotNoInit
       		| varasm		#slotInit
       		;

let    	: LET (dec SEMIC)+ DO ;

dec    	: varasm         	#varAssignment
       		| fun            		#funDeclaration
       		;

fun    	: type ID LPAR ( vardec ( COMMA vardec)* )? RPAR body ;

varasm 	: vardec ASSIGN exp ;
vardec 	: type ID ;

type   	: INT
       		| BOOL
       		| ID
      		;

exp    	: left=term (PLUS right=exp)? ;
term   	: left=factor (TIMES right=term)? ;
factor 	: left=value (EQ right=value)? ;

value  	: INTEGER					#intVal
       		| ( TRUE | FALSE )				#boolVal
       		| LPAR exp RPAR					#baseExp
       		| IF cond=exp THEN CLPAR thenBranch=exp CRPAR ELSE CLPAR elseBranch=exp CRPAR #ifExp
       		| ID						#varExp
       		| ID LPAR (exp (COMMA exp)* )? RPAR		#funExp
       		| PRINT exp					#printExp
       		| 'new' ID (LPAR (exp (COMMA exp)*)? RPAR)?	#classExp
       		| value '.' ID LPAR (exp (COMMA exp)*)? RPAR	#methodExp
       		| value '.' ID					#slotExp
       		;

SEMIC  		: ';' ;
COLON 	 	: ':' ;
COMMA  	: ',' ;
EQ     			: '==' ;
ASSIGN 		: '=' ;
PLUS   			: '+' ;
TIMES  		: '*' ;
TRUE   			: 'true' ;
FALSE  		: 'false' ;
LPAR   			: '(' ;
RPAR   		: ')' ;
CLPAR 		: '{' ;
CRPAR  		: '}' ;
IF     				: 'if' ;
THEN   		: 'then' ;
ELSE   			: 'else' ;
PRINT  		: 'print' ; 
LET    			: 'let' ;
DO     			: 'do' ;
VAR    			: 'var' ;
FUN   			: 'fun' ;
INT    			: 'int' ;
BOOL   		: 'bool' ;

CLASS  		: 'class' ;
EXTENDS  	: 'extends' ;

fragment DIGIT 			: '0'..'9';    
INTEGER        				: ('-')?DIGIT+;

fragment CHAR  		: 'a'..'z' | 'A'..'Z' ;
ID            					 	: CHAR (CHAR | DIGIT)* ;

WS             					: [ \t\r\n]+ -> skip;
LINECOMENTS    		: '//' .*? [\r\n]+ -> skip;
BLOCKCOMENTS   		: '/*' .*? '*/' -> skip;

ERR           			 		: . -> channel(HIDDEN); 