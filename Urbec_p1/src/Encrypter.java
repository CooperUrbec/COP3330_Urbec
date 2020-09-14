public class Encrypter {

    public Encrypter(){
    }

    public String encrypt(String str){

        int [] array = new int[4];

        //set up an int array that allows for encryption
        //and add 7 to each number then take mod 10
        for(int i = 0; i < 4; ++i){
            array[i] = Character.digit(str.charAt(i), 10);

            array[i] = (array[i] + 7) % 10;
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
