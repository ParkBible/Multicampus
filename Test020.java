public class Test020{
	public static void main(String[] args){
		int max = 0;
		int[] l = {3,5,7,9};
		
		max = l[0];
		
		if(max < l[1]){
			max = l[1];
		}
		if(max < l[2]){
			max = l[2];
		}
		if(max < l[3]){
			max = l[3];
		}
		
		//System.out.println(max);
		
		for(int i=1; i<l.length; i++){
			if(max<l[i]){
				max = l[i];
			}
		}
		System.out.println(max);
	}
}