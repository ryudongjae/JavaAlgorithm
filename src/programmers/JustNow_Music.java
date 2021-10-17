package programmers;

public class JustNow_Music {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int MaxPlay = -1;

        m = changeM(m);
        for (String s : musicinfos) {
            String [] info = s.split(",");
            String title = info[2];

            String melInfo = changeM(info[3]);

            String[] time = info[0].split(":");
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            time = info[1].split(":");
            int end = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            int playtime = end - start;

            if (playtime >  melInfo.length()){
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < playtime/melInfo.length(); i++){
                    sb.append(melInfo);
                }
                sb.append(melInfo.substring(0,playtime%melInfo.length()));
                melInfo = sb.toString();
            }else {
                melInfo = melInfo.substring(0,playtime);
            }

            if (melInfo.contains(m) && playtime > MaxPlay){
                answer = title;
                MaxPlay = playtime;
            }
        }
        return  MaxPlay != -1 ? answer : "(None)";
    }

    private String changeM(String m) {
        m = m.replaceAll("C#","H");
        m = m.replaceAll("D#","I");
        m = m.replaceAll("F#","J");
        m = m.replaceAll("G#","K");
        String newM = m.replaceAll("A#","L");

        return newM;
    }
}
