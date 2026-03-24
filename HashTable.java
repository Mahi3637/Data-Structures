/*You will have to complete the FruitNode Contrustor first
 then within this class you only have to complete two methods
 hashFunction() and insert()
 the rest of the metods are already written
 DO NOT TOUCH any other methods or codes*/
 public class HashTable {

    //ht[] :: is the HashTable array that stores the FruitNode objects
    private FruitNode[] ht;

    //Constructor that initializes the HashTable array
	//DO NOT change this Constructor
    public HashTable(int size){
        this.ht = new FruitNode[size];
    }
    
    //This method basically prints the HashTable
    //DO NOT change this method
    public void show(){
        for(int i=0; i<ht.length; i++){
            System.out.print( i+" " );
            FruitNode n = ht[i];
            while (n!=null){
                System.out.print("('"+n.fruit[0]+"', "+n.fruit[1]+") --> ");
                n = n.next;
            }
            System.out.println();
        }
    }

    //you need to COMPLETE this method
    private int hashFunction( String key ){
        // TO DO 

        int size = key.length();
        int sum = 0;

        if(size % 2 == 0){
            for (int i = 0; i<key.length(); i++){
                if (i % 2 == 0){
                    char ch = key.charAt(i);
                    sum += (int) ch;
                }
            }
        }

        else{
            for(int j = 0; j<key.length(); j++){
                if(j % 2 == 0){
                    char c = key.charAt(j);
                   sum+= (int) c;
                }
            }
        }
        return sum % ht.length;
    }

    //you need to COMPLETE this method
    //The insert() method will create a FruitNode using name(Key) & price(value)
	//then inserts it in the proper hashed index
    //If collision occurs resolve using the steps explained in the question
    public void insert(String key, Integer value){
        // TO DO

        int index = hashFunction(key);
        FruitNode newNode = new FruitNode(key, value);

       if(ht[index] == null){
           
            ht[index] = newNode;
       }
         else{
              FruitNode current = ht[index];
              while(current != null){
                if(current.fruit[0].equals(key)){
                    current.fruit[1] = value;
                    return;
                }

                if(current.next == null){
                    break;
                }

                current = current.next;
              }
              current.next = newNode;
         }
        
    }
}

