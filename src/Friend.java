public class Friend extends Person{
    private boolean bestFriend;

    public Friend(String firstName, String lastName, String phoneNumber, boolean bestFriend) {
        super(firstName, lastName, phoneNumber);
        this.bestFriend = bestFriend;
    }

    public boolean isBestFriend() {
        return bestFriend;
    }

    @Override
    public String toString() {
        String s = super.toString();
        if (bestFriend){
            return s + " is a best friend";
        }
        else{
            return s + " is a friend";
        }
    }
}