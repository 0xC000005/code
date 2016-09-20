struct point{
	int x;
	int y;
};

void main(){
	int arr[10];
	int i;
	struct point p;
	p.x = 1024;
	p.y = 768;
	for(i = 0; i < 10; i = i + 1){
		arr[i] = i;
		if( i == 6){
			continue;
		}else{
			printf("arr[%d]=%d\n", i, arr[i]);
		}
	}
	printf("p.x = %d, p.y = %d\n",p.x ,p.y);
}