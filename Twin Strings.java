class Result {

    /*
     * Complete the 'twins' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY a
     *  2. STRING_ARRAY b
     */

    public static List<String> twins(List<String> a, List<String> b) {
    // Write your code here
        List<String> finalArr = new ArrayList<String>();
        int len = a.size() < b.size() ? a.size() : b.size();

        for(int i = 0 ; i < len; i++){
            if(a.get(i).length() == b.get(i).length()){
                finalArr.add(matchStrings(a.get(i), b.get(i)));
            } else {
                finalArr.add("No");
            }
        }

        return finalArr;
    }

    public static String matchStrings(String a, String b){
        List<Character> firstEven = new ArrayList<Character>();
        List<Character> firstOdd = new ArrayList<Character>();
        List<Character> secondEven = new ArrayList<Character>();
        List<Character> secondOdd = new ArrayList<Character>();
        String one, second;
        String res = "No";

        if(a.length() != b.length()){
            return res;
        }
        int len = a.length();

        for(int i = 0; i < len; i++){
            if(i%2 == 0){
                firstEven.add(a.charAt(i));
                secondEven.add(b.charAt(i));
            } else {
                firstOdd.add(a.charAt(i));
                secondOdd.add(b.charAt(i));
            }
        }

        Collections.sort(firstEven);
        Collections.sort(secondEven);

        one = firstEven.stream().map(Object::toString).collect(Collectors.joining(""));
        second = secondEven.stream().map(Object::toString).collect(Collectors.joining(""));

        if(one.equals(second)){
            Collections.sort(firstOdd);
            Collections.sort(secondOdd);

            one = firstOdd.stream().map(Object::toString).collect(Collectors.joining(""));
            second = secondOdd.stream().map(Object::toString).collect(Collectors.joining(""));

            if(one.equals(second)){
                res = "Yes";
            }
        }

        return res;
    }

}