package JanuaryChallenge;

public class ArrayFormation {
    private static boolean canFormArray(int[] arr, int[][] pieces){
        int[] index = new int[101];

        for(int i = 0; i < arr.length; i++){
            index[arr[i]] = i+1;
        }
        
        for(int[] ps : pieces){
            if(index[ps[0]] == 0){
                return false;
            }
            for(int i = 1; i < ps.length; i++){
                if(index[ps[i]] - index[ps[i-1]] != 1){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {91,4,64,78};
        int[][] pieces = {{78},{4,64},{91}};

        System.out.println(canFormArray(arr,pieces));
        
    }
}
