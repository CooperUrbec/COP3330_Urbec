public class Decrypter {

    public Decrypter(){
    }

    public String decrypt(String str){

        int [] array = new int[4];

        //set up an int array that allows for encryption
        //additionally undo the mod 10 and plus 7
        for(int i = 0; i < 4; ++i){
            array[i] = Character.digit(str.charAt(i), 10);

            array[i] = ((array[i] + 10) - 7) % 10;
        }

        //call swap method
        array = swap(array);

        //convert array back into a string and return
        str = (array[0] + "" + array[1] + "" + array[2] + "" + array[3]);

        return str;
    }

    private int[] swap(int[] array){

        //swap the first digit with the third, and swap the second digit with the fourth
        int temp = array[0];
        array[0] = array[2];
        array[2] = temp;

        temp = array[1];
        array[1] = array[3];
        array[3] = temp;

        return array;
    }
}
