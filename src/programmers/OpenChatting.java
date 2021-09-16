package programmers;

    import java.util.ArrayList;
    import java.util.HashMap;

public class OpenChatting {
    static String [] answer;
    public String[] solution(String[] record) {
        ArrayList<String>arr = new ArrayList<>();
        HashMap<String, String> user = new HashMap<>();
        for (int i = 0; i < record.length; i++){
            String[]com = record[i].split(" ");

            if (com[0].equals( "Enter")){
                arr.add(com[1] + "님이 들어왔습니다.");
                user.put(com[1],com[2]);
            }else if(com[0].equals("Change")){
                user.put(com[1],com[2] );
            }else{
                arr.add(com[1]+ "님이 나갔습니다.");
            }
        }
        answer = new String[arr.size()];
        for (int i = 0 ; i<arr.size(); i++){
            int idx = arr.get(i).indexOf("님");
            String changedId = arr.get(i).substring(0,idx);
            String [] temp = arr.get(i).split(" ");
            answer[i] = user.get(changedId) + "님이 " +temp[1];
        }
        return answer;
    }
}
