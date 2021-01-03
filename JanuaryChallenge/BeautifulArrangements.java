package JanuaryChallenge;

public class BeautifulArrangements {
    static int count = 0;
    private static void beautifulArrangement(int[] index,int currIdx){
        if(currIdx == index.length){
            count++;
        }
        for(int i = currIdx; i < index.length ; i++){
            swap(index, i , currIdx);
            if(index[currIdx] % (currIdx+1) == 0 || (currIdx+1) % index[currIdx] == 0){
                beautifulArrangement(index, currIdx+1);
            }
            swap(index, i , currIdx);
        }
    }
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int n = 15;
        int[] index = new int[n];
        for(int i = 1; i <= n; i++){
            index[i-1] = i;
        }
      //  int count = 0;
        beautifulArrangement(index,0);
        System.out.println(count);
    }
}