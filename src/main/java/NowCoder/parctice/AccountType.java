package NowCoder.parctice;

/**
 * Created by kevin on 16-8-8.
 */
enum AccountType {
    SAVING, FIXED, CURRENT;

    private AccountType() {
        System.out.println("It is a account type");
    }
}

class EnumOne{
    public static void main(String[] args) {
        System.out.println(AccountType.FIXED);
    }
}
