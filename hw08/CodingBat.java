public class CodingBat{

    public static String changeXY(String str) {
	int length= str.length();
	if (length == 0){
	    return str;
	}
	if (length == 1){
	    if (str.equals("x")){
		return "y";
	    }
	    else return str;
	}
	else {
	    String a = str.substring(0, 1);
	    if (a.equals("x")){
		a = "y";
	    }
	    return a + changeXY(str.substring(1, length));
	}
		    

    }


    public static String changePi(String str){
	int length = str.length();
	if (length <= 1){
	    return str;
	}
	else{
	    if (str.substring(0, 2).equals("pi")){
		return "3.14" + changePi(str.substring(2, length));
	    }
	    else {
		return str.substring(0, 1) + changePi(str.substring(1, length));
	    }
	}
    }

    public static boolean array6(int[] nums, int index){
	int length = nums.length;
	if (index >= length){
	    return false;
	}
	else if (nums[index] == 6){
	    return true;
	}
	else{
	    return array6(nums, index + 1);
	}
    }

    public static String pairStar(String str) {
	int length = str.length();
	if (length <= 1){
	    return str;
	}
	else{
	    String star = "";
	    if (str.substring(0, 1).equals(str.substring(1, 2))){
		star = "*";
	    }
	    return str.substring(0, 1) + star + pairStar(str.substring(1, length));

	}
    }


    public static String endX(String str) {
	int length = str.length();
	if (length <= 1){
	    return str;
	}
	else {
	    if (str.substring(0, 1).equals("x")){
		return endX(str.substring(1, length)) + "x";
	    }
	    else {
		return str.substring(0, 1) + endX(str.substring(1, length));
	    }
	}
    }

    public static int countPairs(String str){
	int length = str.length();
	if (length <= 2){
	    return 0;
	}
	else {
	    int num = 0;
	    if (str.substring(0, 1).equals(str.substring(2, 3))){
		num = 1;
	    }
	    return num + countPairs(str.substring(1, length));
	}
    }

    public static int countAbc(String str){
	int length = str.length();
	if (length < 3){
	    return 0;
	}
	else {
	    String substr = str.substring(0, 3);

	    if (substr.equals("abc") || substr.equals("aba")){

		return 1 + countAbc(str.substring(1, length));

	    }
	    else{
		return countAbc(str.substring(1, length));
	    }
	}
    }

    public static int count11(String str){
	int length = str.length();
	if (length <= 1){
	    return 0;
	}
	else{
	    String substr = str.substring(0, 2);
	    if (substr.equals("11")){
		return 1 + count11(str.substring(2, length));
	    }
	    else return count11(str.substring(1, length));
	}
    }


    public static String stringClean(String str){
	int length = str.length();
	if (length <= 1){
	    return str;
	}
	else{
	    if (str.substring(0, 1).equals(str.substring(1, 2))){
		return stringClean(str.substring(1, length));
	    }
	    else {
		return str.substring(0, 1) + stringClean(str.substring(1, length));
	    }
	}
    }


    public static int countHi2(String str){
	int length = str.length();
	if (length < 2){
	    return 0;
	}
	else{
	    int num = 0;
	    String last= str.substring(length - 2, length);
	    if (last.equals("hi")){
		if (length == 2 || (!(str.substring(length -3, length - 2).equals("x")))){
		    num = 1;
		}
	    }
	    return num + countHi2(str.substring(0, length - 1));
	}

    }


    public static String parenBit(String str){
	int firstIndex = str.indexOf("(");
	int secIndex = str.indexOf(")");
	int length = str.length();
	if (length == 0)
	    return str;
	else if (firstIndex == 0 && secIndex == length-1){
	    return str;
	}
	else{

	    if (firstIndex != 0){
		return parenBit(str.substring(1, length));
	    }
	    else{
		return parenBit(str.substring(0, length -1));
	    }	    
	} 
	
    }

    public static boolean nestParen(String str){
	int length = str.length();
	if (str.equals("") || str.equals("()")){
	    return true;
	}
	else {
	    if (str.substring(0, 1).equals("(") && str.substring(length - 1, length).equals(")")){
		return nestParen(str.substring(1, length - 1));
	    }
	    else return false;
	}
    }
	    
    public static int strCount(String str, String sub){
	int strlength = str.length();
	int sublength = sub.length();
	if (strlength < sublength){
	    return 0;
	}
	else{
	    if ( str.substring(0, sublength).equals(sub)){
		return 1 + strCount(str.substring(sublength , strlength), sub);
	    }
	    else return strCount(str.substring(1, strlength), sub);
	}
    }

    public static boolean strCopies(String str, String sub, int n){
	int strlength = str.length();
	int sublength = sub.length();
	if (n == 0){
	    return true;
	}
	else if (strlength < sublength) {
	    return false;
	}
	else {
	    if (str.substring(0, sublength).equals(sub)){
		return strCopies(str.substring(1, strlength), sub, n-1);
	    }
	    else return strCopies(str.substring(1, strlength), sub, n);
	}
    }

    public static int strDist(String str, String sub){
	int strlength = str.length();
	int sublength = sub.length();

	if (sublength  > strlength){
	    return 0;
	}
	else if (str.substring(0, sublength).equals(sub) && str.substring(strlength - sublength, strlength).equals(sub)){
	    return strlength;
	}
	else {
	    if (!(str.substring(0, sublength).equals(sub))){
		return strDist(str.substring(1, strlength), sub);
	    }
	    else return strDist(str.substring(0, strlength -1), sub);
	}
    }


    public static void main (String[] args){
	int[] nums1 = {1, 6, 4};
	
	int[] nums2 = {1,4};
	
	int[] nums3 = {6};
	System.out.println(strDist("catcowcat", "cat"));
	System.out.println(strDist("catcowcat", "cow") );
	System.out.println(strDist("cccatcowcatxx", "cat"));

    }
}